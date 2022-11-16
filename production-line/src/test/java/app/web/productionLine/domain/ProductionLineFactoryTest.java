package app.web.productionLine.domain;

import app.web.productionLine.adapter.persistence.ProductionLineEntity;
import app.web.productionLine.application.dto.ProductionLineQueryDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductionLineFactoryTest {

    @Test
    void mapFromDomainTest() {
        //given
        final var lineName = "Some new line";
        final var productionLine = ProductionLineFactory.create(lineName);
        //when
        final var productionLineEntity = ProductionLineFactory.toEntity(productionLine);
        //then
        assertEquals(productionLine.getLineName(), productionLineEntity.getLineName());
        assertEquals(productionLine.getId(), productionLineEntity.getId());
    }

    @Test
    void mapToDomainTest() {
        //given
        final var productionLineEntity = ProductionLineEntity.builder()
                .withId(1L)
                .withLineName("Some line name")
                .withCreationTimestamp(LocalDateTime.now())
                .build();
        //when
        final ProductionLine productionLine = ProductionLineFactory.toDomain(productionLineEntity);
        //then
        assertEquals(productionLineEntity.getId(), productionLine.getId());
        assertEquals(productionLineEntity.getLineName(), productionLine.getLineName());
        assertEquals(productionLineEntity.getCreationTimestamp(), productionLine.getCreationTimestamp());
    }

    @Test
    void mapToQueryDto() {
        //given
        final var productionLineEntity = new ProductionLineEntity(1L, 0L, "New line", LocalDateTime.now());
        //when
        final ProductionLineQueryDto dto = ProductionLineFactory.toDto(productionLineEntity);
        //then
        assertEquals(productionLineEntity.getId(), dto.getId());
        assertEquals(productionLineEntity.getLineName(), dto.getLineName());
        assertEquals(productionLineEntity.getCreationTimestamp(), dto.getCreationTimestamp());

    }
}