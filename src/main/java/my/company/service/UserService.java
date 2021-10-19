package my.company.service;

import my.company.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService{
    void addUser(User user);

    void deletedById(Long id);

    User getById(Long id);

    List<User> findAllUser();
}
