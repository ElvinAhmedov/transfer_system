package com.company.transfersystem.delegate.accounttoaccount;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.AccountBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkDebitorStatus")
public class CheckDebitorStatusDelegate implements JavaDelegate {
    private final AccountBusinessService accountBusinessService;

    public CheckDebitorStatusDelegate(AccountBusinessService accountBusinessService) {
        this.accountBusinessService = accountBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
      // TransferRequest request = (TransferRequest) execution.getVariable("ibanExist");
      TransferRequest request = (TransferRequest) execution.getVariable("request");
       Integer statusIsOk = accountBusinessService.checkStatus(request.getDebitorIban());
       execution.setVariable("statusIsOk",statusIsOk);
    }
}
