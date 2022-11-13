package com.davidorellana.leveltworestapi.user.data;

import com.davidorellana.leveltworestapi.user.dto.UserDto;

public class User {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String createAt;
    private static Integer idIncrement = 1;

    public User() { }

    public User(UserDto userDto) {
        this.id = idIncrement++;
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
