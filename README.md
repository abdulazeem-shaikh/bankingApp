# bankingApp

This Repo contain the API for uer dashboard to display the user profile and Transaction detail.


1-GET : http://localhost:8080/api/v1/service/customer?customerId=1234512
Response
{
    "customerId": "1234512",
    "name": "abdul",
    "availableBalance": 1223344.0,
    "lastVisitedAt": "2017-07-14T02:40:00.000+0000",
    "address": "bbbb"
}

2-GET http://localhost:8080/api/v1/service/transaction?customerId=12345
Response
{
    "customerId": "12345",
    "lastVisited": "10-01-1989 T10:12:18",
    "transaction": [
        {
            "transactionType": "withDraw",
            "closingBalance": 12242342343
        },
        {
            "transactionType": "deposit",
            "closingBalance": 1224234234324
        },
        {
            "transactionType": "pin generatin",
            "closingBalance": 122423423432
        }
    ]
}

=========

other API 
create customer
create transaction

POST http://localhost:8080/api/v1/service/customer?customerId=1234512
PUT http://localhost:8080/api/v1/service/customer?customerId=1234512
DELETE http://localhost:8080/api/v1/service/customer?customerId=1234512

sample transaction insertion
POST http://localhost:8080/api/v1/service/transaction
{
    "customerId": "12345",
    "lastVisited": "10-01-1989 T10:12:18",
    "transaction": [
        {
            "transactionType": "withDraw",
            "closingBalance": 12242342343
        },
        {
            "transactionType": "deposit",
            "closingBalance": 1224234234324
        },
        {
            "transactionType": "pin generatin",
            "closingBalance": 122423423432
        }
    ]
}


