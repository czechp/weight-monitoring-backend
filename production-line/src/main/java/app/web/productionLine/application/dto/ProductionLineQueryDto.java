package app.web.productionLine.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public
class ProductionLineQueryDto {
    private long id;
    private String lineName;
    private LocalDateTime creationTimestamp;
}
