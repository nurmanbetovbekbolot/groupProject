package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
        postService.deletePostById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/byCategoryName/{category_name}")
    public List<Post> getByCategoryName(@PathVariable("category_name") String name) {
        return postService.getAllPostsByCategoryName(name);
    }

    @GetMapping("/byTitle/{title}")
    public List<Post> getByTitle(@PathVariable("title") String title) {
        return postService.getAllPostsByTitle(title);
    }

    @GetMapping("/byUser/{user_id}")
    public List<Post> getByUser(@PathVariable("userId") Long userId) {
        return postService.getAllPostsByUserId(userId);
    }

    @GetMapping("/{time}")
    public List<Post> getByTime(@PathVariable("time") Date time) {
        return postService.getAllPostsByPublicationTime(time);
    }

    @GetMapping(params = {"init", "final"})
    public List<Post> getByTimeBetween(@RequestParam("init") Date initDate, @RequestParam("final") Date finalDate) {
        return postService.getAllPostsByPublicationTimeBetween(initDate, finalDate);
    }

    @GetMapping("/byTimeGreaterThan/{time}")
    public List<Post> getByTimeGreaterThan(@PathVariable("time") Date time) {
        return postService.getAllPostsByPublicationTimeGreaterThan(time);
    }

    @GetMapping("/byTag/{tag}")
    public List<Post> getByTag(@PathVariable("tag") Long tagId) {
        return postService.getAllPostsByTag(tagId);
    }

    @GetMapping("/postCountById/{id}")
    public Integer getPostCount(@PathVariable("id") Long id) {
        return postService.getPostCountByUserId(id);
    }

}




