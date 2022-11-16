package app.web.weightModule.domain;

import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.adapter.persistence.ProductionLineSimpleEntity;
import app.web.weightModule.adapter.persistence.WeightModuleLastEntity;
import app.web.weightModule.application.dto.WeightModuleLastUpdateDto;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WeightModuleLastTestProvider {
    static WeightModuleLastEntity getEntity() {
        return new WeightModuleLastEntity(
                0L,
                0L,
                new ProductionLineSimpleEntity(1L, ""),
                17f,
                15f,
                11,
                16.4f,
                true,
                200.0f,
                300_000l,
                78.0f,
                100_000L,
                -200.3f,
                60.0f,
                100_000L,
                75_000,
                33.4f
        );
    }

    public static WeightModuleLast domain() {
        return new WeightModuleLast(
                100L,
                0L,
                111L,
                "Line name",
                new ProductInfoVO(),
                new ModuleStatusVO(),
                new ProductionIndicatorsVO(),
                new ModuleLastInfoVO(
                        111L,
                        -10f,
                        222L,
                        333,
                        444,
                        66f
                )
        );
    }

    public static WeightModuleLastUpdateDto updateDto(){
        return new WeightModuleLastUpdateDto(
                RandomValueGenerator.randomInt(),
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomInt(),
                RandomValueGenerator.randomInt(),
                RandomValueGenerator.randomFloat()
        );
    }
}
