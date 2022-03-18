package com.seb.parrolabs.controllers;

import com.seb.parrolabs.models.Customer;
import com.seb.parrolabs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CostumerController {

    private final CustomerService service;
    @Autowired
    public CostumerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping({"","all"})
    public List<Customer> getCustomers(ModelMap mod){
        return this.service.read();
    }

    @GetMapping("/mail/{email}")
    public Customer getCustomersByEmail(@PathVariable("email") String email, ModelMap model){
        return this.service.searchByEmail(email);
    }
    @GetMapping("/id/{id}")
    public Optional<Customer> getCustomersByID(@PathVariable("id") Integer id, ModelMap model){

        return this.service.searchByID(id);
    }
    @GetMapping("/phone/{phone}")
    public Customer getCustomersByPhone(@PathVariable("phone") Integer phone, ModelMap model){
        return this.service.searchByPhone(phone);
    }
    @PostMapping("/save")
    public boolean saveCustomer(@RequestBody Customer customer, ModelMap model){
        return this.service.save(customer);
    }
    @PostMapping("/update_by_id/{id}")
    public boolean updateCustomerByID(@PathVariable("id")Integer id,@RequestBody Customer newCustomer, ModelMap model){
        return this.service.update(newCustomer,service.searchByID(id).get());
    }
    @PostMapping("/update_by_email/{email}")
    public boolean updateCustomerByEmail(@PathVariable("email")String email, @RequestBody Customer newCustomer, ModelMap model){
        return this.service.update(newCustomer,service.searchByEmail(email));
    }
    @PostMapping("/update_by_phone/{phone}")
    public boolean updateCustomerByPhone(@PathVariable("id")Integer phone,@RequestBody Customer newCustomer, ModelMap model){
        return this.service.update(newCustomer,service.searchByPhone(phone));
    }
}
