package app.web.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDosingDeviceQueryDto {
    private long id;
    private int recordNumber = 0;
    private float totalMaterialWeight = 0;
    private float correctPercent = 0;
    private float averageWeight = 0;

}
