package lab.Spring.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.Instant;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SwapRecord {
    @Column(name = "swapped_at", nullable = false)
    private Instant swappedAt;

    private Long personId;

    private boolean committed;
}
