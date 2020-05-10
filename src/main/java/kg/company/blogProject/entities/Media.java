package kg.company.blogProject.entities;

import kg.company.blogProject.enums.MediaType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "b_media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type")
    MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    Post post;
}
