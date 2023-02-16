package com.ge.AddressBookApp.exception;

import com.ge.AddressBookApp.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AdressBookExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> objectErrorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessage = objectErrorList.stream().
                map(objectError -> objectError.getDefaultMessage()).
                collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing request",errorMessage);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressBookCustomException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookCustomException(AddressBookCustomException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing Request",exception.getMessage());
        return new ResponseEntity<>(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
