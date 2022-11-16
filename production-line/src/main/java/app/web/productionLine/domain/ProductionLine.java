package app.web.productionLine.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter()
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductionLine {
    private long id;
    private long version;
    private String lineName;
    private LocalDateTime creationTimestamp;

    ProductionLine(String lineName) {
        this.lineName = lineName;
    }

}
