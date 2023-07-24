package com.company.dto.entityDTO;

import com.company.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Integer id;
    String name;
    String surname;
    String email;
    String password;

    public UserDTO() {

    }

    public UserDTO(User users) {
        this.id = users.getId();
        this.name = users.getName();
        this.surname = users.getSurname();
        this.email = users.getEmail();
        this.password = users.getPassword();
    }
}
