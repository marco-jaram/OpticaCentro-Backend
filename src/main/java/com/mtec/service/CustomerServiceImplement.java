package com.mtec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtec.model.Customer;

import com.mtec.repository.ICustomerRepository;

@Service
public class CustomerServiceImplement implements ICustomerService {
	@Autowired
private ICustomerRepository customerRepository;
	@Override
	public List<Customer> findAll() {
		
		return (List<Customer>) customerRepository.findAll();
	}

	
	
	@Override
	public Customer save(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer findById(Integer id) {
		
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		customerRepository.deleteById(id);
		
	}

}
