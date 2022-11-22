import CurrencyClient from '../api/currencyClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view playlist page of the website.
 */
class ViewPlaylist extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'addRateToPage'])
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.addRateToPage);
        this.header = new Header(this.dataStore);
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
        this.header.addHeaderToPage();
        this.header.loadData();
        this.client = new currencyClient();
        this.clientLoaded();
    }

    addRateToPage() {
        const currencies = this.dataStore.get('currency');
        if(currency = null) {
            return;
        }
        document.getElementById('currency-usd').innerText = currency.currencyAbrv;

        let rateHtml = '';
        let rate;

        rateHtml+= '<p>' + rate + '</p>';
        document.getElementById('display-rate').innerHTML = rateHtml;

        }
}

const main = async () => {
    const viewCurrency = new ViewCurrency();
    viewCurrency.mount();
};

window.addEventListener('DOMContentLoaded', main);
