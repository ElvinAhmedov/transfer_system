package com.company.transfersystem.delegate;


import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.service.business.TransferBusinessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("saveTransfer")
public class SaveTransferDelegate implements JavaDelegate {
    private  final TransferBusinessService transferBusinessService;

    public SaveTransferDelegate(TransferBusinessService transferBusinessService) {
        this.transferBusinessService = transferBusinessService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        TransferRequest request = (TransferRequest) execution.getVariable("request");
        transferBusinessService.saveTransfer(request);


    }
}
