package com.ge.AddressBookApp.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDTO {
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z]{2,}", message = "First Name is in Invalid Format")
    private String firstName;
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z]{2,}", message = "Last Name is in Invalid Format")
    private String lastName;
    private String city;
    private String state;
    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Zip Code is in Invalid Format")
    private String zip;
    @Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Phone number is in Invalid Format")
    private String phoneNo;
    @Pattern(regexp = "[a-z0-9]{1,}+([.+_-][0-9 a-z A-Z]{1,})?+@+[a-z0-9]{1,}+[.][a-z]{2,}+([.][a-z]{1,})?",
                message = "Email is in Invalid Format")
    private String email;
}
