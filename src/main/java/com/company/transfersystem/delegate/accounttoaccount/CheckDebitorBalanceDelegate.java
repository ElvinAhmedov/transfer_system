package com.company.transfersystem.delegate.accounttoaccount;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkDebitorBalance")
public class CheckDebitorBalanceDelegate implements JavaDelegate {
    private final AccountBusinessService accountBusinessService;

    public CheckDebitorBalanceDelegate(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer balanceIsOk = accountBusinessService.checkBalance(request.getDebitorIban(),request.getAmount());
        execution.setVariable("balanceIsOk",balanceIsOk);
    }
}
