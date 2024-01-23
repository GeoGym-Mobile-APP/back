package ma.fstm.ilisi.routage.shorthpath.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity
@Table(name = "mouvement")
public class MouvementObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    @JsonProperty("nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "exerciceAppartient")
    private ExerciceObj exerciceAppartient;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // toString() method
    @Override
    public String toString() {
        return "MouvementObj{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
