package dev.dp.cdp.prototype.configuration;

import java.util.HashMap;
import java.util.Map;

public class ProtoTypeRegistry implements ConfigurationPrototypeRegistry{

    Map<ConfigurationType,Configuration> configurations = new HashMap<>();

    @Override
    public void addPrototype(Configuration user) {
        configurations.put(user.getType(),user);
    }

    @Override
    public Configuration get(ConfigurationType type) {
        return configurations.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
       Configuration config =configurations.get(type);
      // config.cloneObject();
       return config.cloneObject();
    }
}
