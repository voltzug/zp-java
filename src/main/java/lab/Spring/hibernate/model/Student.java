package lab.Spring.hibernate.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Student extends Person {
    @Setter
    private double averageGrade;
}
