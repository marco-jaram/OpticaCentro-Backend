package com.mtec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mtec.model.Customer;
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:keyword% " +
           "OR c.tel LIKE %:keyword% " +
           "OR c.email LIKE %:keyword% " +
           "OR c.lastVisitDate LIKE %:keyword% " +
           "OR c.nextVisitDate LIKE %:keyword%")
    public List<Customer> findAll(@Param("keyword") String keyword);
}