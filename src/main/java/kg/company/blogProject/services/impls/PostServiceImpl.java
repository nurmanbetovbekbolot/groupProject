package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.repos.PostRepo;
import kg.company.blogProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Override
    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> post = postRepo.findById(id);
        return post.get();
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
    public String deletePostById(Long id) {
        String result = "deleted " + postRepo.findById(id);
        postRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Post> getAllPostsByCategoryName(String categoryName) {
        return postRepo.getAllByCategory_Name(categoryName);
    }

    @Override
    public List<Post> getAllPostsByTitle(String title) {
        return postRepo.getAllByTitle(title);
    }

    @Override
    public List<Post> getAllPostsByUserId(Long userId) {
        return postRepo.getAllByUserId(userId);
    }

    @Override
    public List<Post> getAllPostsByPublicationTime(Date publicationTime) {
        return postRepo.getAllByPublicationTime(publicationTime);
    }

    @Override
    public List<Post> getAllPostsByPublicationTimeBetween(Date intiPublicationTime, Date finalPublicationTime) {
        return postRepo.getAllByPublicationTimeBetween(intiPublicationTime, finalPublicationTime);
    }

    @Override
    public List<Post> getAllPostsByPublicationTimeGreaterThan(Date initPublicationTime) {
        return postRepo.getAllByPublicationTimeGreaterThan(initPublicationTime);
    }

    @Override
    public List<Post> getAllPostsByTag(Long tagId) {
        return postRepo.getAllByTag(tagId);
    }

    @Override
    public Integer getPostCountByUserId(Long userId) {
        return postRepo.getPostCountByUserId(userId);
    }
}
