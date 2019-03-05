package enums;

public enum EnumBirim {

    ADET("Adet"),
    KILO("Kilo"),
    LITRE("Litre"),
    PORSIYON("Porsiyon"),
    PAKET("Paket");

    private final String birim;

    EnumBirim(String birim){
        this.birim = birim;
    }

    public String getBirim() {
        return birim;
    }
}
