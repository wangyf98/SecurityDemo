package wyf.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user_role")
public class UserRole {
    private long userId;
    private String roleName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
