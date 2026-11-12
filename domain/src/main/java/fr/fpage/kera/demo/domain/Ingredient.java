package fr.fpage.kera.demo.domain;

import fr.fpage.kera.domain.VersionedDomain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ingredient extends VersionedDomain<UUID> {
    private String name;

    public Ingredient(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, Long version, String name) {
        super(id, createdAt, updatedAt, version);
        validateName(name);
        this.name = name;
    }

    public static Ingredient create(String name) {
        return new Ingredient(null, null, null, null, name);
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ingredient name must not be blank");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }
}
