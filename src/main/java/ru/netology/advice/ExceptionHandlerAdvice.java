package ru.netology.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.exeption.InvalidCredentials;
import ru.netology.exeption.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<InvalidCredentials> authorizeInvalidHandler(InvalidCredentials ex) {
        InvalidCredentials invalidCredentials = new InvalidCredentials(ex.getMessage());
        return new ResponseEntity<>(invalidCredentials, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<UnauthorizedUser> authorizeUnauthorizedHandler(UnauthorizedUser ex) {
        UnauthorizedUser unauthorizedUser = new UnauthorizedUser(ex.getMessage());
        return new ResponseEntity<>(unauthorizedUser, HttpStatus.UNAUTHORIZED);
    }
}
