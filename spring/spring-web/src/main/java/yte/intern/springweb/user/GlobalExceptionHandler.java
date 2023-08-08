package yte.intern.springweb.user;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = {IllegalArgumentException.class})
//    public String handleException(IllegalArgumentException e) {
//        return "Hatalı İstek";
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//
//        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
//        System.out.println(errorMessage);
//        return ResponseEntity.badRequest().body(errorMessage);
//    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
//        String errorMessage = "Invalid input. Please provide valid data.";
//        return ResponseEntity.badRequest().body(errorMessage);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
//        List<String> errorMessages = new ArrayList<>();
//
//        for (FieldError fieldError : fieldErrors) {
//            errorMessages.add(fieldError.getDefaultMessage());
//        }
//
//        return ResponseEntity.badRequest().body(errorMessages);

        List<String> errorMessages = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        System.out.println(errorMessages);

        return ResponseEntity.badRequest().body(errorMessages);
    }
}