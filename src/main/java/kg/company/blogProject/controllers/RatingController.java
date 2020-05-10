package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;
import kg.company.blogProject.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping
    public Rating save(Rating rating) {
        return ratingService.save(rating);
    }

    @GetMapping
    public List<Rating> getAll() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/{id}")
    public Rating getById(@PathVariable("id") Long id) {
        return ratingService.getRatingById(id);
    }

    @PutMapping("/{id}")
    public Rating update(@PathVariable("id") Long id, @RequestBody Rating rating) {
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        ratingService.deleteRatingById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/byValue/{value}")
    public List<Rating> getByValue(@PathVariable("value") Integer value) {
        return ratingService.getAllByValue(value);
    }

    @GetMapping("/byPost/{id}")
    public List<Rating> getByPost(@PathVariable("id") Long id) {
        return ratingService.getAllRatingsByPostId(id);
    }

    @GetMapping("/byUser/{id}")
    public List<Rating> getByUser(@PathVariable("id") Long id) {
        return ratingService.getAllRatingsByUserId(id);
    }

    @GetMapping("/overallRating/{id}")
    public Long getOverall(@PathVariable("id") Long id) {
        return ratingService.getOverall(id);
    }
}
