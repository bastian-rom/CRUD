package com.seb.parrolabs.services;

import com.seb.parrolabs.DAO.CustomerRepo;
import com.seb.parrolabs.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Autowired
    private CustomerRepo customerRepo;

    public boolean valid(String check) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(check);
        boolean numberCheck = false;
        try {
            numberCheck = Math.abs(Integer.parseInt(check)) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return matcher.find() ? true : numberCheck;
    }

    @Override
    public boolean create(Customer newCustomer) {
        try{
            customerRepo.save(newCustomer);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Customer> read() {
        return (List<Customer>) customerRepo.findAll();
    }

    @Override
    public boolean update(Customer newCustomer,Customer oldCustomer) {
        try {
            customerRepo.findByEmail(oldCustomer.getEmail()).setName(newCustomer.getName());
            customerRepo.findByEmail(oldCustomer.getEmail()).setPhone(newCustomer.getPhone());
            customerRepo.findByEmail(oldCustomer.getEmail()).setShippingAddress(newCustomer.getShippingAddress());
            return true;
        }catch (Exception e){
            System.out.println("Could not update customer: "+e);
            return false;
        }
    }

    @Override
    public Customer delete(Customer customer) {
        Customer customerInTrash = customerRepo.findByEmail(customer.getEmail());
        customerRepo.deleteById(customer.getId());
        return customerInTrash;
    }

    @Override
    public boolean save(Customer customer) {
        try{
            customerRepo.save(customer);
            return true;
        }catch (Exception e){
            System.out.println("Could not update customer: "+e);
            return false;
        }
    }

    @Override
    public Customer searchByEmail(String email) {
        if(this.valid(email))
            return this.customerRepo.findByEmail(email);
        else
            return null;
    }

    @Override
    public Customer searchByPhone(Integer phone) {
        if(this.valid(phone.toString()))
            return this.customerRepo.findByPhone(phone);
        else
            return null;
    }

    @Override
    public Optional<Customer> searchByID(Integer id) {
        if(this.valid(id.toString()))
            return this.customerRepo.findById(id);
        else
            return null;
    }
}
