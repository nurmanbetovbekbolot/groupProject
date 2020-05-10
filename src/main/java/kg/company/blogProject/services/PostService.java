package kg.company.blogProject.services;

import kg.company.blogProject.entities.Post;

import java.util.Date;
import java.util.List;

public interface PostService {
    Post savePost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post updatePost(Long id, Post post);
    String deletePostById(Long id);
    List<Post> getAllPostsByCategoryName(String categoryName);
    List<Post> getAllPostsByTitle(String title);
    List<Post> getAllPostsByUserId(Long userId);
    List<Post> getAllPostsByPublicationTime(Date publicationTime);
    List<Post> getAllPostsByPublicationTimeBetween(Date intiPublicationTime, Date finalPublicationTime);
    List<Post> getAllPostsByPublicationTimeGreaterThan(Date initPublicationTime);
    List<Post> getAllPostsByTag(Long tagId);
    Integer getPostCountByUserId(Long userId);
}
