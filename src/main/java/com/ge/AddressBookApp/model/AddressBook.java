package com.ge.AddressBookApp.model;

import com.ge.AddressBookApp.DTO.AddressBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBook {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;
    private String phoneNo;
    private String email;

    public AddressBook(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
        this.phoneNo = addressBookDTO.getPhoneNo();
        this.email = addressBookDTO.getEmail();
    }
    public void setAddressBook(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
        this.phoneNo = addressBookDTO.getPhoneNo();
        this.email = addressBookDTO.getEmail();
    }
}
