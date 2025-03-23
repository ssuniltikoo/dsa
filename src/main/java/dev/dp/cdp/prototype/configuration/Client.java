package dev.dp.cdp.prototype.configuration;

import javax.swing.plaf.IconUIResource;

public class Client {
    public static void main(String[] args) {
        Configuration configuration = new Configuration("whilte",true,
                "english",true,10,"BASIC",ConfigurationType.CUSTOM);
        Configuration newconf = configuration.cloneObject();
        newconf.setConfigId(100);
        newconf.setConfigName("newConfi");
        System.out.println(newconf);
        System.out.println(configuration);

        ProtoTypeRegistry protoTypeRegistry = new ProtoTypeRegistry();
        protoTypeRegistry.addPrototype(configuration);
        protoTypeRegistry.addPrototype(newconf);
        Configuration myConfig  =configuration.cloneObject();
        myConfig.setConfigId(222);
        protoTypeRegistry.addPrototype(configuration);
        System.out.println(protoTypeRegistry.get(ConfigurationType.CUSTOM));
        System.out.println(protoTypeRegistry.clone(ConfigurationType.CUSTOM));

    }
}
