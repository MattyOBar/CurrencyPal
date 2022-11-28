package com.nashss.se.currencypalservice.lambda;

import com.nashss.se.currencypalservice.activity.requests.GetAllCurrencyRequest;
import com.nashss.se.currencypalservice.activity.results.GetAllCurrencyResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;



public class GetAllCurrencyLambda
        extends LambdaActivityRunner<GetAllCurrencyRequest, GetAllCurrencyResult>
        implements RequestHandler<LambdaRequest<GetAllCurrencyRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllCurrencyRequest> input, Context context) {
        return super.runActivity(
            () -> input.fromPath(path ->
                    GetAllCurrencyRequest.builder()
                            .build()),
            (request, serviceComponent) ->
                    serviceComponent.provideGetAllCurrencyActivity().handleRequest(request)
        );
    }
}
