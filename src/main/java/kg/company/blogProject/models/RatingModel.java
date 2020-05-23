package kg.company.blogProject.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RatingModel {
    Long id;
    Integer value;
    Long postId;
    Long userId;
}
