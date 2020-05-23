package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.User;
import kg.company.blogProject.entities.Rating;
import kg.company.blogProject.exception.PostNotFoundException;
import kg.company.blogProject.exception.UserNotFoundException;
import kg.company.blogProject.models.RatingModel;
import kg.company.blogProject.repos.PostRepo;
import kg.company.blogProject.repos.RatingRepo;
import kg.company.blogProject.repos.UserRepo;
import kg.company.blogProject.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepo ratingRepo;
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Rating save(RatingModel rating) throws PostNotFoundException, UserNotFoundException {
        Rating r = new Rating();
        Optional<Post> p = postRepo.findById(rating.getPostId());
        Optional<User> u = userRepo.findById(rating.getUserId());
        Post post = p.orElseThrow(() -> new PostNotFoundException());
        User user = u.orElseThrow(() -> new UserNotFoundException());
        r.setId(rating.getId());
        r.setValue(rating.getValue());
        r.setPost(post);
        r.setUser(user);
        return ratingRepo.save(r);
    }

    @Override
    public RatingModel getRatingById(Long id) {
        return ratingRepo.getById(id);
    }

    @Override
    public List<RatingModel> getAllRatings() {
        return ratingRepo.getAll();
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
    public Boolean deleteRatingById(Long id) {
        ratingRepo.deleteById(id);
        if(ratingRepo.findById(id).isPresent()) {
            return false;
        } else return true;
    }

    @Override
    public List<RatingModel> getAllByValue(Integer value) {
        return ratingRepo.getAllByValue(value);
    }

    @Override
    public List<RatingModel> getAllRatingsByPostId(Long postId) {
        return ratingRepo.getAllByPost(postId);
    }

    @Override
    public List<RatingModel> getAllRatingsByUserId(Long userId) {
        return ratingRepo.getAllByUser(userId);
    }

    @Override
    public Long getOverall(Long postId) {
        return ratingRepo.findOverall(postId);
    }
}
