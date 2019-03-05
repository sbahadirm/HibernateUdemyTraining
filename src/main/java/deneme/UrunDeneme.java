package deneme;

import javax.persistence.*;
import java.math.BigDecimal;

@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "User.temp",
                        query = "select email, phone  from URUN_DENEME u  where u.email=:email",
                        resultSetMapping = "UserMapper"
                )
        }
)
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "UserMapper",
                entities = {
                        @EntityResult(
                                entityClass = UrunDeneme.class,
                                fields = {
                                        @FieldResult(name = "email", column = "email"),
                                        @FieldResult(name = "phone", column = "phone"),
                                }
                        )
                }
        )
})
@Entity
@Table(name = "URUN_DENEME")
public class UrunDeneme {

    @GeneratedValue(generator = "urundeneme", strategy = GenerationType.SEQUENCE)
    @Id
    @SequenceGenerator(name = "urundeneme", sequenceName = "URUN_DENEME_ID_SEQ")
    private Long id;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", precision = 15, scale = 2)
    private BigDecimal phone ;

    @Column(length = 100, name = "sifre")
    private String sifre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPhone() {
        return phone;
    }

    public void setPhone(BigDecimal phone) {
        this.phone = phone;
    }


}
