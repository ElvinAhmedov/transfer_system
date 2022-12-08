package com.company.transfersystem.delegate.cardtocard;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import com.company.transfersystem.service.business.CardBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("debitorAccountStatus")
public class CheckDebitorAccountStatus implements JavaDelegate {
    private final AccountBusinessService accountBusinessService;

    public CheckDebitorAccountStatus(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer debitorAccountStatusIsOk = accountBusinessService.checkStatus(request.getDebitorIban());
        execution.setVariable("debitorAccountStatusIsOk",debitorAccountStatusIsOk);
    }
}
