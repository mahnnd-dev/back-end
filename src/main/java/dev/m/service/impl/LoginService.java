package dev.m.service.impl;

import dev.m.obj.LoginRequest;
import dev.m.obj.ResponseApi;
import dev.m.obj.entity.Users;
import dev.m.service.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LoginService {
    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseApi findByUsername(LoginRequest username) {
        Optional<Users> user = userRepository.findById(username.getId());
        return new ResponseApi(false, "Invalid username or password", null);
    }

    public Users getUserById(long id) {
        Optional<Users> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null); // Trả về đối tượng User nếu tìm thấy, nếu không tìm thấy trả về null
    }

    public void saveUser(Users user) {
        userRepository.save(user);
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }
}
