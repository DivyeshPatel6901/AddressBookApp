package com.AdressBook.app.DTO;

import lombok.Data;

@Data
public class AddressBookDTO {
    private String firstName;
    private String lastName;
    private String city;
    private String province;
    private String pincode;
    private String country;
    private String phoneNo;
    private String email;
}
