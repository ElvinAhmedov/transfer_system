package com.company.transfersystem.delegate;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCreditorStatus")
public class CheckCreditorStatusDelegate implements JavaDelegate {
    private final AccountBusinessService accountBusinessService;

    public CheckCreditorStatusDelegate(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer creditorStatusIsOk = accountBusinessService.checkStatus(request.getCreditorIban());
        execution.setVariable("creditorStatusIsOk",creditorStatusIsOk);
    }
}
