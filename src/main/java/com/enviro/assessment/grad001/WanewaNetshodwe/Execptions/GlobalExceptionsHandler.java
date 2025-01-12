package com.enviro.assessment.grad001.WanewaNetshodwe.Execptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Naming error:   did you Mean \"" + ex.getFieldError().getField()+"\"");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error: " + ex);
    }
    @ExceptionHandler(org.springframework.dao.InvalidDataAccessApiUsageException.class)
    public ResponseEntity<String> handleUpdateFailedExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found ");
    }

    @ExceptionHandler(java.util.NoSuchElementException.class)
    public ResponseEntity<String> handleNoDataFoundExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found ");
    }
    @ExceptionHandler(org.springframework.web.servlet.resource.NoResourceFoundException.class)
    public ResponseEntity<String> handleURIsExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler( com.enviro.assessment.grad001.WanewaNetshodwe.Execptions.NoCategoryException.class)
    public ResponseEntity<String> handleNoGuideLineFoundExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }






}
