package com.practice.repository;

import com.practice.entity.Address;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}