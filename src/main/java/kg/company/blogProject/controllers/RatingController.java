package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;
import kg.company.blogProject.models.RatingModel;
import kg.company.blogProject.models.ResponseMessage;
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
    public ResponseMessage save(@RequestBody Rating rating) {
        RatingModel r = new RatingModel();
        r.setId(rating.getId());
        try {
            return ResponseMessage.builder()
                    .success(true)
                    .json(ratingService.save(r))
                    .build();
        } catch (Exception e) {
            return ResponseMessage.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @GetMapping
    public List<RatingModel> getAll() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/{id}")
    public RatingModel getById(@PathVariable("id") Long id) {
        return ratingService.getRatingById(id);
    }

    @PutMapping("/{id}")
    public Rating update(@PathVariable("id") Long id, @RequestBody Rating rating) {
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        if(ratingService.deleteRatingById(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byValue")
    public List<RatingModel> getByValue(@RequestParam(value = "value") Integer value) {
        return ratingService.getAllByValue(value);
    }

    @GetMapping("/byPost")
    public List<RatingModel> getByPost(@RequestParam(value = "id") Long id) {
        return ratingService.getAllRatingsByPostId(id);
    }

    @GetMapping("/byUser")
    public List<RatingModel> getByUser(@RequestParam(value = "id") Long id) {
        return ratingService.getAllRatingsByUserId(id);
    }

    @GetMapping("/overallRating/{id}")
    public Long getOverall(@PathVariable("id") Long id) {
        return ratingService.getOverall(id);
    }
}
