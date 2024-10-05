package md.practice.bloggingapi.service;

import md.practice.bloggingapi.dto.PostDTO;
import md.practice.bloggingapi.entity.Post;

public interface PostsService {

    void addPost(PostDTO postInput);

    void deletePost(Long id);
}
