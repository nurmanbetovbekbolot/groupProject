package kg.company.blogProject.services;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating save(Rating rating);
    Rating getRatingById(Long id);
    List<Rating> getAllRatings();
    Rating updateRating(Long id, Rating rating);
    String deleteRatingById(Long id);
    List<Rating> getAllByValue(Integer value);
    List<Rating> getAllRatingsByPostId(Long postId);
    List<Rating> getAllRatingsByUserId(Long userId);
    Long getOverall(Long postId);
}
