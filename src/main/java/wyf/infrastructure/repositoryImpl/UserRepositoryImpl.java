package wyf.infrastructure.repositoryImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import wyf.domain.Role;

import wyf.domain.User;
import wyf.infrastructure.mapper.UserMapper;
import wyf.infrastructure.mapper.UserRoleMapper;
import wyf.infrastructure.po.UserPo;
import wyf.infrastructure.po.UserRole;
import wyf.repository.UserRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public User findUserByName(String name) {
        User user = new User();
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserPo :: getName,name);
        UserPo userPo = userMapper.selectOne(queryWrapper);
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.lambda().eq(UserRole :: getUserId,userPo.getId());
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQueryWrapper);
        if (Objects.nonNull(userRoles)) {
            List<Role> roleList = userRoles.stream().map(ele -> {
                Role role = new Role();
                role.setName(ele.getRoleName());
                return role;
            }).collect(Collectors.toList());
            user.setRoleList(roleList);
        }
        user.setUsername(userPo.getName());
        user.setPassword(userPo.getPassword());
        BeanUtils.copyProperties(userPo,user);
        return user;
    }
}
