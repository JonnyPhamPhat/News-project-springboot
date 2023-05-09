package newsproject.news.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterDTO extends AbstractDTO<UserRegisterDTO> {
    private String username;
    private String password;
    private String fullName;
    private int status;

    public UserRegisterDTO(String username){
        super();
        this.username = username;
    }
}
