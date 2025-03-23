package dev.dp.cdp.prototype.mockObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register implements  UserPrototypeRegistry{

   final  Map<UserType, List<User>> mapOfUsers = new HashMap<>();

   final Map<UserType, User> userMap = new HashMap<>();

   final List<User> listOfUser = new ArrayList<>();

    @Override
    public void addUser(User user) {
        userMap.put(user.getUsertype(),user);
        listOfUser.add(user);
        mapOfUsers.put(user.getUsertype(),listOfUser);
    }

    @Override
    public List getListOfUserType(UserType type) {
        return mapOfUsers.get(type);
    }

    @Override
    public User clone(UserType type) {
            User user = userMap.get(type);
            return user.clone();
    }


}
