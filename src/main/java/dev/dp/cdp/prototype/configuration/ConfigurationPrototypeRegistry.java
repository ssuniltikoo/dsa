package dev.dp.cdp.prototype.configuration;

public interface ConfigurationPrototypeRegistry {
    void addPrototype(Configuration user);
    Configuration get(ConfigurationType type);
    Configuration clone(ConfigurationType type);

}
