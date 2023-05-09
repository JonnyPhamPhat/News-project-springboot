package newsproject.news.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "news")
public class NewEntity extends BaseEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "thumbnail")
    private String thumbNail;
    @Column(name = "shortdescription")
    private String shortDescription;
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
