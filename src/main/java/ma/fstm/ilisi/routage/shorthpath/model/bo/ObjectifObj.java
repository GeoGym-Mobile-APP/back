package ma.fstm.ilisi.routage.shorthpath.model.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "objectifs")
public class ObjectifObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    @Column(name = "nom")
    @JsonProperty("nom")
    private String nom;

    @Column(name = "description", columnDefinition = "TEXT")
    @JsonProperty("description")
    private String description;

    @OneToMany(mappedBy = "objectifAppartient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("plans")
    private List<PlanObj> plansObjectif;

    @ManyToOne
    @JoinColumn(name = "salle_appartient")
    @JsonIgnoreProperties("objectifs")
    private SalleSportObj salleAppartient;

    @Override
    public String toString() {
        return "Objectif{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", plans=" + plansObjectif +
                '}';
    }
}
