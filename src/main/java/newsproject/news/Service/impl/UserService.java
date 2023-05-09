package newsproject.news.Service.impl;

import newsproject.news.Service.IUserService;
import newsproject.news.dto.UserRegisterDTO;
import newsproject.news.entity.RoleEntity;
import newsproject.news.entity.UserEntity;
import newsproject.news.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserRegisterDTO userRegisterDTO) {
        UserEntity userEntity = new UserEntity(userRegisterDTO.getUsername(),
                passwordEncoder.encode(userRegisterDTO.getPassword()), userRegisterDTO.getFullName(),
                userRegisterDTO.getStatus(), Arrays.asList(new RoleEntity("ROLE_USER")));
        return userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("Username or password invalid");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), mapearAutoridadesRoles(userEntity.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> listUserEntity() {
        return userRepository.findAll();
    }
}
