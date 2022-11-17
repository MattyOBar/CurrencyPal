import axios from "axios";
import BindingClass from "../util/bindingClass";

/**
 * Client to call the MusicPlaylistService.
 *
 * This could be a great place to explore Mixins. Currently the client is being loaded multiple times on each page,
 * which we could avoid using inheritance or Mixins.
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes#Mix-ins
 * https://javascript.info/mixins
  */
export default class currencyClient extends BindingClass {

    constructor(props = {}){
        super();
        const methodsToBind = ['clientLoaded', 'getIdentity', 'updateAllCurrency', 'getCurrency', 'getTransaction', 'createTransaction', 'updateTransaction', 'getCustomer', 'createCustomer', 'updateCustomer'];
        this.bindClassMethods(methodsToBind, this);
        this.props = props;

        axios.defaults.baseURL = INVOKE_URL;
        this.client = axios;
        this.clientLoaded(this.client);
    }

    /**
     * Run any functions that are supposed to be called once the client has loaded successfully.
     * @param client The client that has been successfully loaded.
     */
    clientLoaded(client) {
        if (this.props.hasOwnProperty("onReady")){
            this.props.onReady();
        }
    }

    /**
     * Get the identity of the current user
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The username and phonetool url for the current user.
     */
    async getIdentity(errorCallback) {
        try {
            // TODO auth?
            //const response = await this.client.get(`identity`);
            const data = {'username': 'Nashville Software'};
            //return response.data;
            return data;
        } catch(error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
     * Gets the currency for the given currencyType Abbrv.
     * @param currencyType given a currencyType
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The currency's metadata.
     */
    async getCurrency(currencyType, errorCallback) {
        try {
            const response = await this.client.get(`currency/${currencyType}`);
            return response.data.currency;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }
   //call to api needs work
    async updateAllCurrency(errorCallback) {
        try {
            const response = await this.client.put(`currency`, {
                currentRate: currentRate,
                ranking: ranking,
            });
            return response.data.currency;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }
    /**
     * Gets the transaction for the given transaction ID.
     * @param transactionId given a unique transactionID
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The transaction's metadata.
     *
     **/
    async getTransaction(transactionId, errorCallback) {
        try {
            const response = await this.client.get(`transaction/${transactionId}`);
            return response.data.transaction;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

     /**
         * Create a new transaction.
         * @param currency The currency of the transaction to create.
         * @param customerId The user who is the owner of the transaction.
         * @param amountToConvert amount to convert.
         * @param amountConverted amount after convert.
         * @param conversionRate rate for the currency chosen.
         * @param isShown keeps track of transactions shown on front end.
         * @param errorCallback (Optional) A function to execute if the call fails.
         * @returns The transaction that has been created.
         */
    async createTransaction(currency, customerId, amountToConvert, amountConverted, conversionRate, isShown, transactionDateTime , errorCallback) {
        try {
            const response = await this.client.post(`transaction`, {
                currency: currency,
                customerId: customerId,
                amountToConvert: amountToConvert,
                amountConverted: amountConverted,
                conversionRate: conversionRate,
                isShown: isShown,
                transactionDateTime: transactionDateTime,
            });
            return response.data.transaction;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
         * update the transactions is shown for viewing purposes
         * @param errorCallback (Optional) A function to execute if the call fails.
         * @returns The list of songs on a playlist.
         */
    async updateTransaction(errorCallback) {
        try {
            const response = await this.client.put(`transaction/${transactionId}`, {
                isShown: isShown,
            });
            return response.data.transaction;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }
    /**
     * Get the customer to show their information
     * @param customerId Unique identifier for a customer
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The list of songs on a playlist.
     */
    async getCustomer(customerId, errorCallback) {
        try {
            const response = await this.client.get(`customer/${customerId}`);
            return response.data.customer;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async createCustomer(name, dob, balance, errorCallback) {
        try {
            const response = await this.client.post(`customer`, {
                name: name,
                dob: dob,
                balance: balance,
            });
            return response.data.customer;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }
     /**
     * update the customer balance
     * @param balance current balance will be updated
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns customer data
     */
    async updateCustomer(errorCallback) {
        try {
            const response = await this.client.put(`customer/${customerId}`, {
                balance: balance,
            });
            return response.data.customer;
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    /**
     * Helper method to log the error and run any error functions.
     * @param error The error received from the server.
     * @param errorCallback (Optional) A function to execute if the call fails.
     */
    handleError(error, errorCallback) {
        console.error(error);
        if (error.response.data.message !== undefined) {
            console.error(error.response.data.message)
        }
        if (errorCallback) {
            errorCallback(error);
        }
    }
}
