package com.company.transfersystem.delegate.cardtocard;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("creditorIban")
public class CheckCreditorIban implements JavaDelegate {
    private  final AccountBusinessService accountBusinessService;

    public CheckCreditorIban(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer creditorIbanExist = accountBusinessService.checkIban(request.getCreditorIban());
        execution.setVariable("creditorIbanExist",creditorIbanExist);
    }
}
