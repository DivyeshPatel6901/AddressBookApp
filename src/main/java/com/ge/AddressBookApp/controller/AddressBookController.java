package com.ge.AddressBookApp.controller;

import com.ge.AddressBookApp.DTO.AddressBookDTO;
import com.ge.AddressBookApp.DTO.ResponseDTO;
import com.ge.AddressBookApp.model.AddressBook;
import com.ge.AddressBookApp.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
/*

    // http://localhost:8081/addressbook/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello from Address Book";
    }

    // http://localhost:8081/addressbook/addaddress
    */
/*
    {
    "firstName" : "Divyesh", "lastName" : "Patel", "city" : "Mehsana",
    "state" : "Gujarat", "zip" : "384002", "phoneNo" : "990995005", "email" : "divyesh@gmail.com"
    }
     */


    @PostMapping("/addaddress")
    public ResponseEntity<ResponseDTO> addAddress(@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBook addressBook = addressBookService.addAddress(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("ADDED SUCCESSFULLY", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // http://localhost:8081/addressbook/getall
    @GetMapping("/getall")
    public List<AddressBook> getAll(){
        return addressBookService.getAll();
    }

    // http://localhost:8081/addressbook/getbyid/2
    @GetMapping("/getbyid")
    public AddressBook getById(@RequestHeader Integer id){
        return addressBookService.getById(id);
    }

    //  http://localhost:8081/addressbook/update/1
    @PutMapping("/update")
    public AddressBook updateAddress(@RequestHeader Integer id, @Valid @RequestBody AddressBookDTO addressBookDTO){
        return addressBookService.updateAddress(id, addressBookDTO);
    }

    // http://localhost:8081/addressbook/delete/2
    @DeleteMapping("/delete")
    public String deleteAddress(@RequestHeader Integer id){
        return addressBookService.deleteAddress(id);
    }

    @GetMapping("/sortbycity")
    public List<AddressBook> sortByCity(){
        return addressBookService.sortByCity();
    }


}
