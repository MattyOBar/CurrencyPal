package com.nashss.se.currencypalservice.lambda;

import com.nashss.se.currencypalservice.activity.requests.CreateTransactionRequest;
import com.nashss.se.currencypalservice.activity.results.CreateTransactionResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateTransactionLambda
        extends LambdaActivityRunner<CreateTransactionRequest, CreateTransactionResult>
        implements RequestHandler<LambdaRequest<CreateTransactionRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateTransactionRequest> input, Context context) {
        return super.runActivity(
            () -> input.fromBody(CreateTransactionRequest.class),
            (request, serviceComponent) ->
                    serviceComponent.provideCreateTransactionActivity().handleRequest(request)
        );
    }
}
