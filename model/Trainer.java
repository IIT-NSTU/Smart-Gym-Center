package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Trainer Class that contains all the
 * characteristics or properties that a Trainer Must Have
 */
public class Trainer {
    private String ID;
    private String name;
    private String phoneNumber;
    private List<User> userList;

    /**
     * Constructor OverLoading used by Black Constructor
     */
    public Trainer() {}

    /**
     * Constructor OverLoading used by Parameterised Constructor
     */
    public Trainer (String ID, String name, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        userList = new ArrayList<>();
    }

    public String toString() {
        return ID+" "+name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
