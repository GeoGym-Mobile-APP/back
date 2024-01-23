package ma.fstm.ilisi.routage.shorthpath.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "plans")
public class PlanObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "duree")
    @JsonProperty("duree")
    private Integer duree;

    @OneToMany(mappedBy = "planAppartient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("exercices")
    private List<ExerciceObj> exercices;

    @ManyToOne
    @JoinColumn(name = "objectif_appartient_id")
    private ObjectifObj objectifAppartient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // toString() method
    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", duree=" + duree +
                ", exercices=" + exercices +
                '}';
    }
}
