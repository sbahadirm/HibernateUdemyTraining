package dto;

import java.math.BigDecimal;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class UrunTuruDto {

    private Long id;
    private String adi;
    private BigDecimal minFiyat;
    private BigDecimal maxFiyat;
    private Double ortalamaFiyat;
    private Long toplamStokMiktari;
    private Long toplamUrunSayisi;

    public UrunTuruDto(Long id, String adi, BigDecimal minFiyat, BigDecimal maxFiyat, Double ortalamaFiyat, Long toplamStokMiktari, Long toplamUrunSayisi) {
        this.id = id;
        this.adi = adi;
        this.minFiyat = minFiyat;
        this.maxFiyat = maxFiyat;
        this.ortalamaFiyat = ortalamaFiyat;
        this.toplamStokMiktari = toplamStokMiktari;
        this.toplamUrunSayisi = toplamUrunSayisi;
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

    public BigDecimal getMinFiyat() {
        return minFiyat;
    }

    public void setMinFiyat(BigDecimal minFiyat) {
        this.minFiyat = minFiyat;
    }

    public BigDecimal getMaxFiyat() {
        return maxFiyat;
    }

    public void setMaxFiyat(BigDecimal maxFiyat) {
        this.maxFiyat = maxFiyat;
    }

    public Double getOrtalamaFiyat() {
        return ortalamaFiyat;
    }

    public void setOrtalamaFiyat(Double ortalamaFiyat) {
        this.ortalamaFiyat = ortalamaFiyat;
    }

    public Long getToplamStokMiktari() {
        return toplamStokMiktari;
    }

    public void setToplamStokMiktari(Long toplamStokMiktari) {
        this.toplamStokMiktari = toplamStokMiktari;
    }

    public Long getToplamUrunSayisi() {
        return toplamUrunSayisi;
    }

    public void setToplamUrunSayisi(Long toplamUrunSayisi) {
        this.toplamUrunSayisi = toplamUrunSayisi;
    }

    @Override
    public String toString() {
        return "UrunTuruDto{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", minFiyat=" + minFiyat +
                ", maxFiyat=" + maxFiyat +
                ", ortalamaFiyat=" + ortalamaFiyat +
                ", toplamStokMiktari=" + toplamStokMiktari +
                ", toplamUrunSayisi=" + toplamUrunSayisi +
                '}';
    }
}
