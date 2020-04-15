About
------------

The software was developed to test the competency on Java, Spring Boot & JPA. The software uses the following dependecies to run:

1) Maven
2) Spring Boot
3) Spring Data JPA
4) Spring Web Kit
5) H2 in-memory database
6) Java 8

Key Points:
------------

The software serves a single API which allows the users to place orders. The API accepts the productIds and the userId to work.

Please note that all data is put at the software start-up using spring boot. 

The software has been developed in the spirit of keeping it relevant even when the discounts are added, modified or deleted. The software is meant to be a foundation for the changing requirements, but please except to make the required changes as you modify your store discount policies such as add more:

1) Loyalty discounts
2) Discounts applicable on the entire bills


Assumptions and Behavior:
------------------------

1) All discounts except for the discounts for affiliates, employees are done at the overall amount.

2) It's assumed that the user may have more than one relationship with the store. They can be affiliate, customer, employee, some of these or all of these.

3) The max. discount available to the user in the context of customer loyalty, affiliate association and employee association is applied on all non-grocery items.

4) The final discount ($5 per $100) is applicable on the actual bill amount and not the discount amount as calculated in step 3 above.

5) The API interface is simple enough to only receive the product ids and not the full products. You can provide the product ids and the user id to make a request.

6) You may look at the test data in src/main/resources/data.sql file

How to run it:
--------------

Please pick up the .jar file from target run it via command line. 

cmd>java -jar retailstore-0.0.1-RELEASE.jar

Once application is up and running, you can use browser to place an order.

You will get a response of the bill which will have the following details:

1) Customer Id
2) Customer Name
3) Total Amount
4) Percentage Discount
5) Additional Discount
6) Final Payable

Sample Request:
---------------

Go into the browser and put http://localhost:8080/placeOrder/1,5/1 in the URL. Here 1,5 are two product ids separated by a comma. The /1 aftetr product ids is the user id.

Sample  Response:
-----------------
{
   "customerId":1,
   "customerName":"abbas",
   "totalBill":6050.0,
   "associationDiscount":1815000.0,
   "billDiscount":300.0,
   "totalDiscount":1815300.0,
   "finalBill":-1809250.0
}