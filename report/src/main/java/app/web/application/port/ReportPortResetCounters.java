package app.web.application.port;

import java.util.List;

public interface ReportPortResetCounters {
    void resetAllLinesCounters(List<Long> lineIds);
}
