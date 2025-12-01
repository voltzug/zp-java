package lab.Spring.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "temp_teacher_id", nullable = true, foreignKey = @ForeignKey(name = "fk_classroom_temp_teacher"))
    private Teacher temporaryTeacher;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private List<Student> students = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "classroom_swap_history", joinColumns = @JoinColumn(name = "classroom_id"))
    private List<SwapRecord> swapHistory = new ArrayList<>();

    /**
     * get the effective teacher (temporary if present)
     */
    public Teacher getEffectiveTeacher() {
        return temporaryTeacher != null ? temporaryTeacher : teacher;
    }

    /**
     * set a temporary teacher (one-time swap) and record the swap
     */
    public void setTemporaryTeacher(Teacher temp, Instant when) {
        if (temp == null) {
            // clearing temporary teacher ends the swap; record end event
            this.temporaryTeacher = null;
            swapHistory.add(new SwapRecord(when, null, true));
        } else {
            // start a temporary swap
            swapHistory.add(new SwapRecord(when, temp.getId(), false));
            this.temporaryTeacher = temp;
        }
    }

    /**
     * optionally make a temporary teacher permanent (commit swap)
     */
    public void commitTemporaryTeacherAsPermanent(Instant when) {
        if (temporaryTeacher != null) {
            this.teacher = temporaryTeacher;
            this.temporaryTeacher = null;
            swapHistory.add(new SwapRecord(when, teacher.getId(), true));
        }
    }
}
