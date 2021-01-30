package pl.anril.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UOMRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
