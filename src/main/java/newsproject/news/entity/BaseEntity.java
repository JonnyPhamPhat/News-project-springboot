package newsproject.news.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "createdby")
    private String createdBy;
    @Column(name = "createddate")
    private Date createdDate;
    @Column(name = "modifiedby")
    private String modifiedBy;
    @Column(name = "modifieddate")
    private Date modifiedDate;
}
