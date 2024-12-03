package dev.m.backend.service.impl;

import dev.m.backend.obj.ResponseApi;
import dev.m.backend.obj.SignInRequest;
import dev.m.backend.obj.entity.User;
import dev.m.backend.service.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AuthenticateService {
    private final UserRepository userRepository;

    @Autowired
    public AuthenticateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseApi findByUsername(SignInRequest username) {
        // Tìm người dùng theo tên đăng nhập
        User user = userRepository.findByUsername(username.getUsername());
        if (user != null && user.getPassword().equals(username.getPassword())) {
            log.info("Sign-in success: {}", user.getUsername());
            return new ResponseApi(true, "Sign-in successful", user);
        }
        return new ResponseApi(false, "Invalid username or password", null);
    }

    public User getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null); // Trả về đối tượng User nếu tìm thấy, nếu không tìm thấy trả về null
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
