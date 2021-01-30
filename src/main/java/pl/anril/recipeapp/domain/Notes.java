package pl.anril.recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
