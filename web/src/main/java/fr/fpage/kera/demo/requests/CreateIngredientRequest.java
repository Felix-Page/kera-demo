package fr.fpage.kera.demo.requests;

import jakarta.validation.constraints.NotBlank;

public record CreateIngredientRequest(@NotBlank String name) {
}
