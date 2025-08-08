package com.AdressBook.app.model;

import com.AdressBook.app.DTO.AddressBookDTO;
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
    private String province;
    private String pincode;
    private String country;
    private String phoneNo;
    private String email;

    public AddressBook(String firstName, String lastName, String city, String province, String pincode, String country, String phoneNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.province = province;
        this.pincode = pincode;
        this.country = country;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.city = addressBookDTO.getCity();
        this.province = addressBookDTO.getProvince();
        this.pincode = addressBookDTO.getPincode();
        this.country = addressBookDTO.getCountry();
        this.phoneNo = addressBookDTO.getPhoneNo();
        this.email = addressBookDTO.getEmail();
    }

    public void setAddressBook(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.city = addressBookDTO.getCity();
        this.province = addressBookDTO.getProvince();
        this.pincode = addressBookDTO.getPincode();
        this.phoneNo = addressBookDTO.getPhoneNo();
        this.email = addressBookDTO.getEmail();
    }

}
