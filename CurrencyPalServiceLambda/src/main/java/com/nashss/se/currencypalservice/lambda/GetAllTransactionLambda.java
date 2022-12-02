package com.nashss.se.currencypalservice.lambda;

import com.nashss.se.currencypalservice.activity.requests.GetAllTransactionRequest;
import com.nashss.se.currencypalservice.activity.results.GetAllTransactionResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class GetAllTransactionLambda
    extends LambdaActivityRunner<GetAllTransactionRequest, GetAllTransactionResult>
    implements RequestHandler<LambdaRequest<GetAllTransactionRequest>, LambdaResponse> {


    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllTransactionRequest> input, Context context) {
        return super.runActivity(
            () -> input.fromPath(path ->
                    GetAllTransactionRequest.builder()
                                .build()),
            (request, serviceComponent) ->
                        serviceComponent.provideGetAllTransactionActivity().handleRequest(request)
        );
    }
}


