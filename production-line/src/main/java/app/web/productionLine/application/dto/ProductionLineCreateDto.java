package app.web.productionLine.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class ProductionLineCreateDto {
    @Length(min = 3)
    private String lineName;
}
