package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserData,Integer> {
    @Query(value = "select user_id from address_book.user_data where email = :email",nativeQuery = true)
    String getUserIDByEmail(String email);

    @Query(value = "select email from address_book.user_data where email = :email",nativeQuery = true)
    String getEmailByEmail(String email);

    @Query(value = "select * from address_book.user_data where email = :email",nativeQuery = true)
    String getUserByEmail(String email);
}
