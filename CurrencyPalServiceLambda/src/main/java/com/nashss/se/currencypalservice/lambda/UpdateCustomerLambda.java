package com.nashss.se.currencypalservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.currencypalservice.activity.requests.UpdateCustomerRequest;
import com.nashss.se.currencypalservice.activity.results.UpdateCustomerResult;

public class UpdateCustomerLambda
        extends LambdaActivityRunner<UpdateCustomerRequest, UpdateCustomerResult>
        implements RequestHandler<LambdaRequest<UpdateCustomerRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(LambdaRequest<UpdateCustomerRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(UpdateCustomerRequest.class),
                (request, serviceComponent) ->
                        serviceComponent.provideUpdateCustomerActivity().handleRequest(request)
        );
    }
}