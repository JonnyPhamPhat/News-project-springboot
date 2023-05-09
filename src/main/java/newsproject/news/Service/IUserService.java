package newsproject.news.Service;

import newsproject.news.dto.UserRegisterDTO;
import newsproject.news.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    UserEntity createUser(UserRegisterDTO userRegisterDTO);
    List<UserEntity> listUserEntity();
}
