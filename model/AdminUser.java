package model;

/**
 * This Class Contains All the Characteristics or Properties that a Manager or Trainer Must Have
 */
public class AdminUser {
    private String ID;
    private String userName;
    private String password;
    private String name;
    private String phoneNumber;
    private String role;

    public AdminUser (String ID, String userName, String password,
                      String name, String phoneNumber, String role) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }
}
