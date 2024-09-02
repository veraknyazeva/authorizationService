package ru.netology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.exeption.InvalidCredentials;
import ru.netology.exeption.UnauthorizedUser;
import ru.netology.service.Authorities;
import ru.netology.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }



    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> authorizeUnauthorizedHandler(RuntimeException ex) {
        return new ResponseEntity<>("RuntimeException in throw exception ", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> authorizeInvalidHandler(RuntimeException ex) {
        return new ResponseEntity<>("RuntimeException UnauthorizedUser", HttpStatus.BAD_REQUEST);
    }
}
