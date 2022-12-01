import CurrencyClient from '../api/currencyClient';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view playlist page of the website.
 */
class ViewTransaction extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'showEndAmount'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.addRateToPage);

    }

    /**
     * Once the client is loaded, get the playlist metadata and song list.
     */
    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        this.client = new CurrencyClient();
        this.clientLoaded();
    }

    async showEndAmount() {
        const transaction = this.datastore.get('transaction');

        if(transaction == null) {
            return;
        }

        console.log("transaction" + transaction);
        const transactionRecieved = await this.client.getTransaction(transaction);
        console.log("transactionRecieved " + JSON.stringify(transactionRecieved));

        let endAmountHtml = ' ';
        endAmountHtml += '<p>Amount Converted: ' + transactionRecieved.endAmount + '</p>';

        document.getElementById('amountConvertedBox').innerHTML = endAmountHtml;
    }

}

const main = async () => {
    const viewTransaction = new ViewTransaction();
    viewTransaction.mount();
};

window.addEventListener('DOMContentLoaded', main);
