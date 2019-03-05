package domain;

import enums.EnumBirim;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "URUN", indexes = @Index(name = "IX_URUN_URUN_TURU", columnList = "ID_URUN_TURU"))
public class Urun {

    @GeneratedValue(generator = "urun", strategy = GenerationType.SEQUENCE)
    @Id
    @SequenceGenerator(name = "urun", sequenceName = "URUN_ID_SEQ")
    private Long id;

    @Column(name = "ADI", length = 100)
    private String adi;

    @Column(name = "FIYAT", precision = 15, scale = 2)
    private BigDecimal fiyat;

    @Temporal(TemporalType.DATE)
    @Column(name = "SON_KULLANMA_TARIHI")
    private Date sonKullanmaTarihi;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_URUN_TURU", foreignKey = @ForeignKey(name = "FK_URUN_URUN_TURU"))
    private UrunTuru urunTuru;

    @Column(name = "STOK_MIKTARI")
    private Long stokMiktari;

    // enum birim
    @Enumerated(EnumType.STRING)
    @Column(name = "STOK_BIRIMI", length = 30)
    private EnumBirim stokBirimi;

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

    public Date getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(Date sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public UrunTuru getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(UrunTuru urunTuru) {
        this.urunTuru = urunTuru;
    }

    public Long getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(Long stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public EnumBirim getStokBirimi() {
        return stokBirimi;
    }

    public void setStokBirimi(EnumBirim stokBirimi) {
        this.stokBirimi = stokBirimi;
    }
}
