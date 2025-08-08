package com.AdressBook.app.controller;

import com.AdressBook.app.DTO.AddressBookDTO;
import com.AdressBook.app.exception.AddressBookCustomException;
import com.AdressBook.app.model.AddressBook;
import com.AdressBook.app.service.AddressBookService;
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
        System.out.println("Hello World is mapped");
        return "Hello World Divyesh!!";
    }

//    @PostMapping("/addaddress")
//    public AddressBook addAddress(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String city, @RequestParam String province, @RequestParam String pincode, @RequestParam String country, @RequestParam String phoneNo, @RequestParam String email) {
//        AddressBook addressBook = addressBookService.addAddress(firstName, lastName, city, province, pincode, country, phoneNo, email);
//        return addressBook;
//    }

    // localhost:8080/addressbook/addaddress
    @PostMapping("/addaddress")
    public AddressBook addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookService.addAddress(addressBookDTO);
        return addressBook;
    }

    // http://localhost:8080/addressbook/getall
    @GetMapping("/getall")
    public List<AddressBook> getAll(){
        return addressBookService.getAll();
    }

    // http://localhost:8080/addressbook/getbyid/2
    @GetMapping("/getbyid")
    public AddressBook getById(@RequestHeader Integer id){
        return addressBookService.getById(id);
    }



    // http://localhost:8080/addressbook/update/1
    @PutMapping("/update")
    public AddressBook updateAddress(@RequestHeader Integer id, @RequestBody AddressBookDTO addressBookDTO){
        return addressBookService.updateAddress(id, addressBookDTO);
    }



    // http://localhost:8080/addressbook/delete/2
    @DeleteMapping("/delete")
    public String deleteAddress(@RequestHeader Integer id){
        return addressBookService.deleteAddress(id);
    }

    // http://localhost:8080/addressbook/sortbycity
    @GetMapping("/sortbypin")
    public List<AddressBook> sortByPin(){
        return addressBookService.sortByPin();
    }

}
