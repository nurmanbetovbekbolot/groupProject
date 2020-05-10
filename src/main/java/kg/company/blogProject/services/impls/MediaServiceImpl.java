package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Media;
import kg.company.blogProject.enums.MediaType;
import kg.company.blogProject.repos.MediaRepo;
import kg.company.blogProject.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    MediaRepo mediaRepo;

    @Override
    public Media save(Media media) {
        return mediaRepo.save(media);
    }

    @Override
    public Media getMediaById(Long id) {
        Optional<Media> media = mediaRepo.findById(id);
        return media.get();
    }

    @Override
    public List<Media> getAllMedia() {
        return mediaRepo.findAll();
    }

    @Override
    public Media updateMedia(Long id, Media media) {
        if(mediaRepo.findById(id).isPresent()) {
            Media existingMedia = mediaRepo.findById(id).get();
            existingMedia.setMediaType(media.getMediaType());
            existingMedia.setPost(media.getPost());
            Media updatedMedia = mediaRepo.save(existingMedia);
            return updatedMedia;
        }
        else return null;
    }

    @Override
    public String deleteMediaById(Long id) {
        String result = "deleted " + mediaRepo.findById(id);
        mediaRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Media> getAllMediaByType(MediaType type) {
        return mediaRepo.getAllByMediaType(type);
    }

    @Override
    public List<Media> getAllMediaByPostId(Long postId) {
        return mediaRepo.getAllByPostId(postId);
    }
}
