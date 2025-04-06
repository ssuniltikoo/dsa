## You are building a  <ins>task  management application</ins>  where <ins>users</ins> can create <ins>tasks</ins> and assign them to different <ins>team members</ins>. To enhance the user experience, Joe, a developer on your team, wants to implement a feature where team members receive notifications whenever they are assigned a new task. These notifications should be sent through various communication channels, such as <ins>in-app alerts, emails, and Slack messages</ins>. Joe believes that implementing the Observer pattern will provide a flexible and maintainable solution for this requirement.

Assignment
## Your assignment is to implement the Observer pattern to create a flexible notification system for the task management application. The TaskManager class handles task assignments, and various observer classes (e.g., AlertService, EmailService, SlackService) need to be notified when a new task is assigned to a team member.

Implementing the Observer Pattern
## Understand the original class: Take a closer look at the TaskManager class and its interactions with the task database and notification services. Understand how tasks are assigned and notifications are sent.

## Implement the observer interface: Implement the interface named Observer with a method that accepts the task and the team member as arguments. Observer classes (such as AlertService, EmailService, SlackService) will implement this interface to receive notifications.

## Implement the publisher interface: You have been provided with a Publisher abstract class. Your task is to implement the methods required by this interface in the TaskManager class. The Publisher interface defines methods that allow observers to subscribe and unsubscribe.

## Modify the observers: Refactor the observer classes to implement the Observer interface. Update their existing methods to match the new interface method signature.

## Modify the publisher: Refactor the TaskManager class as required. Implement the publisher methods to manage observer subscriptions and notify observers when a task is assigned.

## Test your implementation: Run the provided test cases in the TaskManagerTest class to ensure that your observer pattern implementation is correct. These test cases will check if observers are being notified correctly and if the TaskManager behaves as expected.