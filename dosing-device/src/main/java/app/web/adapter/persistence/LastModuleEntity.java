package app.web.adapter.persistence;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="weight_modules_last")
@Getter
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor
@NoArgsConstructor
public class LastModuleEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
}
