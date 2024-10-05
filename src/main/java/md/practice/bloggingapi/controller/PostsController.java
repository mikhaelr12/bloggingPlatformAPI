package md.practice.bloggingapi.controller;


import lombok.AllArgsConstructor;
import md.practice.bloggingapi.dto.PostDTO;
import md.practice.bloggingapi.entity.Post;
import md.practice.bloggingapi.service.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody PostDTO postInput) {
        postsService.addPost(postInput);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        postsService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postsService.getAllPosts());
    }
}
