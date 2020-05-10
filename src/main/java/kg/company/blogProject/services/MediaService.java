package kg.company.blogProject.services;

import kg.company.blogProject.entities.Media;
import kg.company.blogProject.enums.MediaType;

import java.util.List;

public interface MediaService {
    Media save(Media media);
    Media getMediaById(Long id);
    List<Media> getAllMedia();
    Media updateMedia(Long id, Media media);
    String deleteMediaById(Long id);
    List<Media> getAllMediaByType(MediaType type);
    List<Media> getAllMediaByPostId(Long postId);
}
