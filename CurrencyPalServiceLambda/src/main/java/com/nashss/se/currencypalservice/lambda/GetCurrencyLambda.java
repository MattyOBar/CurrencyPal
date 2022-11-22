package com.nashss.se.currencypalservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.currencypalservice.activity.requests.GetCurrencyRequest;
import com.nashss.se.currencypalservice.activity.results.GetCurrencyResult;

public class GetCurrencyLambda
        extends LambdaActivityRunner<GetCurrencyRequest, GetCurrencyResult>
        implements RequestHandler<LambdaRequest<GetCurrencyRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetCurrencyRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetCurrencyRequest.builder()
                                .withCurrencyAbrv(path.get("currencyAbrv"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetCurrencyActivity().handleRequest(request)
        );
    }
}