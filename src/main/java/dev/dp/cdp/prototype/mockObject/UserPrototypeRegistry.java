package dev.dp.cdp.prototype.mockObject;

import java.util.List;

public interface UserPrototypeRegistry<U> {
    void addUser(User user);
    List<U> getListOfUserType(UserType type);
    U clone(UserType type);



}
