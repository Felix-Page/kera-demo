package fr.fpage.kera.demo.entities;

import fr.fpage.kera.persistence.entity.ReferenceableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "ingredient")
public class IngredientEntity extends AbstractEntity implements ReferenceableEntity {
    @Column(nullable = false, unique = true)
    private String name;

    public IngredientEntity() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
