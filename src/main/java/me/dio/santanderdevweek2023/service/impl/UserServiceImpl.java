package me.dio.santanderdevweek2023.service.impl;

import me.dio.santanderdevweek2023.domain.model.User;
import me.dio.santanderdevweek2023.domain.repository.UserRepository;
import me.dio.santanderdevweek2023.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    // construtor que irá injetar o userRepository

    public UserServiceImpl (UserRepository userRepository){

        this.userRepository = userRepository;

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
