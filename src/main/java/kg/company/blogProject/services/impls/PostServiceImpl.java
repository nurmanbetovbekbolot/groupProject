package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.entities.Tag;
import kg.company.blogProject.models.CommentsOfPostModel;
import kg.company.blogProject.models.PostModel;
import kg.company.blogProject.models.PostRatingsModel;
import kg.company.blogProject.repos.PostRepo;
import kg.company.blogProject.repos.TagRepo;
import kg.company.blogProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public List<PostModel> getAllPosts() {
        List<PostModel> postModels = postRepo.getAll();
        for(int j = 0; j < postModels.size(); j++) {
            List<String> tags = postRepo.getTagsByPost(postModels.get(j).getId());
            postModels.get(j).setTags(tags); //присвоить лист из тэгов от поста к моделькам
        }
        return postModels;
    }

    @Override
    public PostModel getPostById(Long id) {
        PostModel postModel = postRepo.getById(id);
        if(postModel != null) {
            List<String> tags = postRepo.getTagsByPost(postModel.getId());
            postModel.setTags(tags); //присвоить лист из тэгов от поста к моделькам
        } else return new PostModel();
        return postModel;
    }

    @Override
    public Post updatePost(Long id, Post post) {
        if(postRepo.findById(id).isPresent()) {
            Post existingPost = postRepo.findById(id).get();
            existingPost.setTitle(post.getTitle());
            existingPost.setCategory(post.getCategory());
            existingPost.setTextBody(post.getTextBody());
            existingPost.setPublicationTime(post.getPublicationTime());
            existingPost.setShortDescription(post.getShortDescription());
            existingPost.setUser(post.getUser());
            existingPost.setTags(post.getTags());
            Post updatedPost = postRepo.save(existingPost);
            return updatedPost;
        }
        else return null;
    }

    @Override
    public Boolean deletePostById(Long id) {
        postRepo.deleteById(id);
        if(postRepo.findById(id).isPresent()) {
            return false;
        } else return true;
    }

    @Override
    public List<PostModel> getPostsByCategoryName(String categoryName) {
        List<PostModel> postModels = postRepo.getByCategoryName(categoryName);
        for(int j = 0; j < postModels.size(); j++) {
            List<String> tags = postRepo.getTagsByPost(postModels.get(j).getId());
            postModels.get(j).setTags(tags); //присвоить лист из тэгов от поста к моделькам
        }
        return postModels;
    }

    @Override
    public List<PostModel> getAllPostsByTitle(String title) {
        List<PostModel> postModels = postRepo.getByTitle(title);
        for(int j = 0; j < postModels.size(); j++) {
            List<String> tags = postRepo.getTagsByPost(postModels.get(j).getId());
            postModels.get(j).setTags(tags); //присвоить лист из тэгов от поста к моделькам
        }
        return postModels;
    }

    @Override
    public List<PostModel> getAllPostsByUserId(Long userId) {
        List<PostModel> postModels = postRepo.getPostsByUserId(userId);
        for(int j = 0; j < postModels.size(); j++) {
            List<String> tags = postRepo.getTagsByPost(postModels.get(j).getId());
            postModels.get(j).setTags(tags);//присвоить лист из тэгов от поста к моделькам
        }
        return postModels;
    }

    @Override
    public List<PostModel> getAllPostsByTag(String tag) {
        List<PostModel> postModels = postRepo.getAllByTag(tag);
        for(int i = 0; i < postModels.size(); i++) {
            List<String> tags = postRepo.getTagsByPost(postModels.get(i).getId());
            postModels.get(i).setTags(tags); //присвоить лист из тэгов от поста к моделькам
        }
        return postModels;
    }

    @Override
    public List<String> getTagsByPost(Long postId) {
        return postRepo.getTagsByPost(postId);
    }

    @Override
    public List<Post> getByTag(String tag) {
        return postRepo.getByTag(tag);
    }

    @Override
    public Integer getPostCountByUserId(Long userId) {
        return postRepo.getPostCountByUserId(userId);
    }

    @Override
    public Integer getCommentCountByPostId(Long id) {
        return postRepo.getCommentCountByPostId(id);
    }

    @Override
    public Float getRatingByPostId(Long postId) {
        return postRepo.getRatingByPostId(postId);
    }

    @Override
    public List<PostRatingsModel> getAllRatings(Long postId) {
        return postRepo.getAllRatings(postId);
    }

    @Override
    public String getTime(Long postId) {
        String result = "";
        String createdDate = postRepo.getPublicationTime(postId);
        String now = null;
        Date n = null;
        Date tp = null;
        try {
            now = format.format(new Date());
            n = format.parse(now);
            tp = format.parse(createdDate);

            long diff = Math.abs(n.getTime() - tp.getTime());

            int diffSeconds = (int) (diff/1000);
            int diffMinutes = diffSeconds / 60;
            short diffHours = (short) (diffMinutes/60);
            short diffDays = (short) (diffHours/ 24);

            if(diffDays != 0 && diffDays == 1) {
                result = diffDays + " day";
            } else if (diffDays != 0 && diffDays != 1) {
                result = diffDays + " days";
            } else if (diffHours != 0 && diffHours == 1) {
                result = diffHours + " hour";
            } else if (diffHours != 0 && diffHours != 1) {
                result = diffHours + " hours";
            } else if (diffMinutes != 0 && diffMinutes == 1) {
                result = diffMinutes + " minute";
            } else if (diffMinutes != 0 && diffMinutes != 1) {
                result = diffMinutes + " minutes";
            } else result = diffSeconds + " seconds";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<CommentsOfPostModel> getComments(Long postId) {
        return postRepo.getComments(postId);
    }
}
