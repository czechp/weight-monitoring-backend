package app.web.application.service;

import app.web.domain.WorkShift;

import java.time.LocalTime;

public class WorkShiftProvider {
    public static WorkShift forTime(LocalTime localTime) {
        final var currentHour = localTime.getHour();
        if (currentHour >= 7 && currentHour < 15)
            return WorkShift.I;
        else if (currentHour >= 15 && currentHour < 23)
            return WorkShift.II;
        else return WorkShift.III;
    }
}
