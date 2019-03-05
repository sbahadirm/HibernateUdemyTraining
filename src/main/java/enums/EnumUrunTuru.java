package enums;

public enum  EnumUrunTuru {

    YIYECEK("Yiyecek"),
    ICECEK("Icecek"),
    GIYECEK("Giyecek"),
    YAKACAK("Yakacak"),
    TUKETIM_MALZEMESI("Tuketim Malzemesi");

    private final String turu;

    EnumUrunTuru(String turu){
        this.turu = turu;
    }

    public String getTuru() {
        return turu;
    }
}
