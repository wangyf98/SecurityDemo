package wyf.repository;

import wyf.domain.User;

public interface UserRepository {
    User findUserByName(String name);
}
