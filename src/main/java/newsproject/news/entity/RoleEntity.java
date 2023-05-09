package newsproject.news.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class RoleEntity extends  BaseEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    public RoleEntity(){

    }

    public RoleEntity(String name){
        super();
        this.name = name;
    }
}
