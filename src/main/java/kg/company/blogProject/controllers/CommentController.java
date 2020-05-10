package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Comment;
import kg.company.blogProject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping
    public Comment save(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping
    public List<Comment> getAll() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable("id") Long id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public Comment update(@PathVariable("id") Long id, @RequestBody Comment comment) {
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{text}")
    public List<Comment> getByText(@PathVariable("text") String text) {
        return commentService.getAllCommentsByCommentText(text);
    }

    @GetMapping("/byUser/{id}")
    public List<Comment> getByUser(@PathVariable("id") Long id) {
        return commentService.getAllCommentsByUserId(id);
    }

    @GetMapping("/byPost/{id}")
    public List<Comment> getByPost(@PathVariable("id") Long id) {
        return commentService.getAllCommentsByPostId(id);
    }
}
