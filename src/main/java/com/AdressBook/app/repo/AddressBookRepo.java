package com.AdressBook.app.repo;

import com.AdressBook.app.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBook, Integer> {


    @Query(value = "select * from address_book order by pincode", nativeQuery = true)
    List<AddressBook> sortByPin();

}
