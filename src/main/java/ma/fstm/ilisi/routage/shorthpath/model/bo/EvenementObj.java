package ma.fstm.ilisi.routage.shorthpath.model.bo;
import jakarta.persistence.*;

@Entity
@Table(name = "evenement")
public class EvenementObj {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;

    public EvenementObj() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public EvenementObj(long id,Double longitude, Double latitude) {
        this.id=id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "{" +
                "id="+ id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public long getId() {
        return id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
