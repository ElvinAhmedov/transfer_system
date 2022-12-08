package com.company.transfersystem.delegate.cardtocard;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import com.company.transfersystem.service.business.CardBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("debitorIban")
public class CheckDebitorIban implements JavaDelegate {
    private final AccountBusinessService accountBusinessService;

    public CheckDebitorIban(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer debitorIbanExist = accountBusinessService.checkIban(request.getDebitorIban());
        execution.setVariable("debitorIbanExist",debitorIbanExist);
    }
}
