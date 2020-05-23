package kg.company.blogProject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostTagModel {
    Long post_id;
    Long tag_id;
    String tag_text;
}
