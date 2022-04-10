package wyf.application.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wyf.domain.SecurityUserDetails;
import wyf.domain.User;
import wyf.repository.UserRepository;
import wyf.application.service.UserService;

import javax.annotation.Resource;
import java.util.Objects;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username);
        if (Objects.nonNull(user)) {
            return new SecurityUserDetails(user);
        }
        return null;
    }
}
