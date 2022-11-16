package app.web.productionLine.adapter.persistence;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "production_lines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ProductionLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    private long version;

    @Column(unique = true)
    @Length(min = 3)
    private String lineName;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductionLineEntity that = (ProductionLineEntity) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder().append(id, that.id).append(lineName, that.lineName).append(creationTimestamp, that.creationTimestamp).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37).append(id).append(lineName).append(creationTimestamp).toHashCode();
    }
}
