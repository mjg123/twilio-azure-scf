package com.example.webhooks.azure;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class AzureFunctionWrapper extends AzureSpringBootRequestHandler<String, String> {

    @FunctionName("respondToSms")
    public HttpResponseMessage execute(
        @HttpTrigger(
            name = "request",
            methods = {HttpMethod.GET, HttpMethod.POST},
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request, ExecutionContext context) {

        return request
            .createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(request.getQueryParameters().get("Body"), context))
            .header("Content-Type", "text/plain")
            .build();
    }
}
