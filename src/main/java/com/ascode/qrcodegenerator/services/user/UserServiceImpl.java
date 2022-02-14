package com.ascode.qrcodegenerator.services.user;

import com.ascode.qrcodegenerator.domains.User;
import com.ascode.qrcodegenerator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository){
        this.userRepository = Objects.requireNonNull(userRepository, "User repository can not be null");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(final Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(final User user) {
        return userRepository.save(user);
    }
}
