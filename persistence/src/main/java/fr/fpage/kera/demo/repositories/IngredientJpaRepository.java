package fr.fpage.kera.demo.repositories;

import fr.fpage.kera.demo.entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IngredientJpaRepository extends JpaRepository<IngredientEntity, UUID> {
}
