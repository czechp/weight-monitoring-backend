package app.web.weightModule.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleLastInfoQueryVOTest {

    @Test
    @DisplayName("Class exists")
    void classExistsTest() {
        //given
        final var incorrectProductPcs = 111L;
        final var weightDifference = -100.1f;
        final var correctProductPercent = 98.2f;
        final var correctToOverdosePercent = 11.3f;
        final var notRefilledProductPcs = 421L;
        final var overFilledProductPcs = 231L;
        final var overFilledToNotRefilledPercent = 55.6f;
        //when
        ModuleLastInfoVO moduleVO = new ModuleLastInfoVO(
                incorrectProductPcs,
                weightDifference,
                correctToOverdosePercent,
                notRefilledProductPcs,
                overFilledProductPcs,
                overFilledToNotRefilledPercent
        );
        //then
        assertEquals(incorrectProductPcs, moduleVO.getIncorrectProductPcs());
        assertEquals(weightDifference, moduleVO.getWeightDifference());
        assertEquals(correctToOverdosePercent, moduleVO.getCorrectToOverdosePercent());
        assertEquals(notRefilledProductPcs, moduleVO.getNotRefilledProductPcs());
        assertEquals(overFilledProductPcs, moduleVO.getOverFilledProductPcs());
        assertEquals(overFilledToNotRefilledPercent, moduleVO.getOverFilledToNotRefilledPercent());
    }
}