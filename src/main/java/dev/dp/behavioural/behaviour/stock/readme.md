Problem Statement
## You are developing a stock trading platform where users need to be notified whenever the price of a particular stock crosses a certain threshold. These notifications should be sent through various channels such as email, SMS, and mobile app notifications. To achieve this, you want to implement the Observer pattern, allowing users to subscribe to stock price updates and receive notifications through multiple channels.

Assignment
## Your task is to implement the Observer pattern to create a flexible notification system for the stock trading platform. The StockTradingManager class handles stock price updates, and various observer classes (e.g., EmailService, SmsService, AppService) need to be notified when the stock price crosses the threshold.

Implementing the Observer Pattern
## Review the original class: Study the StockTradingManager class and its dependencies. Understand how it currently handles stock price updates and notifications.

## Implement the publisher interface: You have been provided with a Publisher interface. Your task is to implement the methods required by this interface in the StockTradingManager class. Remember that the Publisher interface is a contract that defines the methods that a class can use to notify observers.

## Implement the observer interface: Design an interface named Observer with a method that accepts the stock name and current price as arguments. Observer classes (such as EmailService, SmsService, AppService) will implement this interface to receive notifications.

## Modify the publisher: Refactor the StockTradingManager class as required. Do not modify the constructor as it used by the tests.

## Modify the observers: Refactor the observer classes to implement the Observer interface. Update their existing methods to match the new interface method signature.

Test your implementation: Run the provided test cases in the StockTradingManagerTest class to ensure that your observer pattern implementation is correct. These test cases will check if observers are being notified correctly and if the StockTradingManager behaves as expected.