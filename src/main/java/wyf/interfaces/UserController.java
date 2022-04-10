package wyf.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import wyf.application.service.UserService;
import wyf.domain.User;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public UserDetails login(User user){
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        return  userDetails;
    }

    @GetMapping("/getUser")
    public UserDetails getUser(User user){
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        return  userDetails;
    }
}
