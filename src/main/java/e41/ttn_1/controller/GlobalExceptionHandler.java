package e41.ttn_1.controller;

import e41.ttn_1.dto.customers.CustomerResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleControllerViolationException(ConstraintViolationException e){
        CustomerResponse response = new CustomerResponse();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleControllerNullPointerException(ConstraintViolationException e){
        CustomerResponse response = new CustomerResponse();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
