package com.company.transfersystem.service.business;

import com.company.transfersystem.dto.request.AccountRequest;
import com.company.transfersystem.dto.response.AccountResponse;
import com.company.transfersystem.entity.AccountEntity;
import com.company.transfersystem.entity.CustomerEntity;
import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.ErrorEnum;
import com.company.transfersystem.exception.BaseException;
import com.company.transfersystem.repository.CustomerRepository;
import com.company.transfersystem.service.functional.AccountFunctionalService;
import com.company.transfersystem.service.functional.CustomerFunctionalService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountBusinessService {
    private final AccountFunctionalService accountFunctionalService;
    private final CustomerFunctionalService customerFunctionalService;


    public AccountBusinessService(AccountFunctionalService accountFunctionalService, CustomerFunctionalService customerFunctionalService) {
        this.accountFunctionalService = accountFunctionalService;
        this.customerFunctionalService = customerFunctionalService;
    }

    public AccountResponse saveAccount(AccountRequest accountRequest) {
        CustomerEntity customerEntity = getCustomerId(accountRequest);
        AccountEntity accountEntity = convertRequestToAccount(accountRequest);
        accountEntity.setCustomerEntity(customerEntity);
        accountFunctionalService.saveAccount(accountEntity);
        AccountResponse response = convertAccountToResponse(accountEntity);
        return response;

    }

    public AccountResponse getAccount(Long id) {

        AccountEntity account = accountFunctionalService.findByIdAndActiveOrElseNull(id);

        AccountResponse response = convertAccountToResponse(account);
        return response;
    }

    public List<AccountResponse> getAccounts() {
        List<AccountEntity> accountEntity = accountFunctionalService.findAllByActiveOrElseNull((byte) 1);
        List<AccountResponse> response = accountEntity.stream()
                .map((AccountEntity account) -> (convertAccountToResponse(account)))
                .collect(Collectors.toList());
        return response;
    }

    public AccountResponse updateAccount(Long id, AccountRequest request) {
        AccountEntity account = accountFunctionalService.findByIdAndActiveOrElseNull(id);
        accountFunctionalService.saveAccount(check(account, request));
        AccountResponse response = convertAccountToResponse(account);
        return response;
    }

    public Integer checkIban(String iban) {
        if (accountFunctionalService.findByIban(iban) == null)
            return 0;
        else
            return 1;
    }

    public Integer checkStatus(String iban) {
        AccountEntity entity = accountFunctionalService.findByIban(iban);
        if (entity.getStatus() == AccountStatusEnum.BLOCK)
            return 0;
        else
            return 1;
    }

    public Integer checkBalance(String iban,BigDecimal amount) {
        AccountEntity entity = accountFunctionalService.findByIban(iban);
        if (entity.getBalance().compareTo(amount) < 0)
            return 0;
        else
            return 1;
    }

    private AccountEntity check(AccountEntity account, AccountRequest request) {
        if (StringUtils.hasText(request.getAccountNumber()))
            account.setAccountNumber(request.getAccountNumber());
        if (StringUtils.hasText(request.getCurrency().toString()))
            account.setCurrency(request.getCurrency());
        if (request.getBalance() != null)
            account.setBalance(request.getBalance());
        if (StringUtils.hasText(request.getIban()))
            account.setIban(request.getIban());
        if (request.getStatus() != null)
            account.setStatus(request.getStatus());
        if (request.getCustomerId() != null)
            account.setId(request.getCustomerId());
        return account;
    }

    private CustomerEntity getCustomerId(AccountRequest request) {
        CustomerEntity entity = customerFunctionalService.findByIdAndActiveOrElseNull(request.getCustomerId());
        return entity;
    }

    private AccountEntity convertRequestToAccount(AccountRequest request) {
        AccountEntity entity = new AccountEntity()
                .setAccountNumber(request.getAccountNumber())
                .setCurrency(request.getCurrency())
                .setBalance(request.getBalance())
                .setIban(request.getIban())
                .setStatus(request.getStatus());

        return entity;
    }

    private AccountResponse convertAccountToResponse(AccountEntity accountEntity) {
        return new AccountResponse()
                .setAccountNumber(accountEntity.getAccountNumber())
                .setBalance(accountEntity.getBalance())
                .setCurrency(accountEntity.getCurrency())
                .setIban(accountEntity.getIban())
                .setId(accountEntity.getCustomerEntity().getId());


    }


}
