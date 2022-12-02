package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.TransactionModel;

import java.util.List;

public class GetAllTransactionResult {
    private final List<TransactionModel> transactionModelList;

    private GetAllTransactionResult(List<TransactionModel> transactionModelList) {
        this.transactionModelList = transactionModelList;
    }

    public List<TransactionModel> getTransactionModelSet() {
        return transactionModelList;
    }


    //CHECKSTYLE:OFF:Builder
    public static GetAllTransactionResult.Builder builder() {
        return new GetAllTransactionResult.Builder();
    }

    public static class Builder {
        private List<TransactionModel> transactionModelList;

        public Builder withTransaction(List<TransactionModel> transactionModelList) {
            this.transactionModelList = transactionModelList;
            return this;
        }

        public GetAllTransactionResult build() {
            return new GetAllTransactionResult(transactionModelList);
        }
    }

}
