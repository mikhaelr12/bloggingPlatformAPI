package md.practice.bloggingapi.service;

import md.practice.bloggingapi.dto.PostDTO;

import java.util.List;

public interface PostsService {

    void addPost(PostDTO postInput);

    void deletePost(Long id);

    List<PostDTO> getAllPosts();

    void updatePost(Long id, PostDTO postInput);

    PostDTO getPost(Long id);

    List<PostDTO> getAllPostsByCategory(String category);
}
