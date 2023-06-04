package com.luxuryrent.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String name;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String postalCode;
    private String email;
}