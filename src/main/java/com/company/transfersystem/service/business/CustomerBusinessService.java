package com.company.transfersystem.service.business;

import com.company.transfersystem.dto.request.CustomerRequest;
import com.company.transfersystem.dto.response.CustomerResponse;
import com.company.transfersystem.entity.CustomerEntity;
import com.company.transfersystem.enums.ErrorEnum;
import com.company.transfersystem.exception.BaseException;
import com.company.transfersystem.repository.CustomerRepository;
import com.company.transfersystem.service.functional.CustomerFunctionalService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerBusinessService {

    private final CustomerFunctionalService customerFunctionalService;

    public CustomerBusinessService(CustomerFunctionalService customerFunctionalService) {
        this.customerFunctionalService = customerFunctionalService;
    }

    public CustomerResponse saveCustomer(CustomerRequest customerAddRequest) {
        CustomerEntity entity = convertRequestToCustomer(customerAddRequest);
        customerFunctionalService.saveCustomer(entity);
        CustomerResponse response = convertCustomerToResponse(entity);
        return response;
    }

    public CustomerResponse getCustomer(Long id) {
        CustomerEntity entity = customerFunctionalService.findByIdAndActiveOrElseNull(id);
        CustomerResponse response = convertCustomerToResponse(entity);
        return  response;
    }

    public List<CustomerResponse> getCustomers() {
            List<CustomerEntity> entity= customerFunctionalService.findAllByActiveOrElseNull((byte)1);
            List<CustomerResponse> responses = entity.stream()
                    .map((CustomerEntity customerEntity)->(convertCustomerToResponse(customerEntity)))
                    .collect(Collectors.toList());
            return responses;
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest request) {
        CustomerEntity customerEntity = customerFunctionalService.findByIdAndActiveOrElseNull(id);
        customerFunctionalService.saveCustomer(checkCustomer(customerEntity,request));
       CustomerResponse response = convertCustomerToResponse(customerEntity);

        return response;
    }

    private CustomerEntity checkCustomer(CustomerEntity customerEntity, CustomerRequest request) {
        if (StringUtils.hasText(request.getName()))
            customerEntity.setName(request.getName());
        if (StringUtils.hasText(request.getSurname()))
            customerEntity.setName(request.getName());
        if (StringUtils.hasText(request.getFatherName()))
            customerEntity.setFatherName(request.getFatherName());
        if (StringUtils.hasText(request.getAddress()))
            customerEntity.setAddress(request.getAddress());
        if (request.getAge() != null)
            customerEntity.setAge(request.getAge());
        if (StringUtils.hasText(request.getFin()))
            customerEntity.setFin(request.getFin());
        return customerEntity;
    }

    private CustomerEntity convertRequestToCustomer(CustomerRequest request) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(request.getName());
        customerEntity.setSurname(request.getSurname());
        customerEntity.setAge(request.getAge());
        customerEntity.setFatherName(request.getFatherName());
        customerEntity.setAddress(request.getAddress());
        customerEntity.setFin(request.getFin());
        return customerEntity;

    }
    private CustomerResponse convertCustomerToResponse(CustomerEntity customerEntity){
        return new CustomerResponse()
                .setAddress(customerEntity.getAddress())
                .setName(customerEntity.getName())
                .setSurname(customerEntity.getSurname())
                .setId(customerEntity.getId());
    }
}
