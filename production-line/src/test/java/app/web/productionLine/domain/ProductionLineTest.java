package app.web.productionLine.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductionLineTest {

    @Test
    void productionLineCreateTest() {
        //given
        final var lineName = "L-100";
        //when
        final var productionLine = ProductionLineFactory.create(lineName);
        //then
        assertEquals(lineName, productionLine.getLineName());
    }
}