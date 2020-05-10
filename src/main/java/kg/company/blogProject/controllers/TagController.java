package kg.company.blogProject.controllers;


import kg.company.blogProject.entities.Tag;
import kg.company.blogProject.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping
    public Tag save(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @GetMapping
    public List<Tag> getAll() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public Tag getById(@PathVariable("id") Long id) {
        return tagService.getTagById(id);
    }

    @PutMapping("/{id}")
    public Tag update(@PathVariable("id") Long id, @RequestBody Tag tag) {
        return tagService.updateTag(id, tag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        tagService.deleteTagById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{tag}")
    public List<Tag> getByText(@PathVariable("tag") String tag) {
        return tagService.getAllTagsByTagText(tag);
    }

}
