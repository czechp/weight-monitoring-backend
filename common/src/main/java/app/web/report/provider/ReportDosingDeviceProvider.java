package app.web.report.provider;

import app.web.report.dto.ReportDosingDevice;

import java.util.List;

interface ReportDosingDeviceProvider {
    List<ReportDosingDevice> findByLineName(String lineName);
}
