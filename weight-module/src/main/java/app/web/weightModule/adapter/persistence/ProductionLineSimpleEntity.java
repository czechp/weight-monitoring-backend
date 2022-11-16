package app.web.weightModule.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "production_lines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public
class ProductionLineSimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Length(min = 3)
    private String lineName;
}
