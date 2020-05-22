package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;
import kg.company.blogProject.models.PostRatings;
import kg.company.blogProject.repos.PostRepo;
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
    public List<Post> getAll() {
        return postService.getAllPosts();
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable("id") Long id) {
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

    @GetMapping("/byCategoryName/{category_name}")
    public List<Post> getByCategoryName(@PathVariable("category_name") String name) {
        return postService.getAllPostsByCategoryName(name);
    }

    @GetMapping("/byTitle/{title}")
    public List<Post> getByTitle(@PathVariable("title") String title) {
        return postService.getAllPostsByTitle(title);
    }

    @GetMapping("/byUser/{id}")
    public List<Post> getByUser(@PathVariable("id") Long userId) {
        return postService.getAllPostsByUserId(userId);
    }

    @GetMapping("/byTime/{time}")
    public List<Post> getByTime(@PathVariable("time") @DateTimeFormat(pattern = "yyyy-MM-dd") Date time) {
        return postService.getAllPostsByPublicationTime(time);
    }

    @GetMapping("/byTimeExact/{time}")
    public List<Post> getByTimeExact(@PathVariable("time") @DateTimeFormat(pattern = "yyyy-MM-dd") Date time) {
        return postService.getAllPostsByPublicationTime(time);
    }

    @GetMapping("/byTime/{init}/{final}")
    public List<Post> getByTimeBetween(@PathVariable("init")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date initDate, @PathVariable("final") @DateTimeFormat(pattern = "yyyy-MM-dd") Date finalDate) {
        return postService.getAllPostsByPublicationTimeBetween(initDate, finalDate);
    }

    @GetMapping("/byTimeGreaterThan/{time}")
    public List<Post> getByTimeGreaterThan(@PathVariable("time") @DateTimeFormat(pattern = "yyyy-MM-dd") Date time) {
        return postService.getAllPostsByPublicationTimeGreaterThan(time);
    }

    @GetMapping("/byTag/{tag}")
    public List<Post> getByTag(@PathVariable("tag") Long tagId) {
        return postService.getAllPostsByTag(tagId);
    }

    @GetMapping("/countById/{id}")
    public Integer getPostCount(@PathVariable("id") Long id) {
        return postService.getPostCountByUserId(id);
    }

    @GetMapping("/commentCountByPost/{id}")
    public Integer getCommentCount(@PathVariable("id") Long id) {
        return postService.getCommentCountByPostId(id);
    }

    @GetMapping("/{id}/rating")
    public Float getRating(@PathVariable("id") Long id) {
        return postService.getRatingByPostId(id);
    }

    @GetMapping("/{id}/allRatings")
    public List<PostRatings> getRatings(@PathVariable("id") Long id) {
        return postService.getAllRatings(id);
    }

    @GetMapping("/{id}/tp")
    public Double    getTimePassed(@PathVariable("id") Long id) {
        return postService.timePassed(id);
    }
}




