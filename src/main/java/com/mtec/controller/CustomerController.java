package com.mtec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mtec.model.Customer;
import com.mtec.service.ICustomerService;

@RestController
@CrossOrigin ("*")
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	
	@GetMapping("/cliente")
	public List<Customer> listar() {
	    return customerService.findAll();
	}
	@PostMapping("/cliente")
	public Customer guardar(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	@GetMapping("/cliente/{id}")
	public Customer getUnaCustomer(@PathVariable Integer id) {
		return customerService.findById(id);
	}
	
	@PutMapping("/cliente/{id}")
	public Customer modificar(@RequestBody Customer customer, @PathVariable Integer id) {
	    Customer customerActual = customerService.findById(id);
	    
	    if (customerActual != null) {
	        // Actualizar los campos necesarios del objeto customerActual con los valores del objeto customer
	        customerActual.setName(customer.getName());
	        customerActual.setTel(customer.getTel());
	        customerActual.setEmail(customer.getEmail());
	        customerActual.setLastVisitDate(customer.getLastVisitDate());
	        customerActual.setNetxVisitDate(customer.getNetxVisitDate());
	        customerActual.setNote(customer.getNote());
	        // Actualizar otros campos según sea necesario
	        
	        // Guardar los cambios en la base de datos
	        customerActual = customerService.save(customerActual);
	        
	        return customerActual;
	    } else {
	        // Si no se encuentra el customer con el ID proporcionado, puedes lanzar una excepción o retornar null, según tus necesidades
	        throw new IllegalArgumentException("No se encontró el cliente con ID: " + id);
	    }
	}

	

	
	
	
	
	@DeleteMapping("/cliente/{id}")
		public void eliminar (@PathVariable Integer id) {
		customerService.delete(id);

}
}