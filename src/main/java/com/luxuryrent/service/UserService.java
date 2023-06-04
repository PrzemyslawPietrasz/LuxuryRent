package com.luxuryrent.service;

import com.luxuryrent.domain.User;
import com.luxuryrent.domain.UserDto;
import com.luxuryrent.mapper.UserMapper;
import com.luxuryrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto loginUser(UserDto userDto) {
        // Sprawdzenie poprawności danych logowania
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null || !user.getPassword().equals(userDto.getPassword())) {
            throw new IllegalArgumentException("Niepoprawna nazwa użytkownika lub hasło.");
        }

        // Zalogowano pomyślnie
        return userMapper.mapToDto(user);
    }

    public UserDto registerUser(UserDto userDto) {
        // Sprawdzenie unikalności nazwy użytkownika
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new IllegalArgumentException("Użytkownik o podanej nazwie już istnieje.");
        }

        // Zapisanie użytkownika do bazy danych
        User user = userMapper.mapToEntity(userDto);
        User savedUser = userRepository.save(user);

        // Zwrócenie zapisanego użytkownika jako UserDto
        return userMapper.mapToDto(savedUser);
    }
}

