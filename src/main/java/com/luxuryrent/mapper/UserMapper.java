package com.luxuryrent.mapper;

import com.luxuryrent.domain.User;
import com.luxuryrent.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setPostalCode(user.getPostalCode());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setPostalCode(userDto.getPostalCode());
        user.setEmail(userDto.getEmail());
        return user;
    }
    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setPostalCode(user.getPostalCode());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public List<UserDto> mapToDtoList(List<User> userList) {
        return userList.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }
    public static User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setPostalCode(userDto.getPostalCode());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
