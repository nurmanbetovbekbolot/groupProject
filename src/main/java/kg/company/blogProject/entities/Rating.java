package kg.company.blogProject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "b_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Min(value = 1, message = "Value cannot be less than 1")
    @Max(value = 10, message = "Value cannot be greater than 10")
    @Column(name = "value", unique = true)
    Integer value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", nullable = false)
    Post post;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
