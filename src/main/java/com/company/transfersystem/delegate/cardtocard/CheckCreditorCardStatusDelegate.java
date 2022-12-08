package com.company.transfersystem.delegate.cardtocard;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.CardBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkCreditorCardStatus")
public class CheckCreditorCardStatusDelegate implements JavaDelegate {
    private final CardBusinessService cardBusinessService;

    public CheckCreditorCardStatusDelegate(CardBusinessService cardBusinessService) {
        this.cardBusinessService = cardBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        Integer creditorCardStatusIsOk = cardBusinessService.checkStatus(request.getCreditorCardId());
        execution.setVariable("creditorCardStatusIsOk",creditorCardStatusIsOk);
    }
}
