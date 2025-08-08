package com.AdressBook.app.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {
    private String message;
    private Object object;
    private List<String> errorMessage;

    public ResponseDTO(String message, List<String> errorMessage){
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public ResponseDTO(String message, Object object) {
        this.message = message;
        this.object = object;
    }
}
