package com.ge.AddressBookApp.service;

import com.ge.AddressBookApp.DTO.AddressBookDTO;
import com.ge.AddressBookApp.exception.AddressBookCustomException;
import com.ge.AddressBookApp.model.AddressBook;
import com.ge.AddressBookApp.repo.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    @Autowired
    private AddressBookRepo addressBookRepo;


    public AddressBook addAddress(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        return addressBookRepo.save(addressBook);
    }

    public List<AddressBook> getAll() {
        return addressBookRepo.findAll();
    }

    public AddressBook getById(int id) {
        Optional<AddressBook> addressBook = addressBookRepo.findById(id);
        if( addressBook.isPresent() ){
            return addressBook.get();
        }
        throw new AddressBookCustomException("Address with Id : " + id +
                                            " does not exist");
    }

    public AddressBook updateAddress(int id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = getById(id);
        if( addressBook != null ){
            addressBook.setAddressBook(addressBookDTO);
            return addressBookRepo.save(addressBook);
        }
        return null;
    }

    public String deleteAddress(int id) {
        AddressBook addressBook = getById(id);
        if(addressBook != null){
            addressBookRepo.deleteById(id);
            return "Id : " + id + " deleted successfully";
        }
        return "Id : " + id + " does not exist";
    }
}
