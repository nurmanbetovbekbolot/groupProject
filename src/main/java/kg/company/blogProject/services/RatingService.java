package kg.company.blogProject.services;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;
import kg.company.blogProject.exception.PostNotFoundException;
import kg.company.blogProject.exception.UserNotFoundException;
import kg.company.blogProject.models.RatingModel;

import java.util.List;

public interface RatingService {
    Rating save(RatingModel rating) throws PostNotFoundException, UserNotFoundException;
    RatingModel getRatingById(Long id);
    List<RatingModel> getAllRatings();
    Rating updateRating(Long id, Rating rating);
    Boolean deleteRatingById(Long id);
    List<RatingModel> getAllByValue(Integer value);
    List<RatingModel> getAllRatingsByPostId(Long postId);
    List<RatingModel> getAllRatingsByUserId(Long userId);
    Long getOverall(Long postId);
}
