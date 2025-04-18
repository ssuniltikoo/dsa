## Prototype Pattern for Object Cloning in Testing
## Problem Statement
## You are developing a testing framework for a user API of a social media platform. Each test case requires generating multiple mock users with different attributes to simulate various scenarios. However, creating mock users for testing involves complex setups and is time-consuming. To optimize the user creation process during testing, you decide to implement the Prototype pattern. This pattern allows you to create prototype objects and clone them when needed, avoiding the overhead of setting up complex user objects repeatedly.

## Assignment
### Your task is to implement the Prototype pattern to create prototype objects for mock users in the testing framework. You should define an ObjectClonable interface that contains the clone method, which should be implemented by user objects. Additionally, you need to create a UserPrototypeRegistry interface that provides methods for adding and retrieving user prototypes and for cloning user objects. The goal is to streamline the process of creating mock users for testing.

## Implementing the Prototype Pattern
### Define the ObjectClonable interface: Create an interface named ObjectClonable with a single method, clone(), that returns a cloned copy of the implementing object.

### Implement the user object: Implement the User class with attributes like userId, username, email, displayName, and age. Ensure that the User class implements the ObjectClonable interface by providing a proper clone method that creates a deep copy of the user object.

### Define the UserPrototypeRegistry interface: Create an interface named UserPrototypeRegistry that includes methods for adding prototypes, retrieving prototypes by type, and cloning user objects.

### Create the registry implementation: Implement a class that adheres to the UserPrototypeRegistry interface. In this class, manage a collection of user prototypes and provide methods to add prototypes, retrieve prototypes by type, and clone user objects based on their type.

### Test your implementation: Write test cases to ensure that the User class correctly implements the ObjectClonable interface, and the registry class properly manages prototypes and performs cloning operations. Verify that cloning a user object results in a new object with the same attribute values but is not the same object in memory.