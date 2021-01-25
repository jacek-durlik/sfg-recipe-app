package pl.anril.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.recipeapp.domain.UnitOfMeasure;

public interface UOMRepository extends CrudRepository<UnitOfMeasure, Long> {
}
