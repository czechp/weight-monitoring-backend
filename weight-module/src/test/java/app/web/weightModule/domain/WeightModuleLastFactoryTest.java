package app.web.weightModule.domain;

import app.web.weightModule.adapter.persistence.WeightModuleLastEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WeightModuleLastFactoryTest {

    @Test
    @DisplayName("Convert to domain")
    void toDomainTest() {
        //given
        final var entity = WeightModuleLastTestProvider.getEntity();
        //when
        WeightModuleLast module = WeightModuleLastFactory.toDomain(entity);
        //then
        assertEquals(entity.getIncorrectProductPcs(), module.getModuleLastInfo().getIncorrectProductPcs());
        assertEquals(entity.getWeightDifference(), module.getModuleLastInfo().getWeightDifference());
        assertEquals(entity.getCorrectToOverdosePercent(), module.getModuleLastInfo().getCorrectToOverdosePercent());
        assertEquals(entity.getNotRefilledProductPcs(), module.getModuleLastInfo().getNotRefilledProductPcs());
        assertEquals(entity.getOverFilledProductPcs(), module.getModuleLastInfo().getOverFilledProductPcs());
        assertEquals(entity.getOverFilledToNotRefilledPercent(), module.getModuleLastInfo().getOverFilledToNotRefilledPercent());
    }

    @Test
    @DisplayName("Convert to entity")
    void toEntityTest() {
        //given
        WeightModuleLast domain = WeightModuleLastTestProvider.domain();
        //when
        WeightModuleLastEntity entity = WeightModuleLastFactory.toEntity(domain);
        //then
        assertEquals(domain.getModuleLastInfo().getIncorrectProductPcs(), entity.getIncorrectProductPcs());
        assertEquals(domain.getModuleLastInfo().getWeightDifference(), entity.getWeightDifference());
        assertEquals(domain.getModuleLastInfo().getCorrectToOverdosePercent(), entity.getCorrectToOverdosePercent());
        assertEquals(domain.getModuleLastInfo().getNotRefilledProductPcs(), entity.getNotRefilledProductPcs());
        assertEquals(domain.getModuleLastInfo().getOverFilledToNotRefilledPercent(), entity.getOverFilledToNotRefilledPercent());
        assertEquals(domain.getModuleLastInfo().getOverFilledToNotRefilledPercent(), entity.getOverFilledToNotRefilledPercent());
    }

    @Test
    @DisplayName("Create a new WeightModule")
    void createNewWeightModuleLastTest() {
        //given
        final  var productionLineId = 1L;
        final var productionLineName = "Some production line name";
        //when
        WeightModuleLast createdModule = WeightModuleLastFactory.create(productionLineId, productionLineName);
        //then
        assertEquals(productionLineId, createdModule.getProductionLineId());
        assertEquals(productionLineName,  createdModule.getProductionLineName());
    }
}