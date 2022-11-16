package app.web.report.dto;

public interface ReportSummary {
    String getLineName();
    long getTotalProductPcs();
    float getTotalMaterialWeight();
    float getWeightDifference();
    float getCorrectProductPercent();
    long getIncorrectProductPcs();
    long getOverFilledProductPcs();
    long getNotFulFilledProductPcs();
}
