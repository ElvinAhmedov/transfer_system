package com.company.transfersystem.controller;


import com.company.transfersystem.dto.request.CustomerRequest;
import com.company.transfersystem.dto.response.CustomerResponse;
import com.company.transfersystem.service.business.CustomerBusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerBusinessService customerService;

    public CustomerController(CustomerBusinessService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerAddRequest) {
        customerService.saveCustomer(customerAddRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Saved");
    }
    @GetMapping()
    public ResponseEntity<List<CustomerResponse>> getCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer(id));
    }
    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestParam Long id, @RequestBody CustomerRequest request ){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id,request));
    }
}
