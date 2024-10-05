package md.practice.bloggingapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "posts")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
    @SequenceGenerator(name = "post_id_seq", sequenceName = "post_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "category")
    private String category;

    @Column(name = "tag_id")
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_TAG_POST"))
    private Long tagId;
}
