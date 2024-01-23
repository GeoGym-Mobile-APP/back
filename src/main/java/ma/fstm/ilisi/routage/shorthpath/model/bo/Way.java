package ma.fstm.ilisi.routage.shorthpath.model.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "ways")
public class Way {


    @Column(name = "lon")
    private Double lon;

    @Column(name = "lat")
    private Double lat;
    @Id
    private Long id;

    // Constructeurs
    public Way() {
        // Constructeur par défaut
    }

    public Way(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    // Getters et Setters


    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
    @Override
    public String toString() {
        return "Way{" +
                "lon=" + lon +
                ", lat=" + lat +
                // Ajoutez d'autres champs si nécessaire
                '}';
    }


}
