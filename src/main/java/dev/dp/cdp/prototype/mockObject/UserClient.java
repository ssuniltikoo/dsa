package dev.dp.cdp.prototype.mockObject;

import dev.dp.cdp.factory.flutterfactory.Client;

public class UserClient {
    private static final   Register register = new Register();
    public static void main(String[] args) {


        createMockusers();

        User adminUser = register.clone(UserType.ADMIN);
        adminUser.setUserId(-1);

        User write = register.clone(UserType.WRITER);
        write.setUserId(-100);

        System.out.println("test");

    }

    private static void createMockusers() {
        User admin = new User("Admin","mockuserAdmin@test.com","MOCK_USER_ADMIN",UserType.ADMIN);
        User userAdmin1 = admin.clone();
        User userAdmin2 = admin.clone();
        User userAdmin3 = admin.clone();
        register.addUser(admin);
        register.addUser(userAdmin1);
        register.addUser(userAdmin2);
        register.addUser(userAdmin3);
        User reader = new User("READER","mockuserreader@test.com","MOCK_USER_READER",UserType.READER);
        User userReader1 = reader.clone();
        User userReader2 = reader.clone();
        User userReader3 = reader.clone();

        register.addUser(userReader1);
        register.addUser(userReader2);
        register.addUser(userReader3);



        User writer = new User("Writer","mockuserwriter@test.com","MOCK_USER_WRITER",UserType.WRITER);
        User userWriter1 = writer.clone();
        User userWriter2 = writer.clone();
        User userWriter3 = writer.clone();
        register.addUser(userWriter1);
        register.addUser(userWriter2);
        register.addUser(userWriter3);

    }
}
