package wyf.domain;


import java.util.List;
import java.util.Objects;
public class User {
    private long id;
    private String username;
    private String password;
    private List<Role> roleList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getRoles(){
        StringBuilder sb = new StringBuilder();
        if (Objects.nonNull(roleList)) {
            for (Role role : roleList) {
                sb.append("ROLE_").append(role.getName()).append(",");
            }
        }
        return sb.substring(0,sb.length() > 0 ? sb.length() - 1 : sb.length());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
