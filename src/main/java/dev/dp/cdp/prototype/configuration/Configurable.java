package dev.dp.cdp.prototype.configuration;


// USE GENERIC SO THAT RETURN TYPE WILL BE ALWAYS DEPNDS OM CLASS WHICHIS IMPLEMETING IT
public interface Configurable<T> {
    T cloneObject();
}
