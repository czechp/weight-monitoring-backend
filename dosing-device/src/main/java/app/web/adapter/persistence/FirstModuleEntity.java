package app.web.adapter.persistence;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="weight_modules")
@Getter
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor
@NoArgsConstructor
public class FirstModuleEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
}
