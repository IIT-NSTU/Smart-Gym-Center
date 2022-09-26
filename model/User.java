package model;

/**
 * This is User Class that contains all the characteristics or properties that a User means Customer Must Have
 */
public class User {
    private String trainID;
    private String ID;
    private String name;
    private String phoneNumber;
    private String trainerID;
    private String session;
    private String time;
    private boolean completed;
    private int amount;
    private boolean collected;
    private String feedback;

    /**
     * Constructor OverLoading used by Black Constructor
     */
    public User () {}

    /**
     * Constructor OverLoading used by Parameterised Constructor
     *
     * @param trainID TrainID of Customer
     * @param ID ID of Customer
     * @param name Name of Customer
     * @param phoneNumber PhoneNumber of Customer
     * @param trainerID TrainerID fo Specific Trainer
     * @param session Session Name
     * @param time Time Period
     * @param completed Boolean Value Session Completed or not
     * @param amount Amount of Payment that Customer Paid
     * @param collected Boolean Value Amount Collected By Trainer or not
     * @param feedback FeedBack From Trainer
     */
    public User (String trainID,String ID, String name, String phoneNumber, String trainerID, String session, String time, boolean completed, int amount,boolean collected,String feedback) {
        this.trainID = trainID;
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.trainerID = trainerID;
        this.session = session;
        this.time = time;
        this.completed = completed;
        this.amount = amount;
        this.collected = collected;
        this.feedback = feedback;
    }

    public String toString() {
        return trainID+" "+ID+" "+name+" "+phoneNumber+" "+trainerID+" "+session+" "+time+" "+isCompleted()+" "+amount+" "+isCollected()+" "+feedback;
    }

    public String getTrainID() {
        return trainID;
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

    public String getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSession() {
        return session;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isCollected() {
        return collected;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getTime() {
        return time;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
