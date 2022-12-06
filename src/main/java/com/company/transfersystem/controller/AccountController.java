package com.company.transfersystem.controller;

import com.company.transfersystem.dto.request.AccountRequest;
import com.company.transfersystem.dto.response.AccountResponse;
import com.company.transfersystem.service.business.AccountBusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountBusinessService accountService;

    public AccountController(AccountBusinessService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/add")
    public ResponseEntity addAccount(@RequestBody AccountRequest accountRequest){
        accountService.saveAccount(accountRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }
    @GetMapping
    public ResponseEntity<List<AccountResponse>>getAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccounts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse>getAccount(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccount(id));
    }
    @PutMapping
    public ResponseEntity<AccountResponse> updateAccount(@RequestParam Long id, @RequestBody AccountRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.updateAccount(id,request));
    }


}
