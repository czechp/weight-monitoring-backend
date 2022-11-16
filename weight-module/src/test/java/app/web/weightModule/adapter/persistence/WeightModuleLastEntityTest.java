package app.web.weightModule.adapter.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeightModuleLastEntityTest {

    @Test()
    @DisplayName("Extends WeightModuleSuperEntity")
    void extendsWeightModuleSuperEntityTest() {
        //given
        //when
        //then
        assertTrue(WeightModuleSuperEntity.class.isAssignableFrom(WeightModuleLastEntity.class));
    }

    @Test
    @DisplayName("Additional fields")
    void haveAdditionalFields() {
        //given
        final var incorrectProductPcs = 111L;
        final var weightDifference = -100.1f;
        final var correctProductPercent = 98.2f;
        final var correctToOverdosePercent = 11.3f;
        final var notRefilledProductPcs = 421L;
        final var overFilledProductPcs = 231L;
        final var overFilledToNotRefilledPercent = 55.6f;

        //when
        WeightModuleLastEntity entity = new WeightModuleLastEntity(
                0L,
                0L,
                null,
                0f,
                0f,
                0,
                0f,
                false,
                0f,
                0l,
                correctProductPercent,
                incorrectProductPcs,
                weightDifference,
                correctToOverdosePercent,
                notRefilledProductPcs,
                overFilledProductPcs,
                overFilledToNotRefilledPercent
        );
        //then
        assertEquals(incorrectProductPcs, entity.getIncorrectProductPcs());
        assertEquals(weightDifference, entity.getWeightDifference());
        assertEquals(correctProductPercent, entity.getCorrectProductPercent());
        assertEquals(notRefilledProductPcs, entity.getNotRefilledProductPcs());
        assertEquals(overFilledProductPcs, entity.getOverFilledProductPcs());
        assertEquals(overFilledToNotRefilledPercent, entity.getOverFilledToNotRefilledPercent());

    }
}