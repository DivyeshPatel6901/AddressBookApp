package com.AdressBook.app.service;

import com.AdressBook.app.AddressBookApplication;
import com.AdressBook.app.DTO.AddressBookDTO;
import com.AdressBook.app.exception.AddressBookCustomException;
import com.AdressBook.app.model.AddressBook;
import com.AdressBook.app.repo.AddressBookRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepo addressBookRepo;

    public AddressBook addAddress(String firstName, String lastName, String city, String province, String pincode, String country, String phoneNo, String email) {
        AddressBook addressBook = new AddressBook(firstName, lastName, city, province, pincode, country, phoneNo, email);
        return addressBookRepo.save(addressBook);
    }


    public AddressBook addAddress(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        return addressBookRepo.save(addressBook);
    }


    public List<AddressBook> getAll() {
        return addressBookRepo.findAll();
    }

    public AddressBook getById(Integer id) {
        Optional<AddressBook> addressBook = addressBookRepo.findById(id);
        if( addressBook.isPresent() ) {
            return addressBook.get();
        }

        throw new AddressBookCustomException("Address with Id : " + id +
                " does not exist");
    }

    public AddressBook updateAddress(Integer id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = getById(id);
        if( addressBook != null ){
            addressBook.setAddressBook(addressBookDTO);
            return addressBookRepo.save(addressBook);
        }
        return null;
    }

    public String deleteAddress(Integer id) {
        AddressBook addressBook = getById(id);
        if( addressBook != null ){
            addressBookRepo.delete(addressBook);
            return "Address id " + id + " is deleted successfully.";
        }
        return "Address id " + id + " does not exist.";
    }

    public List<AddressBook> sortByPin() {
        return addressBookRepo.sortByPin();
    }
}
