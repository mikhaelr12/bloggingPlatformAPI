package md.practice.bloggingapi.service.impl;

import lombok.AllArgsConstructor;
import md.practice.bloggingapi.dto.PostDTO;
import md.practice.bloggingapi.entity.Post;
import md.practice.bloggingapi.exception.PostsException;
import md.practice.bloggingapi.repository.PostsRepository;
import md.practice.bloggingapi.service.PostsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PostsServiceImpl implements PostsService {

    private PostsRepository postsRepository;

    @Override
    public void addPost(PostDTO postInput) {
         postsRepository.save(
                Post.builder()
                        .title(postInput.getTitle())
                        .content(postInput.getContent())
                        .category(postInput.getCategory())
                        .tagId(postInput.getTag_id())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );
    }

    @Override
    public void deletePost(Long id) {
        Post post = postsRepository.findById(id).orElse(null);
        if(post == null){
            throw new PostsException("Post not found");
        }
        postsRepository.delete(post);
    }
}
