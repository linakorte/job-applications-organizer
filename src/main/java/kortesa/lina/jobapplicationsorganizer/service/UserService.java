package kortesa.lina.jobapplicationsorganizer.service;

import kortesa.lina.jobapplicationsorganizer.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);

    List<User> getUsers();
}
