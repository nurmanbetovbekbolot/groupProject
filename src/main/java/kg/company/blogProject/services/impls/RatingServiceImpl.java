package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Rating;
import kg.company.blogProject.repos.RatingRepo;
import kg.company.blogProject.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepo ratingRepo;

    @Override
    public Rating save(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public Rating getRatingById(Long id) {
        Optional<Rating> rating = ratingRepo.findById(id);
        return rating.get();
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public Rating updateRating(Long id, Rating rating) {
        if(ratingRepo.findById(id).isPresent()) {
            Rating existingRating = ratingRepo.findById(id).get();
            existingRating.setValue(rating.getValue());
            existingRating.setPost(rating.getPost());
            existingRating.setUser(rating.getUser());
            Rating updatedRating = ratingRepo.save(existingRating);
            return updatedRating;
        }
        else return null;
    }

    @Override
    public String deleteRatingById(Long id) {
        String result = "deleted " + ratingRepo.findById(id);
        ratingRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Rating> getAllByValue(Integer value) {
        return ratingRepo.findAllByValue(value);
    }

    @Override
    public List<Rating> getAllRatingsByPostId(Long postId) {
        return ratingRepo.findAllByPost_Id(postId);
    }

    @Override
    public List<Rating> getAllRatingsByUserId(Long userId) {
        return ratingRepo.findAllByUser_Id(userId);
    }

    @Override
    public Long getOverall(Long postId) {
        return ratingRepo.findOverall(postId);
    }
}
