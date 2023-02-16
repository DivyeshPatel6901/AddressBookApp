package com.ge.AddressBookApp.repo;

import com.ge.AddressBookApp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBook,Integer> {
}
