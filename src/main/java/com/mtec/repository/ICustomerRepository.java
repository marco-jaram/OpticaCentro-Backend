package com.mtec.repository;

import org.springframework.data.repository.CrudRepository;

import com.mtec.model.Customer;

public interface ICustomerRepository extends CrudRepository <Customer, Integer> {

}
