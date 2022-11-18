package com.nashss.se.currencypalservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.currencypalservice.activity.requests.GetCustomerRequest;
import com.nashss.se.currencypalservice.activity.results.GetCustomerResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GetCustomerLambda
    extends LambdaActivityRunner<GetCustomerRequest, GetCustomerResult>
        implements RequestHandler<LambdaRequest<GetCustomerRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetCustomerRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetCustomerRequest.builder()
                                //may need to change
                                .withId(path.get("id"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetCustomerActivity().handleRequest(request)
        );
    }
}
