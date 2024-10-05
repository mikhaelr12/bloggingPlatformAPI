package md.practice.bloggingapi.repository;

import md.practice.bloggingapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
