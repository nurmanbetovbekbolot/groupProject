package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.models.CommentsOfPostModel;
import kg.company.blogProject.models.PostModel;
import kg.company.blogProject.models.PostRatingsModel;
import kg.company.blogProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping
    public List<PostModel> getAll() {
        return postService.getAllPosts();
    }

    @GetMapping("{id}")
    public PostModel getById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable("id") Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        if(postService.deletePostById(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byCategory/{category_name}")
    public List<PostModel> getByCategoryName(@PathVariable("category_name") String name) {
        return postService.getPostsByCategoryName(name);
    }

    @GetMapping("/byTitle/{title}")
    public List<PostModel> getByTitle(@PathVariable("title") String title) {
        return postService.getAllPostsByTitle(title);
    }

    @GetMapping("/user/{id}")
    public List<PostModel> getByUser(@PathVariable("id") Long userId) {
        return postService.getAllPostsByUserId(userId);
    }

    @GetMapping("/byTag/{tag}")
    public List<PostModel> getByTag(@PathVariable("tag") String tag) {
        return postService.getAllPostsByTag(tag);
    }

    @GetMapping("/amount/{id}")
    public Integer getPostCount(@PathVariable("id") Long id) {
        return postService.getPostCountByUserId(id);
    }

    @GetMapping("/{id}/commentCount")
    public Integer getCommentCount(@PathVariable("id") Long id) {
        return postService.getCommentCountByPostId(id);
    }

    @GetMapping("/{id}/rating")
    public Float getRating(@PathVariable("id") Long id) {
        return postService.getRatingByPostId(id);
    }

    @GetMapping("/{id}/allRatings")
    public List<PostRatingsModel> getRatings(@PathVariable("id") Long id) {
        return postService.getAllRatings(id);
    }

    @GetMapping("/{id}/tp")
    public String getTimePassed(@PathVariable("id") Long id) {
        return postService.getTime(id);
    }

    @GetMapping("/{id}/comments")
    public List<CommentsOfPostModel> getComments(@PathVariable("id") Long id) {
        return postService.getComments(id);
    }
}




