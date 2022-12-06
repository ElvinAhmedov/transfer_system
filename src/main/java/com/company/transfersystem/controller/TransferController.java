package com.company.transfersystem.controller;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.dto.response.BaseResponse;
import com.company.transfersystem.dto.response.TransferResponse;
import com.company.transfersystem.util.CamundaUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final CamundaUtil camundaUtil;


    public TransferController(CamundaUtil camundaUtil) {
        this.camundaUtil = camundaUtil;
    }

    @PostMapping("/start")
    public ResponseEntity<BaseResponse<TransferResponse>> startTransfer(@RequestBody TransferRequest request) {
        TransferResponse transferResponse = camundaUtil
                .startCamunda(
                       "account_to_account",
                        request, TransferResponse.class);
        return ResponseEntity.ok(BaseResponse.success(transferResponse));
    }

}
