package dto;

import java.math.BigDecimal;

public class UrunDto {

    private Long id;
    private BigDecimal fiyat;

    public UrunDto(Long id, BigDecimal fiyat) {
        this.id = id;
        this.fiyat = fiyat;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "UrunDto{" +
                "id=" + id +
                ", fiyat=" + fiyat +
                '}';
    }
}
