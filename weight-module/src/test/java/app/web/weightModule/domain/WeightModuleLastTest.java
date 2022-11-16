package app.web.weightModule.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightModuleLastTest {
    @Test
    @DisplayName("Extends WeightModuleAbstract")
    void extendsSuperclassTest() {
        //given
        //when
        //then
        assertTrue(WeightModuleAbstract.class.isAssignableFrom(WeightModuleLast.class));
    }

    @Test
    @DisplayName("Update data")
    void updateWeightModuleLastTest(){
        //given
        final  var weightModuleLast = WeightModuleLastTestProvider.domain();
        final var updateDto = WeightModuleTestProvider.updateDto();
        final var lastUpdateDto = WeightModuleLastTestProvider.updateDto();
        //when
        WeightModuleLast updatedModule = weightModuleLast.updateData(updateDto, lastUpdateDto);
        //then
        assertEquals(lastUpdateDto.getIncorrectProductPcs(), updatedModule.getModuleLastInfo().getIncorrectProductPcs());
        assertEquals(lastUpdateDto.getWeightDifference(), updatedModule.getModuleLastInfo().getWeightDifference());
        assertEquals(lastUpdateDto.getCorrectToOverdosePercent(), updatedModule.getModuleLastInfo().getCorrectToOverdosePercent());
        assertEquals(lastUpdateDto.getNotRefilledProductPcs(), updatedModule.getModuleLastInfo().getNotRefilledProductPcs());
        assertEquals(lastUpdateDto.getOverFilledProductPcs(), updatedModule.getModuleLastInfo().getOverFilledProductPcs());
        assertEquals(lastUpdateDto.getOverFilledToNotRefilledPercent(), updatedModule.getModuleLastInfo().getOverFilledToNotRefilledPercent());

    }

}