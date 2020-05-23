package kg.company.blogProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostModel {
    @JsonIgnore
    Long id;
    String title;
    String textBody;
    Long userId;
    List<String> tags;
    String category;
    Date publicationTime;
    String shortDescription;

    public PostModel() {
    }

    public PostModel(Long id, String title, String textBody, Long userId, String category, Date publicationTime, String shortDescription) {
        this.id = id;
        this.title = title;
        this.textBody = textBody;
        this.userId = userId;
        this.category = category;
        this.publicationTime = publicationTime;
        this.shortDescription = shortDescription;
    }
}
