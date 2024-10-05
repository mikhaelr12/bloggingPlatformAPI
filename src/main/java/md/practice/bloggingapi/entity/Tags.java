package md.practice.bloggingapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tables")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_seq")
    @SequenceGenerator(name = "tag_id_seq", sequenceName = "tag_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "tag_name")
    private String tagName;
}
