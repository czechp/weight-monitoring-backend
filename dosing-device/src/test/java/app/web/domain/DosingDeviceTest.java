package app.web.domain;

import app.web.dosingDevice.dto.DosingDeviceUpdateData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DosingDeviceTest {

    @Test
    @DisplayName("Update dosing device data")
    void updateDosingDeviceDataTest(){
        //given
        final DosingDevice dosingDevice = new DosingDeviceFirst(
                0L,
                0L,
                new ModuleInfo(0L, "Some line"),
                1,
                123,
                new Measures()
        );
        final DosingDeviceUpdateData dto = createUpdateDto();
        //when
        DosingDevice updatedDosingDevice = dosingDevice.updateData(dto);
        //then
        assertEquals(dto.getLastMeasure(), updatedDosingDevice.getMeasures().getLastMeasure());
        assertEquals(dto.getAmountBelowMeasures(), updatedDosingDevice.getMeasures().getAmountBelowMeasures());
        assertEquals(dto.getAmountCorrectMeasures(), updatedDosingDevice.getMeasures().getAmountCorrectMeasures());
        assertEquals(dto.getAmountAboveMeasures(), updatedDosingDevice.getMeasures().getAmountAboveMeasures());
        assertEquals(dto.getAverageMeasure(), updatedDosingDevice.getMeasures().getAverageMeasure());
        assertEquals(dto.getCorrectMeasuresPercent(), updatedDosingDevice.getMeasures().getCorrectMeasurePercent());
        assertEquals(dto.getTotalMaterial(), updatedDosingDevice.getTotalMaterial());
    }

    private DosingDeviceUpdateData createUpdateDto() {
        return new DosingDeviceUpdateData() {
            @Override
            public int getRecordNumber() {
                return 1;
            }

            @Override
            public float getLastMeasure() {
                return 13.3f;
            }

            @Override
            public int getAmountBelowMeasures() {
                return 111;
            }

            @Override
            public int getAmountCorrectMeasures() {
                return 222;
            }

            @Override
            public int getAmountAboveMeasures() {
                return 333;
            }

            @Override
            public float getAverageMeasure() {
                return 444;
            }

            @Override
            public int getCorrectMeasuresPercent() {
                return 555;
            }

            @Override
            public float getTotalMaterial() {
                return 666;
            }
        };
    }

}