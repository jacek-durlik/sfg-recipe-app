package pl.anril.recipeapp.service;

import pl.anril.recipeapp.domain.UnitOfMeasure;

import java.lang.Character.UnicodeBlock;
import java.util.Set;

public interface UOMService {
    Set<UnitOfMeasure> findAll();
    UnitOfMeasure findById(Long id);
}
