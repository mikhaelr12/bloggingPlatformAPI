package md.practice.bloggingapi.service.impl;

import lombok.AllArgsConstructor;
import md.practice.bloggingapi.dto.PostDTO;
import md.practice.bloggingapi.entity.Post;
import md.practice.bloggingapi.exception.PostsException;
import md.practice.bloggingapi.repository.PostsRepository;
import md.practice.bloggingapi.service.PostsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsServiceImpl implements PostsService {

    private PostsRepository postsRepository;


    //logic for adding a new post
    @Override
    public void addPost(PostDTO postInput) {
        postsRepository.save(
                Post.builder()
                        .title(postInput.getTitle())
                        .content(postInput.getContent())
                        .category(postInput.getCategory())
                        .tags(postInput.getTags())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );
    }

    //logic for deleting a post
    @Override
    public void deletePost(Long id) {
        Post post = postsRepository.findById(id).orElse(null);
        if(post == null){
            throw new PostsException("Post not found");
        }
        postsRepository.delete(post);
    }


    //logic for getting all posts
    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postsRepository.findAll();
        return posts.stream().map(post -> PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .tags(post.getTags())
                .build()
        ).collect(Collectors.toList());
    }


    //logic for updating a post
    @Override
    public void updatePost(Long id, PostDTO postInput) {
        Post post = postsRepository.findById(id)
                .orElseThrow(() -> new PostsException("Post not found"));
        post.setTitle(postInput.getTitle());
        post.setContent(postInput.getContent());
        post.setUpdatedAt(LocalDateTime.now());
        postsRepository.save(post);
    }

    @Override
    public PostDTO getPost(Long id) {
        Post post = postsRepository.findById(id).orElse(null);
        if(post == null){
            throw new PostsException("Post not found");
        }
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .tags(post.getTags())
                .build();
    }

    @Override
    public List<PostDTO> getAllPostsByCategory(String searchTerm) {
        List<Post> allPosts = postsRepository.findAll();

        // Filter posts by category, content, or title, and map them to PostDTO
        return allPosts.stream()
                .filter(post ->
                        post.getCategory().toLowerCase().trim().equals(searchTerm.toLowerCase().trim()) ||
                                post.getContent().toLowerCase().trim().contains(searchTerm.toLowerCase().trim()) ||
                                post.getTitle().toLowerCase().trim().contains(searchTerm.toLowerCase().trim())
                )
                .map(post -> PostDTO.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .category(post.getCategory())
                        .createdAt(post.getCreatedAt())
                        .updatedAt(post.getUpdatedAt())
                        .tags(post.getTags())
                        .build())
                .collect(Collectors.toList());
    }

}
