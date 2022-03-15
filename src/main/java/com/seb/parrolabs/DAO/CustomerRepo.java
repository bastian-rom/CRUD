package com.seb.parrolabs.DAO;

import com.seb.parrolabs.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
    Customer findByPhone(Integer phone);
}
