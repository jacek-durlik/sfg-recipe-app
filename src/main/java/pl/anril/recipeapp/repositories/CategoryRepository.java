package pl.anril.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.recipeapp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
