package main;

public enum TokenEnum {
    SCHWIMMEN("097177a6313d298aef230928e5ea9631"),
    IUK("7e46a506afb67e3343d3616cdf0edcfe"),
    BOOT("3d012c1e01788435e8992eac9ee12814"),
    EINSATZTAUCHEN("0a184e41106a811c00753b57b6727bc0"),
    SPORTTAUCHEN("4260ad6f6becdb131d8f87d9a8bbcda7"),
    WRD("f398d62d1d3386228d67544136ffc8db");

    public final String token;

    private TokenEnum(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
