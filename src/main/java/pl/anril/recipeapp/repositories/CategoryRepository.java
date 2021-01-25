package pl.anril.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
