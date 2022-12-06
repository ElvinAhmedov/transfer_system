package com.company.transfersystem.service.functional;

import com.company.transfersystem.entity.CustomerEntity;
import com.company.transfersystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFunctionalService {
    private final CustomerRepository customerRepository;

    public CustomerFunctionalService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public CustomerEntity saveCustomer(CustomerEntity entity){
        return customerRepository.save(entity);
    }
    public CustomerEntity findByIdAndActiveOrElseNull(Long id){
        return customerRepository.findByIdAndActive(id,(byte)1).orElse(null);
    }
    public List<CustomerEntity> findAllByActiveOrElseNull(Byte active){
        return customerRepository.findAllByActive(active).orElse(null);
    }
}
