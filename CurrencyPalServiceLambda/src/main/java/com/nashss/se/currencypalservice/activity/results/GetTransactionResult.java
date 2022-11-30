package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.TransactionModel;

public class GetTransactionResult {
    private final TransactionModel transactionModel;

    private GetTransactionResult(TransactionModel transactionModel) {
        this.transactionModel = transactionModel;
    }

    public TransactionModel getTransactionModel() {
        return transactionModel;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TransactionModel transactionModel;

        public Builder withTransaction(TransactionModel transactionModel) {
            this.transactionModel = transactionModel;
            return this;
        }

        public GetTransactionResult build() {
            return new GetTransactionResult(transactionModel);
        }
    }
}
