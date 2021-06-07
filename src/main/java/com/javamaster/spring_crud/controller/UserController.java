package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.dto.UserDto;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public UserDto saveUsers(@RequestBody UserDto usersDto) throws ValidationException {
        log.info("Handling save users: " + usersDto);
        return userService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAllUsers() {
        log.info("Handling find all users request");
        return userService.findAll();
    }

    @GetMapping("/findByLogin")
    public UserDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return userService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(method = RequestMethod.PATCH)
    public void patch(@RequestBody int myVariable) {
    }




}
