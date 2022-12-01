package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.TransactionModel;

public class CreateTransactionResult {
    private final TransactionModel transactionModel;

    private CreateTransactionResult(TransactionModel transactionModel) {
        this.transactionModel = transactionModel;
    }

    public TransactionModel getTransactionModel() {
        return transactionModel;
    }

    @Override
    public String toString() {
        return "CreateTransactionResult{" +
                "transactionModel=" + transactionModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TransactionModel transactionModel;

        public Builder withTransactionModel(TransactionModel transactionModel) {
            this.transactionModel = transactionModel;
            return this;
        }

        public CreateTransactionResult build() {
            return new CreateTransactionResult(transactionModel);
        }


    }
}
