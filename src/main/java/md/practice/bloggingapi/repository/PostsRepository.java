package md.practice.bloggingapi.repository;

import md.practice.bloggingapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
