package main;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

import com.ctc.wstx.api.WstxOutputProperties;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import model.ilias.Export;
import model.ilias.ExportItem;
import model.ilias.Manifest;
import model.ilias.qpl.ContentObject;
import model.ilias.qpl.PageObject;
import model.ilias.qpl.Question;
import model.ilias.qpl.TriggerQuestion;
import model.ilias.qti.IdentEnum;
import model.ilias.qti.Item;
import model.ilias.qti.Itemfeedback;
import model.ilias.qti.Qtimetadatafield;
import model.ilias.qti.Questestinterop;
import model.ilias.qti.RcardinalityEnum;
import model.ilias.qti.Respcondition;
import model.ilias.qti.ResponseLabel;
import model.pruefungsfragenquiz.Frage;
import model.pruefungsfragenquiz.Pruefungsfragenquiz;
import model.pruefungsfragenquiz.Quiz;
import net.lingala.zip4j.ZipFile;

public class Pruefungsfragenquiz2Ilias {

    private static final String API_URL = "https://services.dlrg.net/service.php?doc=quiz";

    public static void main(String[] args) throws IOException {

        ObjectMapper om = new ObjectMapper();

        TokenEnum token = null;
        Integer quiz = 0;
        if (args.length == 2) {
            token = TokenEnum.valueOf(args[0].toUpperCase());
            quiz = Integer.valueOf(args[1]);
        } else {
            while (token == null) {
                System.out.println("Bereich auswaehlen {schwimmen, iuk, boot, einsatztauchen, sporttauchen, wrd}:");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String in = reader.readLine().toUpperCase();
                try {
                    token = TokenEnum.valueOf(in);
                } catch (IllegalArgumentException e) {
                    System.err.println("Ungueltiger Bereich! Erneut versuchen:");
                }
            }
            System.out.println("Quiz auswählen:");
            Pruefungsfragenquiz pfq = om.readValue(
                    getImageBytes(API_URL + "&quizSelection=" + quiz + "&all=1&token=" + token.getToken()),
                    Pruefungsfragenquiz.class);
            List<Integer> quizzes = new ArrayList<>();
            for (Quiz q : pfq.getQuizzes().getQuizzes().values()) {
                System.out.println(q.getId() + ") " + q.getBezeichnung());
                quizzes.add(q.getId());
            }
            while (quiz == 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    quiz = Integer.valueOf(reader.readLine());
                } catch (Exception e) {
                    System.err.println("Ungueltige Eingabe! Erneut versuchen:");
                }
            }

        }

        String iliasId = "1337";
        String host = "http://localhost";

        Pruefungsfragenquiz pfq = om.readValue(
                getImageBytes(API_URL + "&quizSelection=" + quiz + "&all=1&token=" + token.getToken()),
                Pruefungsfragenquiz.class);
        Integer id = pfq.getQuiz().getId();

        Map<Integer, String> assets = downloadAssets(pfq.getAdditional("assetIds"));

        Manifest manifest = generateManifest(host, id, pfq.getQuiz().getBezeichnung());
        Export export = generateExport(host, iliasId, id);
        ContentObject qpl = generateQpl(iliasId, id, pfq.getQuiz().getBezeichnung(), pfq.getFragenIds());
        Questestinterop qti = generateQti(iliasId, pfq.getFragen().getFragen().values(), assets);

        write(iliasId, id, manifest, export, qpl, qti);
    }

    private static Map<Integer, String> downloadAssets(Object assetIds) throws IOException {
        Map<Integer, String> assets = new HashMap<>();
        if (assetIds == null || assetIds instanceof List) {
            return assets;
        }
        for (Entry<String, Object> asset : ((Map<String, Object>) assetIds).entrySet()) {
            String url = "https://www.dlrg.net/global/Apps/Asset/assetService.php?db=pruefungsfragen_boot&aid="
                    + ((Map<String, String>) asset.getValue()).get("frage");
            byte[] arr = getImageBytes(url);
            assets.put(Integer.valueOf(asset.getKey()), Base64.getEncoder().encodeToString(arr));
        }
        return assets;
    }

    private static Manifest generateManifest(String host, Integer id, String name) {
        Manifest manifest = new Manifest();
        manifest.setTitle(name);
        manifest.setInstallationId(String.valueOf(id));
        manifest.setInstallationUrl(host);

        return manifest;
    }

    private static Export generateExport(String host, String iliasId, Integer id) {
        Export export = new Export();
        export.setInstallationId(iliasId);
        export.setInstallationUrl(host);
        ExportItem exportItem = new ExportItem();
        exportItem.setId(String.valueOf(id));
        export.getExportItems().add(exportItem);
        return export;
    }

    private static ContentObject generateQpl(String iliasId, Integer id, String title, List<String> fragenIds) {
        ContentObject co = new ContentObject();
        co.getMetaData().getGeneral().getIdentifier().setEntry("il_" + iliasId + "_qpl_" + id);
        co.getMetaData().getGeneral().getTitle().setTitle(title);

        fragenIds.forEach(fi -> {
            co.getQuestionSkillAssignments().getTriggerQuestion().add(new TriggerQuestion(fi));
            co.getPageObject().add(new PageObject(new Question("il_" + iliasId + "_qst_" + fi)));
        });
        return co;
    }

    private static Questestinterop generateQti(String iliasId, Collection<Frage> fragen, Map<Integer, String> assets) {

        Set<Frage> multiple = new HashSet<>();
        fragen.forEach(f -> {
            if (f.getAnzAwKorrekt() > 1) {
                multiple.add(f);
            }
        });
        boolean isMultiplechoice = !multiple.isEmpty();

        Questestinterop qti = new Questestinterop();
        fragen.forEach(f -> {
            Item i = new Item();
            qti.getItem().add(i);

            i.setIdent("il_" + iliasId + "_qst_" + f.getId());
            i.setTitle("Frage " + (f.getCode().length() > 0 ? f.getCode() : f.getId()));
            addMetadata(i.getItemMetadata().getQtimetadata().getQtimetadatafield());

            i.getPresentation().setLabel("Frage " + (f.getCode().length() > 0 ? f.getCode() : f.getId()));
            i.getPresentation().getFlow().getMaterial().getMattext().setText(f.getFrage());
            if (assets.containsKey(f.getId())) {
                String text = i.getPresentation().getFlow().getMaterial().getMattext().getText();
                text += "<img src=\"data:image/png;base64, " + assets.get(f.getId()) + "\" />";
                i.getPresentation().getFlow().getMaterial().getMattext().setText(text);

            }

            if (isMultiplechoice) {
                i.getPresentation().getFlow().getResponseLid().setIdent(IdentEnum.MCMR);
                i.getPresentation().getFlow().getResponseLid().setRcardinality(RcardinalityEnum.Multiple);
                Qtimetadatafield mcm = new Qtimetadatafield();
                mcm.setFieldlabel("QUESTIONTYPE");
                mcm.setFieldentry("MULTIPLE CHOICE QUESTION");
                i.getItemMetadata().getQtimetadata().getQtimetadatafield().add(mcm);
            } else {
                i.getPresentation().getFlow().getResponseLid().setIdent(IdentEnum.MCSR);
                i.getPresentation().getFlow().getResponseLid().setRcardinality(RcardinalityEnum.Single);
                Qtimetadatafield scm = new Qtimetadatafield();
                scm.setFieldlabel("QUESTIONTYPE");
                scm.setFieldentry("SINGLE CHOICE QUESTION");
                i.getItemMetadata().getQtimetadata().getQtimetadatafield().add(scm);
            }
            for (int ii = 0; ii < f.getAntworten().size(); ii++) {
                if (f.getAntworten().get(ii) == null || f.getAntworten().get(ii).isEmpty()) {
                    continue;
                }
                ResponseLabel rl = new ResponseLabel();
                rl.getMaterial().getMattext().setText(f.getAntworten().get(ii));
                rl.setIdent(String.valueOf(ii));
                i.getPresentation().getFlow().getResponseLid().getRenderChoice().getResponseLabel().add(rl);
                Itemfeedback itemFeedback = new Itemfeedback();
                itemFeedback.setIdent("response_" + ii);
                itemFeedback.getFlowMat().getMaterial().getMattext().setText("");
                i.getItemfeedback().add(itemFeedback);

                Respcondition rc = new Respcondition();
                rc.getConditionvar().getVarequal()
                        .setRespident(i.getPresentation().getFlow().getResponseLid().getIdent());
                rc.getConditionvar().getVarequal().setIdent(String.valueOf(ii));
                if (ii < f.getAnzAwKorrekt()) {
                    rc.getSetvar().setVar("1");
                } else {
                    rc.getSetvar().setVar("0");
                }
                rc.getDisplayfeedback().setLinkrefid("response_" + ii);
                i.getResprocessing().getRespcondition().add(rc);
            }
        });
        return qti;
    }

    private static void addMetadata(List<Qtimetadatafield> metadata) {
        Qtimetadatafield iliasVersion = new Qtimetadatafield();
        iliasVersion.setFieldlabel("ILIAS_VERSION");
        iliasVersion.setFieldentry("7.14 2022-09-26");
        metadata.add(iliasVersion);
        Qtimetadatafield editMode = new Qtimetadatafield();
        editMode.setFieldlabel("additional_cont_edit_mode");
        editMode.setFieldentry("default");
        metadata.add(editMode);
        Qtimetadatafield iliasLifecycle = new Qtimetadatafield();
        iliasLifecycle.setFieldlabel("ilias_lifecycle");
        iliasLifecycle.setFieldentry("draft");
        metadata.add(iliasLifecycle);
        Qtimetadatafield lifecycle = new Qtimetadatafield();
        lifecycle.setFieldlabel("lifecycle");
        lifecycle.setFieldentry("draft");
        metadata.add(lifecycle);
        Qtimetadatafield thumbSize = new Qtimetadatafield();
        thumbSize.setFieldlabel("thumb_size");
        thumbSize.setFieldentry("");
        metadata.add(thumbSize);
        Qtimetadatafield feedbackSetting = new Qtimetadatafield();
        feedbackSetting.setFieldlabel("feedback_setting");
        feedbackSetting.setFieldentry("1");
        metadata.add(feedbackSetting);
        Qtimetadatafield singleline = new Qtimetadatafield();
        singleline.setFieldlabel("singleline");
        singleline.setFieldentry("1");
        metadata.add(singleline);
    }

    private static byte[] getImageBytes(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (InputStream stream = url.openStream()) {
            byte[] buffer = new byte[4096];

            while (true) {
                int bytesRead = stream.read(buffer);
                if (bytesRead < 0) {
                    break;
                }
                output.write(buffer, 0, bytesRead);
            }
        }

        return output.toByteArray();
    }

    private static void write(String iliasId, Integer id, Manifest manifest, Export export, ContentObject qpl,
            Questestinterop qti) throws StreamWriteException, DatabindException, IOException {
        Long timestamp = System.currentTimeMillis();
        timestamp /= 1000;

        File folder = new File(timestamp + "__" + iliasId + "__qpl_" + id);
        new File(folder, "objects").mkdir();
        File set1Folder = new File(folder, "Modules/TestQuestionPool/set_1");
        set1Folder.mkdirs();
        folder.mkdir();

        XmlMapper xm = new XmlMapper();
        xm.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xm.getFactory().getXMLOutputFactory().setProperty(WstxOutputProperties.P_USE_DOUBLE_QUOTES_IN_XML_DECL, true);

        xm.writeValue(new File(set1Folder, "export.xml"), export);
        xm.writeValue(new File(folder, "manifest.xml"), manifest);
        xm.writeValue(new File(folder, timestamp + "__" + iliasId + "__qpl_" + id + ".xml"), qpl);
        xm.writeValue(new File(folder, timestamp + "__" + iliasId + "__qti_" + id + ".xml"), qti);

        new ZipFile(timestamp + "__" + iliasId + "__qpl_" + id + ".zip").addFolder(folder);
        FileUtils.deleteDirectory(folder);
    }

}
