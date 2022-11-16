package app.web.application.service;

import app.web.domain.WorkShift;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkShiftProviderTest {
    @Test
    @DisplayName("First Work Shift")
    void firstWorksShiftTest(){
        //given
        LocalTime time = LocalTime.of(7, 0);
        //when
        WorkShift workShift = WorkShiftProvider.forTime(time);
        //then
        assertEquals(WorkShift.I, workShift);
    }

    @Test
    @DisplayName("Second Work Shift")
    void secondWorksShiftTest(){
        //given
        LocalTime time = LocalTime.of(17, 0);
        //when
        WorkShift workShift = WorkShiftProvider.forTime(time);
        //then
        assertEquals(WorkShift.II, workShift);
    }


    @Test
    @DisplayName("Third Work Shift")
    void thirdWorksShiftTest(){
        //given
        LocalTime time = LocalTime.of(5, 0);
        //when
        WorkShift workShift = WorkShiftProvider.forTime(time);
        //then
        assertEquals(WorkShift.III, workShift);
    }

}