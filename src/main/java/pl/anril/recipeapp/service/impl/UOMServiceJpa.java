package pl.anril.recipeapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.anril.recipeapp.domain.UnitOfMeasure;
import pl.anril.recipeapp.repositories.UOMRepository;
import pl.anril.recipeapp.service.UOMService;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UOMServiceJpa implements UOMService {
    private final UOMRepository uomRepository;
    @Override
    public Set<UnitOfMeasure> findAll() {
        final Set<UnitOfMeasure> retSet = new HashSet<>();
        uomRepository.findAll().forEach(u->retSet.add(u));
        return retSet;
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return uomRepository.findById(id).orElse(null);
    }
}
