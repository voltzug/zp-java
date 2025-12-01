package lab.Spring.hibernate.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Teacher extends Person {
    @Setter
    private String subject;
}
