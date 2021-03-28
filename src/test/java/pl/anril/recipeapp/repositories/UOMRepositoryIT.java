package pl.anril.recipeapp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.anril.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UOMRepositoryIT {
    @Autowired
    UOMRepository uomRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByDescription() {
        Optional<UnitOfMeasure> retVal = uomRepository.findByDescription("Teaspoon");
        assertThat(retVal.get().getDescription(), equalTo("Teaspoon"));
    }

    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> retVal = uomRepository.findByDescription("Cup");
        assertThat(retVal.get().getDescription(), equalTo("Cup"));
    }
}