package com.ge.AddressBookApp.controller;

import com.ge.AddressBookApp.DTO.AddressBookDTO;
import com.ge.AddressBookApp.model.AddressBook;
import com.ge.AddressBookApp.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;

    // http://localhost:8081/addressbook/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello from Address Book";
    }

    // http://localhost:8081/addressbook/addaddress
    /*
    {
    "firstName" : "Divyesh", "lastName" : "Patel", "city" : "Mehsana",
    "state" : "Gujarat", "zip" : "384002", "phoneNo" : "990995005", "email" : "divyesh@gmail.com"
    }
     */
    @PostMapping("/addaddress")
    public AddressBook addAddress(@Valid @RequestBody AddressBookDTO addressBookDTO){
        return addressBookService.addAddress(addressBookDTO);
    }

    // http://localhost:8081/addressbook/getall
    @GetMapping("/getall")
    public List<AddressBook> getAll(){
        return addressBookService.getAll();
    }

    // http://localhost:8081/addressbook/getbyid/2
    @GetMapping("/getbyid/{id}")
    public AddressBook getById(@PathVariable int id){
        return addressBookService.getById(id);
    }

    //  http://localhost:8081/addressbook/update/1
    @PutMapping("/update/{id}")
    public AddressBook updateAddress(@PathVariable int id, @Valid @RequestBody AddressBookDTO addressBookDTO){
        return addressBookService.updateAddress(id, addressBookDTO);
    }

    // http://localhost:8081/addressbook/delete/2
    @DeleteMapping("/delete/{id}")
    public String deleteAddress(@PathVariable int id){
        return addressBookService.deleteAddress(id);
    }

}
