package model;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is the Model CLass of this Project. It Contains ALl the BackEnd programs or Methods that makes the project Alve.
 */
public class GymCenterModel {

    /**
     *  List of Admin Users of CLass type AdminUser means Manager or Train
     */
    private List<AdminUser> adminUserList;
    /**
     *  List of Users of CLass type User means Customers
     */
    private List<User> userList;
    /**
     *  List of Trainers of CLass type Trainer
     */
    private List<Trainer> trainerList;
    /**
     *  List of Sessions of CLass type String
     */
    private List<String> sessionList;

    /**
     * GymCentreManagementSystemModel Constructor sets AdminUserList,TrainerList and SessionList
     */
    public GymCenterModel() {
        setAdminUserList();
        setTrainerList();
        setSessionList();
    }

    /**
     *
     * This Method Sets All Admin User Registration Data to File and
     * Checks the data is valid or not. After Registration According to role Manager Page or Trainer
     * Page Opens.
     *
     * @param userName UserName of Manager/Trainer
     * @param password Password of Manager/Trainer
     * @param name ame of Manager/Trainer
     * @param phoneNumber Phone Number of Manager/Trainer
     * @param role Admin User Role Manager or Trainer
     * @return Boolean value true or False that successfully added to file or not
     */
    public boolean writeAdminRegistrationData(String userName, String password,
                                      String name, String phoneNumber, String role) {

        if(userName.equals("") || password.equals("") || name.equals("") || phoneNumber.equals("") || role.equals("")) {
            JOptionPane.showMessageDialog(null,"Please Enter All Information");
            return false;
        } else if (adminAlreadyExists(userName,password,name,phoneNumber,role)) {
            JOptionPane.showMessageDialog(null,"These Data Already Exists");
            return false;
        } else {
            try {
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new FileWriter("AdminUserData.txt", true));

                String ID = role.charAt(0) +""+ getRandomNumber();
                bufferedWriter.append(ID + ","
                        + userName + "," + password + "," + name + ","
                        + phoneNumber + "," + role + "\n");
                bufferedWriter.close();

                if (role.equals("Trainer")) {
                    BufferedWriter bufferedWriterTrainer = new BufferedWriter(new FileWriter(ID+".txt",true));
                    bufferedWriterTrainer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /**
     * This method Sets the Admin User Means Manager or Trainer Data to adminUserList From AdminUserData.txt File
     */
    public void setAdminUserList() {
        adminUserList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("AdminUserData.txt"));
            String s;
            while((s=bufferedReader.readLine())!=null) {
                String[] inputArray = s.split(",");
                adminUserList.add(new AdminUser(inputArray[0],inputArray[1],inputArray[2],inputArray[3],inputArray[4],inputArray[5]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method Sets the User Means Customer Data to userList From Specific trainerID.txt File Because trainerID.txt File contains all Training Data
     * @param trainerID Specific TrainerID To get the Data
     */
    public void setUserListForSpecificTrainer(String trainerID) {
        userList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(trainerID+".txt"));
            String s;
            while((s=bufferedReader.readLine())!=null) {
                String[] inputArray = s.split(",");
                userList.add(new User(inputArray[0],inputArray[1],inputArray[2],inputArray[3],inputArray[4],
                        inputArray[5],inputArray[6],Boolean.parseBoolean(inputArray[7]),Integer.parseInt(inputArray[8]),
                        Boolean.parseBoolean(inputArray[9]),inputArray[10]));
            }
            bufferedReader.close();
        } catch (IOException e) {}
    }

    /**
     * This method Sets the Trainer Data to trainerList From AdminUserData.txt File
     */
    public void setTrainerList() {
        trainerList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("AdminUserData.txt"));
            String s;
            while((s=bufferedReader.readLine())!=null) {
                String[] inputArray = s.split(",");
                if (inputArray[5].equals("Trainer")) {
                    trainerList.add(new Trainer(inputArray[0],inputArray[3],inputArray[4]));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This Method Returns Random Number Between 10000000 and 20000000
     * @return random Number
     */
    public int getRandomNumber() {
        return (int) ((Math.random() * (20000000 - 10000000)) + 10000000);
    }

    /**
     * This Method Checks Admin Means Manager or Trainer Is Already in the adminUserList or Not
     *
     * @param userName UserName of Manager/Trainer
     * @param password Password of Manager/Trainer
     * @param name Name of Manager/Trainer
     * @param phoneNumber Phone Number of Manager/Trainer
     * @param role Admin User Role Manager or Trainer
     * @return Boolean Value True if Already Exists, false otherwise
     */
    public boolean adminAlreadyExists(String userName, String password,
                                 String name, String phoneNumber, String role) {
        setAdminUserList();
        for(AdminUser adminUser : adminUserList) {
            if (adminUser.getUserName().equals(userName)
                    && adminUser.getPassword().equals(password)
                    && adminUser.getName().equals(name)
                    && adminUser.getPhoneNumber().equals(phoneNumber)
                    && adminUser.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This Method Checks User Means Customer Is Already in the userList or Not
     *
     * @param name Name of Customer
     * @param phoneNumber PhoneNumber of Customer
     * @return Boolean Value True if Already Exists, false otherwise
     */
    public boolean userAlreadyExists(String name, String phoneNumber) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("UserData.txt"));
            String s;
            while ((s=bufferedReader.readLine())!=null) {
                String textString = s.substring(s.indexOf(",")+1);
                String inputSting = name+","+phoneNumber;
                if(textString.equals(inputSting)) {
                    return true;
                }
            }
            bufferedReader.close();
        }catch (IOException e) {}

        return false;
    }

    /**
     * This Method Checks Admin Means Manager or Trainer can Login or Not
     *
     * @param userName UserName of Manager/Trainer
     * @param password Password of Manager/Trainer
     * @param role Admin User Role Manager or Trainer
     * @return Boolean Value True Login Information Matches, false otherwise
     */
    public boolean canLogin(String userName, String password,String role) {
        if (userName.equals("") || password.equals("") || role.equals("")) {
            return false;
        } else if (userName.equals("admin") && password.equals("admin") && role.equals("Manager")) {
            return true;
        } else {
            for (AdminUser adminUser : adminUserList) {
                if (adminUser.getUserName().equals(userName)
                        && adminUser.getPassword().equals(password)
                        && adminUser.getRole().equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This Method Writes User means Customer data to File and also Validates data
     *
     * @param name Name of Customer
     * @param phoneNumber Phone Number of Customer
     * @return Boolean Value True if Successfully write to File, false otherwise
     */
    public boolean writeUserRegistrationData(String name, String phoneNumber) {

        if(name.equals("")  || phoneNumber.equals("")) {
            JOptionPane.showMessageDialog(null,"Please Enter All Information");
            return false;
        } else if (userAlreadyExists(name,phoneNumber)) {
            JOptionPane.showMessageDialog(null,"These Data Already Exists");
            return false;
        } else {
            try {
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new FileWriter("UserData.txt", true));
                bufferedWriter.append("U"+ getRandomNumber() + ","
                        + name  + "," + phoneNumber +"\n");
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /**
     * This Method returns trainerList as Object[] for the ComboBox Value
     * @return TrainerList as Object[]
     */
    public Object[] getTrainers() {
        setTrainerList();
        return trainerList.toArray();
    }

    /**
     * This Method returns All User Info(ID Name) as Object[] for the ComboBox Value
     * @return All User Info as Object[]
     */
    public Object[] getALLUsers() {
        List<String> userList = new ArrayList<>();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("UserData.txt"));
            String s;
            while ((s=bufferedReader.readLine())!=null) {
                String[] inputArray = s.split(",");
                userList.add(inputArray[0]+" "+inputArray[1]);
            }
            bufferedReader.close();
        }catch (IOException e) {e.printStackTrace();}
        return userList.toArray();
    }

    /**
     * This Method Sets All Session Booking Data to File and
     * Checks the data is valid or not.
     *
     * @param userID UserID of Customer
     * @param trainerID trainerID of trainer from him Customer is taking service
     * @param session Session of Customer
     * @param time Time Duration or Period of Customer
     * @param amount Amount of payment that Customer Paid
     * @return @return Boolean Value True if Successfully write to File, false otherwise
     */
    public boolean writeSessionBookingData(String userID,String trainerID,String session, String time,String amount) {

        if(userID.equals("")||trainerID.equals("")||session.equals("")||time.equals("")||amount.equals("")) {
            JOptionPane.showMessageDialog(null,"Please Enter All Information");
            return false;
        } else if (userWithTrainerSessionTimeAlreadyExists(userID,trainerID,session,time)) {
            JOptionPane.showMessageDialog(null,"User Booking Information Already Exists");
            return false;
        }else if(!isTrainerAvailable(trainerID,time)){
            JOptionPane.showMessageDialog(null,"Trainer is Not Available");
            return false;
        } else {
            try{
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(trainerID+".txt",true));
                bufferedWriter.append("H"+getRandomNumber()+","+getUserInfoByID(userID)+","+trainerID+","+session+","+time+","+false+","+amount+","+false+","+"feedback"+"\n");
                bufferedWriter.close();
            } catch (IOException e) {e.printStackTrace();}
        }
        return true;
    }

    /**
     * This Method Takes UserID and returns UserInfo as String
     * @param userID UserID of Customer
     * @return UserInfo as String
     */
    public String getUserInfoByID (String userID) {
        String userInfo = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("UserData.txt"));
            String s;
            while ((s=bufferedReader.readLine())!=null) {
               if(s.substring(0,9).equals(userID)) {
                   userInfo = s;
               }
            }
            bufferedReader.close();
        }catch (IOException e) {e.printStackTrace();}
        return userInfo;
    }

    /**
     * This Method Checks if Session Data of a Customer with a trainer is Already Exists or NOT
     *
     * @param userID UserID of Customer
     * @param trainerID trainerID of trainer from him Customer is taking service
     * @param session Session of Customer
     * @param time Time Duration or Period of Customer
     * @return Boolean value true if Data Already Exists, false otherwise
     */
    public boolean userWithTrainerSessionTimeAlreadyExists(String userID,String trainerID,String session, String time){
        setUserListForSpecificTrainer(trainerID);
        for (User user : userList) {
            if(user.getID().equals(userID)&&user.getTrainerID().equals(trainerID)&&user.getSession().equals(session)&&user.getTime().equals(time)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This Method Checks if Trainer is Available at a specific time period
     *
     * @param trainerID trainerID of trainer from him Customer is taking service
     * @param time Time Duration or Period of Customer
     * @return Boolean value true if Trainer is Availble, false otherwise
     */
    public boolean isTrainerAvailable(String trainerID, String time) {
        setUserListForSpecificTrainer(trainerID);
        for (User user : userList) {
            if(user.getTrainerID().equals(trainerID)&&user.getTime().equals(time)&&!user.isCompleted()) {
                return false;
            }
        }

        return true;
    }

    /**
     * This Method Takes trainerID and Returns TrainerName of type String
     *
     * @param trainerID TrainerID of Trainer
     * @return Trainer Name
     */
    public String getTrainerNameByID (String trainerID) {
        String name = "";
        setTrainerList();
        for (Trainer trainer : trainerList) {
            if(trainer.getID().equals(trainerID)) {
                name = trainer.getName();
            }
        }
        return name;
    }

    /**
     * This Method Takes trainerID and Returns Trainer of type Trainer
     * @param trainerID TrainerID of Trainer
     * @return trainer of Type Trainer
     */
    public Trainer getTrainerByID (String trainerID) {
        setTrainerList();
        Trainer targetTrainer = new Trainer();

        if (trainerID.equals("")) {
            return targetTrainer;
        }

        for (Trainer trainer : trainerList) {
            if(trainer.getID().equals(trainerID)) {
                targetTrainer = trainer;
                break;
            }
        }

        targetTrainer.setUserList(userList);

        return targetTrainer;
    }

    /**
     * This method returns HTML Contents for design purpose only of type String
     * @param trainerID TrainerID of Trainer
     * @return HTML Contest as String
     */
    public String getHTMLContentOFTrainer(String trainerID) {

        setUserListForSpecificTrainer(trainerID);
        Trainer trainer = getTrainerByID(trainerID);
        String htmlText = "";
        int serialNo = 0,amount=0,collectedPayment=0;

        htmlText = htmlText +
                "<table width=\"100%\">"
                +"<tr style=\"text-align:center;font-size:22px;font-weight:bold;font-family:arial;color:blue;\">APU GYM CENTER</tr>"
                +"</table>"
                +"<table width=\"100%\">"
                +"<tr style=\"text-align:center;font-size:13px;font-weight:bold;font-family:arial;\">Trainer Information</tr>"
                +"</table>";

        if (trainerID.equals("")) {
            return htmlText;
        }

        htmlText = htmlText
                +"<br>"
                +"<table width=\"100%\" style=\"font-size:14px\" >"
                +"<tr>"
                +"<td>"+"Trainer Name</td><td>:</td><td>"+trainer.getName()+"</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>Trainer ID</td><td>:</td><td>"+trainer.getID()+"</td>"
                +"</tr>"
                +"<tr>"
                +"<td>"+"</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>Date & Time</td><td>:</td><td>"+getDate()+"</td>"
                +"</tr>"
                +"<tr>"
                +"<td>"+"Trainer Phone Number</td><td>:</td><td>"+trainer.getPhoneNumber()+"</td>"
                + "</tr>"
                + "</table>"
                +"<br>"
                +"<table width=\"100%\" style=\"font-size:12px\" >"
                +"<tr>"
                +"<th style=\"text-align: left\">SL</th>" +
                "<th style=\"text-align: left\">User ID</th>" +
                "<th style=\"text-align: left\">User Name</th>" +
                "<th style=\"text-align: left\">User Phone Number</th>" +
                "<th style=\"text-align: left\">User Session</th>" +
                "<th style=\"text-align: left\">Time</th>" +
                "<th style=\"text-align: left\">Session Completed</th>" +
                "<th style=\"text-align: left\">Payment</th>" +
                "<th style=\"text-align: right\">Amount</th>" +
                "<th style=\"text-align: left\">FeedBack</th>"
                +"</tr>";

        for (User user : userList) {
            htmlText = htmlText
                    +"<tr>"
                    +"<td>"+(serialNo=serialNo+1)+"</td>" +
                    "<td>"+user.getID()+"</td>" +
                    "<td>"+user.getName()+"</td>" +
                    "<td>"+user.getPhoneNumber()+"</td>" +
                    "<td>"+user.getSession()+"</td>"+
                    "<td>"+user.getTime()+"</td>";

                    if(user.isCompleted()) {
                        htmlText = htmlText + "<td>"+"Yes"+"</td>";
                    } else {
                        htmlText = htmlText + "<td>"+"No"+"</td>";
                    }

            if(user.isCollected()) {
                htmlText = htmlText + "<td>"+"Collected"+"</td>";
                collectedPayment = collectedPayment + user.getAmount();
            } else {
                htmlText = htmlText + "<td>"+"Not Collected"+"</td>";
            }

            htmlText = htmlText
                    +"<td style=\"text-align:right\">"+user.getAmount()+"</td>";

            htmlText = htmlText
                    +"<td>"+user.getFeedback()+"</td>"
                    +"</tr>";

            amount = amount + user.getAmount();
        }

        htmlText = htmlText
                +"<tr>"
                +"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>Total Amount</td><td style=\"text-align:right\">"+amount+"</td>"
                +"</tr>"
                +"<tr>"
                +"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>Collected Payment</td><td style=\"text-align:right\">"+collectedPayment+"</td>"
                +"</tr>"
                + "</table>";


        return htmlText;
    }

    /**
     * This Method return Date and Time of a specific format
     * @return Date and Time
     */
    public String getDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy E hh:mm:ss a");
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * This method takes UserName,Password, Role as input and Returns TrainerID as String
     *
     * @param userName UserName of Trainer
     * @param password Password of Trainer
     * @param role Role Trainer
     * @return TrainerID as String
     */
    public String getTrainerIDByNamePasswordRole(String userName,String password,String role) {
        setAdminUserList();
        String ID="";
        for (AdminUser adminUser : adminUserList) {
            if (adminUser.getUserName().equals(userName) && adminUser.getPassword().equals(password) && adminUser.getRole().equals(role)) {
                ID = adminUser.getID();
                break;
            }
        }
        return ID;
    }

    /**
     *  This Method takes all session names from Sessions.txt file and sets SessionList
     */
    public void setSessionList() {
        sessionList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Sessions.txt"));
            String s;
            while((s=bufferedReader.readLine())!=null) {
                sessionList.add(s);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  This Method takes all session names from sessionList writes to Sessions.txt File
     */
    public void writeSessionToFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Sessions.txt"));
            String input = "";
            for(String session : sessionList) {
                input = input + session + "\n";
            }
            bufferedWriter.write(input);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method takes Session Name as String and deletes it from SessionList
     * @param session Session Name
     * @return Boolean value true if successfully Deleted, false otherwise
     */
    public boolean deleteSession(String session) {

       if(session.equals("")){
           return false;
       }
       setSessionList();
       sessionList.remove(session);
       writeSessionToFile();
       return true;
    }

    /**
     * This method takes session name as input and adds to SessionList
     * @param session Session Name
     * @return Boolean value true if successfully Added, false otherwise
     */
    public boolean addSession(String session) {
        setSessionList();
        if (sessionList.contains(session)) {
            return false;
        }
        sessionList.add(session);
        writeSessionToFile();
        return true;
    }

    /**
     * This Method returns all session names from sessionList of type Object[]
     * @return session names of type Object[]
     */
    public Object[] getSessionList() {
        setSessionList();
        return sessionList.toArray();
    }

    /**
     * This Method returns all time periods of type String[]
     * @return time of type String[]
     */
    public String[] getTimeList() {
        String[] time = {"9AM - 10AM","10AM - 11AM","11AM - 1PM","2PM - 3PM","3PM - 4PM","4PM - 5PM"};
        return time;
    }

    /**
     * This method returns trainID_CustomerName from userList of type String[]
     * @param trainerID TrainerID of Trainer
     * @return trainID_Name of type String[]
     */
    public String[] getTrainIDName(String trainerID) {
        setUserListForSpecificTrainer(trainerID);
        String[] trainArray = new String[userList.size()];
        for (int i=0;i<userList.size();i++) {
            trainArray[i] = userList.get(i).getTrainID()+"  "+userList.get(i).getName();
        }
        return trainArray;
    }

    /**
     * This method takes TrainID,TrainerID and returns user object of type User
     * @param trainID TrainID of Customer
     * @param trainerID Trainer ID of Trainer
     * @return user object of type User
     */
    public User getUserByTrainID(String trainID,String trainerID) {

        setUserListForSpecificTrainer(trainerID);
        User demoUser = new User();
        for(User user : userList) {
            if(user.getTrainID().equals(trainID)) {
                demoUser = user;
                break;
            }
        }
        return demoUser;
    }

    /**
     * This Method returns Content or Text of type String [For design purpose only] of a Specific User
     * @param user user object of Type User
     * @return content or text of type String
     */
    public String getContentForSpecificUser(User user) {
        String text = "\n\n    APU\n    GYM CENTRE\n\n"
                +"    TrainID : "+user.getTrainID()+"\n"
                +"    Customer ID : "+user.getID()+"\n"
                +"    Customer Name : "+user.getName()+"\n"
                +"    Trainer Name : "+getTrainerNameByID(user.getTrainerID())+"\n"
                +"    Session : "+user.getSession()+"\n"
                +"    Time : "+user.getTime()+"\n";
        if(user.isCompleted()) {
            text = text + "    Session Completed : Yes\n";
        } else {
            text = text + "    Session Completed : NO\n";
        }

        text = text
                +"    Amount : "+user.getAmount()+"\n";

        if(user.isCollected()) {
            text = text + "    Payment : Collected\n";
        } else {
            text = text + "    Payment : Not Collected\n";
        }

        text = text
                +"    FeedBack : "+user.getFeedback()+"\n";

        return text;
    }

    public boolean updateUserInfoToSpecificTrainerFile(String trainerID,User targetUser) {
        setUserListForSpecificTrainer(trainerID);

        for(int i=0;i<userList.size();i++) {
            if(userList.get(i).getTrainID().equals(targetUser.getTrainID())) {
                userList.set(i,targetUser);
                break;
            }
        }

        String inputString = "";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(trainerID+".txt"));
            for (User user : userList) {
                inputString = inputString
                        + user.getTrainID() + ","
                        + user.getID() + ","
                        + user.getName() + ","
                        + user.getPhoneNumber() + ","
                        + user.getTrainerID() + ","
                        + user.getSession() + ","
                        + user.getTime() + ","
                        + user.isCompleted() + ","
                        + user.getAmount() + ","
                        + user.isCollected() + ","
                        + user.getFeedback() + "\n";
            }
            bufferedWriter.write(inputString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * This Method return Manager Report as String
     * @return Manager Report as String
     */
    public String getManagerReport() {

        String outPutString = "\n\n    APU\n    GYM CENTRE\n\n    Date & Time : "+getDate()+"\n\n";

        outPutString = outPutString +
                 "    APU GYM Center Total Customer : " + getALLUsers().length+"\n"
                +"    APU GYM Center Total Trainer : " + trainerList.size()+"\n"
                +"    APU GYM Center Total Manager : " + (adminUserList.size()-trainerList.size())+"\n"
                +"    APU GYM Center Total Employee : " + (adminUserList.size())+"\n\n"
                +"    Total Number of Customer in Each Session\n    Session-No. of customers\n";

        boolean flag = true;
        int customerAmount = 0;
        String feedbackString = "    ";


        for (String session : sessionList) {
            int customerCount = 0;
            for(Trainer trainer : trainerList) {
                setUserListForSpecificTrainer(trainer.getID());
                for(User user : userList) {
                    if(user.getSession().equals(session)) {
                        customerCount++;
                    }
                    if(flag) {
                        customerAmount = customerAmount + user.getAmount();
                    }
                    if(!(user.getFeedback().equals("feedback"))&&flag) {
                        feedbackString = feedbackString + "TrainID "+user.getTrainID() + "Name : "+user.getName()+" FeedBack by "+getTrainerNameByID(trainer.getID())+" : "+user.getFeedback()+"\n";
                    }
                }
            }
            flag = false;
            outPutString = outPutString+ "    "+session+"-"+customerCount+"\n";
        }

        outPutString = outPutString +
                "\n    APU GYM Center Total Income : " + customerAmount+"\n\n"
               +"    FeedBack From All Trainer\n\n"+feedbackString;

        return outPutString;
    }

    /**
     * This Method Takes a Character of type char and returns if it is Digit or Not
     * @param ch  Character of type char
     * @return Boolean value if Character is digit, false Otherwise
     */
    public boolean isDigit(char ch) {
        if (ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9'||ch==(char)10||ch==(char)8) {
            return true;
        } else {
            return false;
        }
    }

}
