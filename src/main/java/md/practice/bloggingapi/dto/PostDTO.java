package md.practice.bloggingapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter @Setter
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String category;
    private List<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
