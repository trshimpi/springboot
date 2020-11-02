package com.hsbc.controller;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Customer;

@RestController
public class CustomerController {

	// Dummy database. Initialize with some dummy values.
	private static Map<Integer, Customer> customers;

	public CustomerController() {
		customers = new HashMap<Integer, Customer>();
		customers.put(101, new Customer(101, "Ramana", "ramana@gmail.com", "111111"));
		customers.put(201, new Customer(201, "Sudhir", "sudhir@gmail.com", "222222"));
		customers.put(301, new Customer(301, "Kishore", "kishore@hotmail.com", "333333"));

	}

	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public Collection<Customer> getCustomers() {
		return customers.values();
	}

	// default response XML
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}", produces = "application/json")

	public ResponseEntity getCustomer(@PathVariable("id") Integer id) {

		Customer customer = customers.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public String createCustomer(@RequestBody Customer customer) {

		if (!(customers.containsKey(customer.getId()))) {
			customers.put(customer.getId(), customer);
			return "Customer data created";
		}

		return "customer data already exists";

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
	public String deleteCustomer(@PathVariable Integer id) {

		if (customers.remove(id) == null)
			return "Customer does not exist";

		else
			return "Customer successfully deleted";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/customers")
	public String updateCustomer(@RequestBody Customer customer) {

		if (customers.containsKey(customer.getId())) {
			customers.put(customer.getId(), customer);
			return "Customer data updated";
		}

		return "customer not found";
	}

}
