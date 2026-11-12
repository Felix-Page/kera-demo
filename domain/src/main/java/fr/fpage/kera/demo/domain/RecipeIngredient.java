package fr.fpage.kera.demo.domain;

import fr.fpage.kera.domain.VersionedDomain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class RecipeIngredient extends VersionedDomain<UUID> {
    private Ingredient ingredient;
    private double quantity;
    private Unit unit;

    public RecipeIngredient(
            UUID id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Long version,
            Ingredient ingredient,
            double quantity,
            Unit unit
    ) {
        super(id, createdAt, updatedAt, version);
        validateQuantity(quantity);
        this.ingredient = Objects.requireNonNull(ingredient, "Ingredient must not be null");
        this.quantity = quantity;
        this.unit = Objects.requireNonNull(unit, "Unit must not be null");
    }

    private static void validateQuantity(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be strictly positive");
        }
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = Objects.requireNonNull(ingredient, "Ingredient must not be null");
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = Objects.requireNonNull(unit, "Unit must not be null");
    }

    public double scaleQuantity(int baseServings, int targetServings) {
        if (baseServings <= 0 || targetServings <= 0) {
            throw new IllegalArgumentException("Servings must be strictly positive");
        }
        return this.quantity * ((double) targetServings / baseServings);
    }
}
