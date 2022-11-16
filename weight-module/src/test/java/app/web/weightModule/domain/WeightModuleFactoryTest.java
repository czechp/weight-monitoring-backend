package app.web.weightModule.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeightModuleFactoryTest {
    @Test
    void toWeightModuleDomainTest() {
        //given
        final var weightModuleEntity = WeightModuleTestProvider.entity();
        //when
        final var weightModule = WeightModuleFactory.toWeightModuleDomain(weightModuleEntity);
        //then
        assertNotNull(weightModule);
    }

    @Test
    void toWeightModuleDomainProductInfoTest() {
        //given
        final var weightModuleEntity = WeightModuleTestProvider.entity();
        //when
        final var weightModule = WeightModuleFactory.toWeightModuleDomain(weightModuleEntity);
        //then
        assertNotNull(weightModule.getProductInfo());
        assertEquals(weightModuleEntity.getProductUpRangeWeight(), weightModule.getProductInfo().getUpRangeWeight());
        assertEquals(weightModuleEntity.getProductDownRangeWeight(), weightModule.getProductInfo().getDownRangeWeight());
    }

    @Test
    void toWeightModuleDomainModuleStatusTest() {
        //given
        final var weightModuleEntity = WeightModuleTestProvider.entity();
        //when
        final var weightModule = WeightModuleFactory.toWeightModuleDomain(weightModuleEntity);
        //then
        assertEquals(weightModuleEntity.getCurrentDosingDevice(), weightModule.getModuleStatus().getCurrentDosingDevice());
        assertEquals(weightModuleEntity.getCurrentMeasure(), weightModule.getModuleStatus().getCurrentMeasure());
        assertEquals(weightModuleEntity.isStatus(), weightModule.getModuleStatus().isStatus());
    }

    @Test
    void toWeightModuleDomainProductionIndicatorsTest() {
        //given
        final var weightModuleEntity = WeightModuleTestProvider.entity();
        //given
        final var weightModule = WeightModuleFactory.toWeightModuleDomain(weightModuleEntity);
        //then
        assertEquals(weightModuleEntity.getTotalMaterialWeight(), weightModule.getProductionIndicators().getTotalMaterialWeight());
        assertEquals(weightModuleEntity.getTotalProductPcs(), weightModule.getProductionIndicators().getTotalProductPcs());
        assertEquals(weightModuleEntity.getCorrectProductPercent(), weightModule.getProductionIndicators().getCorrectProductPercent());
    }

    @Test
    void toWeightModuleEntityTest() {
        //given
        final var entity = WeightModuleTestProvider.entity();
        final var domain = WeightModuleFactory.toWeightModuleDomain(entity);
        //when
        final var convertedEntity = WeightModuleFactory.toWeightModuleEntity(domain);
        //then
        assertEquals(entity, convertedEntity);
    }

    @Test
    void createWeightModuleTest() {
        //given
        final var productionLineId = 1L;
        final var productionLineName = "Some production line name";
        //when
        WeightModule newWeightModule = WeightModuleFactory.createWeightModule(productionLineId, productionLineName);
        //then
        assertEquals(productionLineId, newWeightModule.getProductionLineId());
        assertEquals(productionLineName, newWeightModule.getProductionLineName());
        assertNotNull(newWeightModule.getProductInfo());
        assertNotNull(newWeightModule.getModuleStatus());
        assertNotNull(newWeightModule.getProductionIndicators());
    }

}