package kg.company.blogProject.services;

import kg.company.blogProject.entities.Tag;

import java.util.List;

public interface TagService {
    Tag save(Tag tag);
    Tag getTagById(Long id);
    List<Tag> getAllTags();
    Tag updateTag(Long id, Tag tag);
    String deleteTagById(Long id);
    List<Tag> getAllTagsByTagText(String tagText);
    List<Tag> getAllTagsByPost(Long postId);
}
