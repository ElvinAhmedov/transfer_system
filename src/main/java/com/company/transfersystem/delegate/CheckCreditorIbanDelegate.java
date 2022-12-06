package com.company.transfersystem.delegate;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("checkCreditorIban")
public class CheckCreditorIbanDelegate implements JavaDelegate {
    private  final AccountBusinessService accountBusinessService;

    public CheckCreditorIbanDelegate(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer creditorIbanExist = accountBusinessService.checkIban(request.getCreditorIban());
        execution.setVariable("creditorIbanExist",creditorIbanExist);
    }
}
