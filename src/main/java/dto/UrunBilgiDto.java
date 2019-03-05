package dto;

import enums.EnumUrunTuru;

import java.math.BigDecimal;

public class UrunBilgiDto {

    private Long id;
    private String adi;
    private BigDecimal fiyat;
    private String urunTuruAdi;
    private EnumUrunTuru urunTuru;

    public UrunBilgiDto(Long id, String adi, BigDecimal fiyat, String urunTuruAdi, EnumUrunTuru urunTuru) {
        this.id = id;
        this.adi = adi;
        this.fiyat = fiyat;
        this.urunTuruAdi = urunTuruAdi;
        this.urunTuru = urunTuru;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    public String getUrunTuruAdi() {
        return urunTuruAdi;
    }

    public void setUrunTuruAdi(String urunTuruAdi) {
        this.urunTuruAdi = urunTuruAdi;
    }

    public EnumUrunTuru getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(EnumUrunTuru urunTuru) {
        this.urunTuru = urunTuru;
    }

    @Override
    public String toString() {
        return "UrunBilgiDto{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                ", urunTuruAdi='" + urunTuruAdi + '\'' +
                ", urunTuru=" + urunTuru +
                '}';
    }
}
