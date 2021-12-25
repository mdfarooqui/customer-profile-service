/**
 * 
 */
package com.ilogix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilogix.models.Customer;

/**
 * @author mfarooq
 *
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerProfile {

  /**
   * Get all customers
   *
   * @return the list
   */
  @GetMapping("/profile/{profileId}")
  public List<Customer> getCustomerProfileById() {
	List<Customer> customerList = new ArrayList<Customer>();
	Customer customer = new Customer();
	customer.setCustId(1000000);
	customer.setFirstName("Johna");
	customer.setLastName("Khemistry");
	customer.setEmailAddress("johna.Khemistry@ilogixsolutions.com");
	customerList.add(customer);
	
    return customerList;
    
  }

  
}

