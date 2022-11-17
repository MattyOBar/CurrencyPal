package com.nashss.se.currencypalservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.currencypalservice.activity.requests.CreateCustomerRequest;
import com.nashss.se.currencypalservice.activity.results.CreateCustomerResult;

public class CreateCustomerLambda
        extends LambdaActivityRunner<CreateCustomerRequest, CreateCustomerResult>
        implements RequestHandler<LambdaRequest<CreateCustomerRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateCustomerRequest> input, Context context) {
        return super.runActivity(
            () -> input.fromBody(CreateCustomerRequest.class),
            (request, serviceComponent) ->
            serviceComponent.provideCreatePlaylistActivity().handleRequest(request)
        );
    }
}