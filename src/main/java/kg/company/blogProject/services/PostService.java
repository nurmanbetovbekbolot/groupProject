package kg.company.blogProject.services;

import kg.company.blogProject.entities.Post;
import kg.company.blogProject.models.CommentsOfPostModel;
import kg.company.blogProject.models.PostModel;
import kg.company.blogProject.models.PostRatingsModel;

import java.util.Date;
import java.util.List;

public interface PostService {
    Post savePost(Post post);
    List<PostModel> getAllPosts();
    PostModel getPostById(Long id);
    Post updatePost(Long id, Post post);
    Boolean deletePostById(Long id);

    List<PostModel> getPostsByCategoryName(String categoryName);

    List<PostModel> getAllPostsByTitle(String title);

    List<PostModel> getAllPostsByUserId(Long userId);

    List<PostModel> getAllPostsByTag(String tag);
    List<String> getTagsByPost(Long postId);
    List<Post> getByTag(String tag);
    Integer getPostCountByUserId(Long userId);
    Integer getCommentCountByPostId(Long id);
    Float getRatingByPostId(Long postId);
    List<PostRatingsModel> getAllRatings(Long postId);
    String getTime(Long postId);
    List<CommentsOfPostModel> getComments(Long postId);
}
