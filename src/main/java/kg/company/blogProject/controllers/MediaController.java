package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Media;
import kg.company.blogProject.enums.MediaType;
import kg.company.blogProject.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {
    @Autowired
    MediaService mediaService;

    @PostMapping
    public Media save(@RequestBody Media media) {
        return mediaService.save(media);
    }

    @GetMapping
    public List<Media> getAll() {
        return mediaService.getAllMedia();
    }

    @GetMapping("/{id}")
    public Media getById(@PathVariable("id") Long id) {
        return mediaService.getMediaById(id);
    }

    @PutMapping("/{id}")
    public Media update(@PathVariable("id") Long id, @RequestBody Media media) {
        return mediaService.updateMedia(id, media);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        mediaService.deleteMediaById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{type}")
    public List<Media> getByType(@PathVariable("type") MediaType type) {
        return mediaService.getAllMediaByType(type);
    }

    @GetMapping("/byPost/{id}")
    public List<Media> getByPost(@PathVariable("id") Long id) {
        return mediaService.getAllMediaByPostId(id);
    }
}
