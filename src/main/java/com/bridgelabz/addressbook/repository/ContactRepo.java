package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.ContactData;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<ContactData,Integer> {
}
