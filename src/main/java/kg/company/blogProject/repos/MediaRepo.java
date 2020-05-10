package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Media;
import kg.company.blogProject.enums.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepo extends JpaRepository<Media, Long> {
    List<Media> getAllByMediaType(MediaType type);
    List<Media> getAllByPostId(Long id);
}
