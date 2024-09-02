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
    public ResponseEntity<String> authorizeInvalidHandler(RuntimeException ex) {
        return new ResponseEntity<>("RuntimeException in throw exeption method", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> authorizeUnauthorizedHandler(RuntimeException ex) {
        return new ResponseEntity<>("RuntimeException in throw exeption method", HttpStatus.UNAUTHORIZED);
    }

}
