package dev.dp.cdp.prototype.mockObject;

import java.util.Objects;
import java.util.UUID;

class User  implements ObjectClonable{
    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;
    private String username;
    private String  email;
    private String displayName;
    private int  age;
    private UserType usertype;

    public User( String username, String email, String displayName, UserType type) {
        this.userId = UUID.randomUUID().hashCode();
        this.age = (int)(Math.random() * (99-18)+(18));
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.usertype = type;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public User clone() {
        return new User(this.username, this.email, this.displayName,this.usertype);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return user.usertype == usertype  && userId == user.userId && age == user.age && username.equals(user.username) && Objects.equals(email, user.email) && Objects.equals(displayName, user.displayName);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + username.hashCode();
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(displayName);
        result = 31 * result + age;
        result = 31 * result + usertype.hashCode();
        return result;
    }
}
