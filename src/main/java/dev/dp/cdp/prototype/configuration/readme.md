# Prototype Pattern for Configuration Object Cloning
### Problem Statement
### You are developing a configuration management system for your application. This system allows users to define and manage various configurations with different attributes. Creating new configurations with specific attributes is a frequent task during testing and development. However, setting up these configurations manually can be time-consuming and error-prone. To streamline this process, you decide to implement the Prototype pattern. This pattern will enable you to create prototype configuration objects and clone them when needed, saving time and reducing the risk of errors.

Assignment
## Your task is to implement the Prototype pattern to create prototype objects for configuration management. You should define a Configurable interface that contains the clone method, which should be implemented by configuration objects. Additionally, you need to create a ConfigurationPrototypeRegistry interface that provides methods for adding and retrieving configuration prototypes and for cloning configuration objects. The goal is to simplify the process of creating configurations with specific attributes.

Implementing the Prototype Pattern
### Define the Configurable interface: Create an interface named Configurable with a single method, clone(), that returns a cloned copy of the implementing object.

### Implement the configuration object: Implement the Configuration class with attributes such as configId, configName, configValue, isEnabled, and type. Ensure that the Configuration class implements the Configurable interface by providing a proper clone method that creates a deep copy of the configuration object.

Define the ConfigurationPrototypeRegistry interface: Create an interface named ConfigurationPrototypeRegistry that includes methods for adding prototypes, retrieving prototypes by type, and cloning configuration objects.

Create the registry implementation: Implement a class that adheres to the ConfigurationPrototypeRegistry interface. In this class, manage a collection of configuration prototypes and provide methods to add prototypes, retrieve prototypes by type, and clone configuration objects based on their type.

Test your implementation: Write test cases to ensure that the Configuration class correctly implements the Configurable interface, and the registry class properly manages prototypes and performs cloning operations. Verify that cloning a configuration object results in a new object with the same attribute values but is not the same object in memory.