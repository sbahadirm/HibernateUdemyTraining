package domain;

import enums.EnumUrunTuru;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "URUN_TURU")
public class UrunTuru {

    @GeneratedValue(generator = "urunturu", strategy = GenerationType.SEQUENCE)
    @Id
    @SequenceGenerator(name = "urunturu", sequenceName = "URUN_TURU_ID_SEQ")
    private Long id;

    @Column(name = "ADI", length = 100)
    private String adi;

    // enum turu
    @Enumerated(EnumType.STRING)
    @Column(name = "TUR", length = 30)
    private EnumUrunTuru urunTuru;

    //
    @OneToMany(mappedBy = "urunTuru", cascade = CascadeType.ALL)
    private List<Urun> urunler = new ArrayList<Urun>();

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

    public EnumUrunTuru getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(EnumUrunTuru urunTuru) {
        this.urunTuru = urunTuru;
    }

    public List<Urun> getUrunler() {
        return urunler;
    }

    public void setUrunler(List<Urun> urunler) {
        this.urunler = urunler;
    }

    public void addUrun(Urun urun) {
        urunler.add(urun);
        urun.setUrunTuru(this);
    }
}
