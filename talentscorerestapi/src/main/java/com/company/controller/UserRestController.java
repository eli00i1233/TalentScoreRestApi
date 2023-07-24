package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.SignDTO;
import com.company.dto.entityDTO.UserDTO;
import com.company.entity.User;
import com.company.inter.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class UserRestController {
    @Autowired
    private UserRepository usersRepository;


    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestParam String email,
                                             @RequestParam String password) {
        User user = usersRepository.findByEmailAndPassword(email, password);
        UserDTO userDTO = new UserDTO(user);
        if (user != null) {
            System.out.println("succesfully login");
            return ResponseEntity.ok(ResponseDTO.of(userDTO, "succesfully login"));
        } else {
            System.out.println("user not found");
            return ResponseEntity.ok(ResponseDTO.of(null, 1, "user not found"));
        }
    }


    @PostMapping("/signIn")
    public ResponseEntity<ResponseDTO> signIn(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String password) {//required=false olmaz yığışdır
        User u = new User(name, surname, email, password);

        User user = usersRepository.save(u);
        SignDTO signDTO = new SignDTO(user);
        if (user != null) {
            System.out.println("succesfully added");
            return ResponseEntity.ok(ResponseDTO.of(signDTO, "succesfully succesfully added"));
        } else {
            System.out.println("user not added");
            return ResponseEntity.ok(ResponseDTO.of(null, 1, "user not added"));
        }
    }

}
