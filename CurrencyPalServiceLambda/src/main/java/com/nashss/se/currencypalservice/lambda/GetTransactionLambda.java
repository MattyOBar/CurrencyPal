package com.nashss.se.currencypalservice.lambda;

import com.nashss.se.currencypalservice.activity.requests.GetTransactionRequest;
import com.nashss.se.currencypalservice.activity.results.GetTransactionResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTransactionLambda
        extends LambdaActivityRunner<GetTransactionRequest, GetTransactionResult>
        implements RequestHandler<LambdaRequest<GetTransactionRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetTransactionRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
            () -> input.fromPath(path ->
                GetTransactionRequest.builder()
                    .withTransactionId(path.get("transactionId"))
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetTransactionActivity().handleRequest(request)
        );
    }
}
