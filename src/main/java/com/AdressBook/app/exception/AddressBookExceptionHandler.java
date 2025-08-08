package com.AdressBook.app.exception;

import com.AdressBook.app.DTO.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressBookExceptionHandler {

    @ExceptionHandler(AddressBookCustomException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookCustomException(AddressBookCustomException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing Request",exception.getMessage());
        System.out.println("Exception Handler Class!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
