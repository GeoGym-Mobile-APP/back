package ma.fstm.ilisi.routage.shorthpath.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "exercice")
public class ExerciceObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    @JsonProperty("nom")
    private String nom;

    @Column(name = "description", columnDefinition = "TEXT")
    @JsonProperty("description")
    private String description;

    @Column(name = "niveau_difficulte")
    @JsonProperty("niveauDifficulte")
    private int niveauDifficulte;

    @Column(name = "duree")
    @JsonProperty("duree")
    private int duree;

    @ManyToOne
    @JoinColumn(name = "plan_appartient_id")
    private PlanObj planAppartient;

    @OneToMany(mappedBy = "exerciceAppartient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("mouvements")
    private List<MouvementObj> mouvement;


    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    // toString() method
    @Override
    public String toString() {
        return "ExerciceObj{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", niveauDifficulte=" + niveauDifficulte +
                ", duree=" + duree +
                ",plans="+planAppartient+
                '}';
    }
}
