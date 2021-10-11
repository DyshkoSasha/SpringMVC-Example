package my.company.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import my.company.exception.NoEntityException;
import my.company.model.Role;
import my.company.model.User;
import my.company.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Log
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
        log.info("SAVED USERS");
    }

    @Override
    public void deletedById(Integer id) {
        userRepository.deleteById(id);
    }

       @Override
    @Transactional(readOnly = true)
    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NoEntityException("GAMNISCHE"));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byFirstName = userRepository.getByFirstName(s);
        Set<Role> roles = byFirstName.getRoles();
        return byFirstName;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
