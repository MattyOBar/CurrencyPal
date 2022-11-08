# Design Document

## Instructions

## CurrencyPal

## 1. Problem Statement

Our company needs a tool to be able to quickly send or recieve various currencies.

## 2. Top Questions to Resolve in Review

1. extra features?
2. how are we going to structure our database?
3. 

## 3. Use Cases

U1. As a CurrencyPal customer I want to `quickly and effieciently find exchange rates` when I `know the set amount I would like to exchange`

U2. As a CurrencyPal customer, I want to view all transaction history

U3. As a CurrencyPal customer, I want to view the history of each currency to predict trends

U4. As a CurrencyPal customer,  want to look up transaction history by name/customerID.

U5. As a CurrencyPal customer, I want to be able to create a transaction, where I convert my money from one currency to another.

U6. As a CurrencyPal customer, I want to be able to send other users money in whatever currency I choose to convert it too.

U7. As a CurrencyPal customer, customer, I want to view the transaction history by currency.

U8. As a CurrencyPal customer,  I want to send myself an alert when currencies reach a certain rate.

## 4. Project Scope


### 4.1. In Scope

Getting the most current currency exchange rates
View the history of a currency's exchange rate
Be able to exchange currency and update personal balance
View transaction history by currency
View transaction history by user
View all transaction history

### 4.2. Out of Scope

The ability to send and request money
The ability to let users create individual accounts
The ability to send alerts to users

# 5. Proposed Architecture Overview
This initial iteration will provide the minimum lovable product (MLP) including the ability to view currency exchange rates, execute exchanges, and viewing transaction history through various filters.

We will use API Gateway and Lambda to create *INSERT NUMBER HERE* endpoints (*INSERT ENDPOINTS HERE*) that will handle the creation, updating and retrieval of our transactions and exchange rates.

We will retrieve the initial exchange rates from [freecurrencyapi](https://freecurrencyapi.com/) and store those in a table in DynamoDB.  We will then reference that table whenever we do our conversions.  We will have a button on our website for our users to use to update the rates to their most current state.  The button will use our DynamoDB table if it has been less then 12 hours otherwise it will use our API endpoints to update the exchange rates (Updating to an automated scheduler is currently out of scope).

We will be using tables in DynamoDB to store all of our transaction history and our customer data.

[See PlantUML](currencyConverterCD.puml) for more details.


# 6. API

## 6.1. Public Models

_Define the data models your service will expose in its responses via your *`-Model`* package. These will be equivalent to the *`PlaylistModel`* and *`SongModel`* from the Unit 3 project._

None necessary

## 6.2. _First Endpoint_

_Describe the behavior of the first endpoint you will build into your service API. This should include what data it requires, what data it returns, and how it will handle any known failure cases. You should also include a sequence diagram showing how a user interaction goes from user to website to service to database, and back. This first endpoint can serve as a template for subsequent endpoints. (If there is a significant difference on a subsequent endpoint, review that with your team before building it!)_

_(You should have a separate section for each of the endpoints you are expecting to build...)_

We don't require anything, we are using https://api.freecurrencyapi.com/v1/latest to populate our database of currencies and respective excahnge rates.


## 6.3 _Second Endpoint_

_(repeat, but you can use shorthand here, indicating what is different, likely primarily the data in/out and error conditions. If the sequence diagram is nearly identical, you can say in a few words how it is the same/different from the first endpoint)_

As a stretch goal we are using this API https://freecurrencyapi.com/docs/historical to graph trends among currencies.


# 7. Tables

Currencies, 
Customers, 
Transactions

# 8. Pages

See figma link for mock ups
https://www.figma.com/file/afDeHOTDS6MTtBdTeWLQIT/Untitled?node-id=1%3A13
