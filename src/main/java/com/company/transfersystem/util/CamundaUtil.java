package com.company.transfersystem.util;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CamundaUtil {
    private  final RuntimeService runtimeService;

    public CamundaUtil(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }


    public <T> T startCamunda(String processKey, Serializable request, Class<T> object) {
        ProcessInstanceWithVariables processInstanceWithVariables = runtimeService.createProcessInstanceByKey(processKey)
                .setVariable("request", request)
                .executeWithVariablesInReturn();
        return processInstanceWithVariables.getVariables().getValue("response", object);

    }

}
