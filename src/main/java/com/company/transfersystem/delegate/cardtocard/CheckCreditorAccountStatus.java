package com.company.transfersystem.delegate.cardtocard;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("creditorAccountStatus")
public class CheckCreditorAccountStatus implements JavaDelegate {
    private final AccountBusinessService accountBusinessService;

    public CheckCreditorAccountStatus(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer creditorAaccountStatusIsOk = accountBusinessService.checkStatus(request.getCreditorIban());
        execution.setVariable("creditorAaccountStatusIsOk",creditorAaccountStatusIsOk);
    }
}
