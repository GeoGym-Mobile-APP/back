package ma.fstm.ilisi.routage.shorthpath.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "salle_de_sport")
public class SalleSportObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JsonProperty("id")
    public Long getId() {
        return id;
    }
    @Column(name = "nom")
    @JsonProperty("nom")
    private String nom;

    @Column(name = "numero_telephone")
    @JsonProperty("numeroTelephone")
    private String numeroTelephone;




    @Column(name = "equipements")
    @JsonProperty("equipements")
    private String equipements;

    @ElementCollection
    @Column(name = "equipements", columnDefinition = "text[]")
    private List<String> equipementsArray;

    @Column(name = "heure_ouverture")
    @JsonProperty("heureOuverture")
    private String heureOuverture;

    @Column(name = "heure_fermeture")
    @JsonProperty("heureFermeture")
    private String heureFermeture;

    @Column(name = "type_activite")
    @JsonProperty("typeActivite")
    private String typeActivite;

    @Column(name = "tarif_adhesion_mensuelle")
    @JsonProperty("tarifAdhesionMensuelle")
    private double tarifAdhesionMensuelle;

    @Column(name = "tarif_adhesion_annuelle")
    @JsonProperty("tarifAdhesionAnnuelle")
    private double tarifAdhesionAnnuelle;

    @Column(name = "latitude")
    @JsonProperty("latitude")
    private double latitude;

    @Column(name = "longitude")
    @JsonProperty("longitude")
    private double longitude;

    // Collection of Objectif instances
    @OneToMany(mappedBy = "salleAppartient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("objectifs")
    private List<ObjectifObj> objectifs;

    public List<String> getEquipementsArray() {
        return equipementsArray;
    }
    public void setEquipementsArray(String equipements) {
        if (equipements != null) {
            this.equipementsArray = Arrays.asList(equipements.split(", "));
        } else {
            this.equipementsArray = new ArrayList<>();
        }
        this.equipements = equipements;
    }

    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
        this.equipementsArray = Arrays.asList(equipements.split(", "));
    }
    public SalleSportObj(String nom, String numeroTelephone, String equipements, String heureOuverture, String heureFermeture, String typeActivite, double tarifAdhesionMensuelle, double tarifAdhesionAnnuelle, double latitude, double longitude) {
        this.nom = nom;
        this.numeroTelephone = numeroTelephone;
        this.equipements = equipements;
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
        this.typeActivite = typeActivite;
        this.tarifAdhesionMensuelle = tarifAdhesionMensuelle;
        this.tarifAdhesionAnnuelle = tarifAdhesionAnnuelle;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public SalleSportObj() {
    }

    @Override
    public String toString() {
        return "SalleSportObj{" +
                "nom='" + nom + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", equipements=" + equipements +
                ", heureOuverture='" + heureOuverture + '\'' +
                ", heureFermeture='" + heureFermeture + '\'' +
                ", typeActivite='" + typeActivite + '\'' +
                ", tarifAdhesionMensuelle=" + tarifAdhesionMensuelle +
                ", tarifAdhesionAnnuelle=" + tarifAdhesionAnnuelle +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", objectifs="+objectifs+
                '}';
    }
}
