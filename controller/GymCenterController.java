package controller;

import model.GymCenterModel;
import model.User;
import view.*;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

/**
 * This class contains all the controlling methods between View(Front-End) and Model(Back-End) class.
 */
public class GymCenterController {

    GymCenterModel model; // Variable of type GymCentreManagementSystemModel
    GymCentreView view; // Variable of type GymCentreManagementSystemView

    /**
     * GymCentreManagementSystemController Constructor Sets Model and View
     *
     * @param model Model
     * @param view View
     */
    public GymCenterController(GymCenterModel model, GymCentreView view) {
        this.model = model;
        this.view = view;

        setLoginPageButtons();
        setManagerPageButton();
        setTrainerPageButton();
        setRegisterPageButtons();
    }

    /**
     * This Method Sets All Registration Data of Manager or Trainer to File and
     * Checks the data is valid or not. After Registration According to role Manager Page or Trainer
     * Page Opens.
     */
    public void clickAdminRegisterButton() {
        view.getRegisterPage().getRegisterButton().addActionListener(e-> {
            String userName = view.getRegisterPage().getUsernameTextField().getText();
            String password = view.getRegisterPage().getPasswordField().getText();
            String name = view.getRegisterPage().getNameTextField().getText();
            String phoneNumber = view.getRegisterPage().getPhoneNumberTextField().getText();
            String role = "";

            if (view.getRegisterPage().getManagerRadioButton().isSelected()) {
                role = "Manager";
            } else if (view.getRegisterPage().getTrainerRadioButton().isSelected()){
                role = "Trainer";
            }

            if (password.length() < 6) {
                JOptionPane.showMessageDialog(null,"Please enter a password of minimum 6 characters.");
                return;
            }

            if (model.writeAdminRegistrationData(userName, password, name, phoneNumber, role)) {
                if (role.equals("Manager")) {
                    view.getRegisterPage().dispose();
                    view.setManagerPage(new ManagerPage(0));
                    view.getManagerPage().setVisible(true);
                    setManagerPageButton();

                } else if (role.equals("Trainer")) {
                    view.getRegisterPage().dispose();
                    view.setTrainerPage(new TrainerPage(model.getTrainerIDByNamePasswordRole(userName,password,role),0));
                    view.getTrainerPage().setVisible(true);
                    setTrainerPageButton();

                }
            }
        });
    }

    /**
     * This Method Checks the Login Data is Valid or Not. After Login According to role Manager Page or Trainer
     * Page Opens.
     */
    public void clickLoginButton() {
        view.getLoginPage().getLoginButton().addActionListener(e-> {
            String userName = view.getLoginPage().getUsernameTextField().getText();
            String password = view.getLoginPage().getPasswordField().getText();
            String role = "";

            if (view.getLoginPage().getManagerRadioButton().isSelected()) {
                role = "Manager";
            } else if (view.getLoginPage().getTrainerRadioButton().isSelected()){
                role = "Trainer";
            }

            if(model.canLogin(userName,password,role)) {
                if (role.equals("Manager")) {
                    view.getLoginPage().dispose();
                    view.setManagerPage(new ManagerPage(0));
                    view.getManagerPage().setVisible(true);
                    setManagerPageButton();

                } else if (role.equals("Trainer")) {
                    view.getLoginPage().dispose();
                    view.setTrainerPage(new TrainerPage(model.getTrainerIDByNamePasswordRole(userName,password,role),0));
                    view.getTrainerPage().setVisible(true);
                    setTrainerPageButton();
                }
            } else {
                JOptionPane.showMessageDialog(null,"Invalid Information\nPlease Register or Give Valid Information");
            }
        });
    }


    /**
     * This Method Sets All Customer Registration Data to File and
     * Checks the data is valid or not.
     */
    public void clickUserRegisterButton() {
        view.getManagerPage().getUserRegistrationButton().addActionListener(e-> {
            String name = view.getManagerPage().getNameTextField().getText();
            String phoneNumber = view.getManagerPage().getPhoneNumberTextField().getText();

            if (model.writeUserRegistrationData(name, phoneNumber)) {
                JOptionPane.showMessageDialog(null,"User "+name+" is Successfully Registered");
                view.getManagerPage().dispose();
                view.setManagerPage(new ManagerPage(1));
                view.getManagerPage().setVisible(true);
                setManagerPageButton();
            }
        });
    }

    /**
     * This Method Sets All Session Booking Data to File and
     * Checks the data is valid or not.
     */
    public void setSessionBookingData() {
        view.getManagerPage().getSubmitBookingButton().addActionListener(e-> {
            try {
                String userID = view.getManagerPage().getUserComboBox().getSelectedItem().toString().substring(0, 9);
                String trainerID = view.getManagerPage().getTrainerComboBox().getSelectedItem().toString().substring(0, 9);
                String session = view.getManagerPage().getSessionComboBox().getSelectedItem().toString();
                String time=view.getManagerPage().getTimeComboBox().getSelectedItem().toString();
                String amount = view.getManagerPage().getAmountTextField().getText();

                if (model.writeSessionBookingData(userID,trainerID,session,time,amount)) {
                    JOptionPane.showMessageDialog(null,"Session Booked Successfully");
                }
            }catch (NullPointerException ex) {ex.getMessage();}
        });
    }

    /**
     * This Method Saves The Report of Trainer Page in Pdf Format
     */
    public void clickReportGenerateByTrainerButton() {
        view.getTrainerPage().getReportGenerateButton().addActionListener(e->{
            try {
                view.getTrainerPage().getEditorPane().print();
            } catch (PrinterException ex) {

            }
        });
    }

    /**
     * This Method Saves The Report of Manager Page in Pdf Format
     */
    public void clickReportGenerateByManagerButton() {
        view.getManagerPage().getReportGenerateButton().addActionListener(e->{
            try {
                view.getManagerPage().getManagerReportTextArea().print();
            } catch (PrinterException ex) {

            }
        });
    }

    /**
     * This Method Logs out from Manager Page and Opens Login Page
     */
    public void clickManagerPageLogoutButton(){
        view.getManagerPage().getLogoutButton().addActionListener(e->{
            view.getManagerPage().dispose();
            view.setLoginPage(new LoginPage());
            view.getLoginPage().setVisible(true);
            setLoginPageButtons();
        });
    }

    /**
     * This Method Checks Manager Page Phone Number and Amount is Valid Digit or Not. If Not then Shows Warning
     */
    public void clickManagerPageDigitCheck() {
        view.getManagerPage().getPhoneNumberTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                if(!model.isDigit(keyEvent.getKeyChar())) {
                    JOptionPane.showMessageDialog(null,"Invalid Digit");
                    view.getManagerPage().getPhoneNumberTextField().setText("");
                }
            }
        });

        view.getManagerPage().getAmountTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                if(!model.isDigit(keyEvent.getKeyChar())) {
                    JOptionPane.showMessageDialog(null,"Invalid Digit");
                    view.getManagerPage().getAmountTextField().setText("");
                }
            }
        });

    }

    /**
     * This Method Logs out from Trainer Page and Opens Login Page
     */
    public void clickTrainerLogoutButton() {
        view.getTrainerPage().getLogoutButton().addActionListener(e->{
            view.getTrainerPage().dispose();
            view.setLoginPage(new LoginPage());
            view.getLoginPage().setVisible(true);
            setLoginPageButtons();
        });
    }

    /**
     * This Method Logs out from Register Page and Opens Login Page
     */
    public void clickRegisterPageBackButton() {
        view.getRegisterPage().getBackButton().addActionListener(e->{
            view.getRegisterPage().dispose();
            view.setManagerPage(new ManagerPage(0));
            view.getManagerPage().setVisible(true);
            setManagerPageButton();
        });
    }

    /**
     * This Method Checks Register Page Phone Number is Valid Digit or Not. If Not then Shows Warning
     */
    public void clickRegisterPagePhoneNumber(){
        view.getRegisterPage().getPhoneNumberTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                if(!model.isDigit(keyEvent.getKeyChar())) {
                    JOptionPane.showMessageDialog(null,"Invalid Digit");
                    view.getRegisterPage().getPhoneNumberTextField().setText("");
                }
            }
        });
    }

    /**
     * This Method Adds Session to File and also Validate it.
     */
    public void clickAddSessionButton() {
        view.getManagerPage().getAddSessionButton().addActionListener(e->{
            String session = view.getManagerPage().getSessionTextField().getText();

            if(session.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Session");
            } else {
                if (model.addSession(session)) {
                    JOptionPane.showMessageDialog(null, "Session Added "+session+" Successfully");
                    view.getManagerPage().dispose();
                    view.setManagerPage(new ManagerPage(3));
                    view.getManagerPage().setVisible(true);
                    setManagerPageButton();
                } else {
                    JOptionPane.showMessageDialog(null, "Session Already Exists");
                }
            }
        });
    }

    /**
     * This Method Deletes Session to File and also checks If no session remains to delete.
     */
    public void clickDeleteSessionButton() {
        view.getManagerPage().getDeleteSessionButton().addActionListener(e->{
            String session="";
            try {
                session = view.getManagerPage().getDeleteSessionComboBox().getSelectedItem().toString();
            }catch (NullPointerException ex) {}

            if(model.deleteSession(session)) {
                JOptionPane.showMessageDialog(null,"Session Deleted "+session+" Successfully");
                view.getManagerPage().dispose();
                view.setManagerPage(new ManagerPage(3));
                view.getManagerPage().setVisible(true);
                setManagerPageButton();
            } else {
                JOptionPane.showMessageDialog(null,"No Sessions to Delete");
            }
        });
    }

    /**
     * This Method Performs the Operations of TrainerPageShowInfo Button
     */
    public void clickTrainerPageShowInfoButton() {
        view.getTrainerPage().getShowInfoButton().addActionListener(e->{
            try {
                view.getTrainerPage().getUpdateButton().setEnabled(true);
                String trainID = view.getTrainerPage().getTrainComboBox().getSelectedItem().toString().substring(0, 9);
                String trainerID = view.getTrainerPage().getTrainerID();
                User user = model.getUserByTrainID(trainID, trainerID);

                view.getTrainerPage().getShowSingleUserInfoTextArea().setText(model.getContentForSpecificUser(user));
                view.getTrainerPage().setTrainID(trainID);

                if (user.isCollected()) {
                    view.getTrainerPage().getPaymentCollectedCheckBox().setSelected(true);
                    view.getTrainerPage().getPaymentCollectedCheckBox().setEnabled(false);
                } else {
                    view.getTrainerPage().getPaymentCollectedCheckBox().setEnabled(true);
                }

                if (user.isCompleted()) {
                    view.getTrainerPage().getSessionCompletedCheckBox().setSelected(true);
                    view.getTrainerPage().getSessionCompletedCheckBox().setEnabled(false);
                } else {
                    view.getTrainerPage().getSessionCompletedCheckBox().setEnabled(true);
                }

                view.getTrainerPage().getFeedbackTextField().setEnabled(true);

                clickTrainerPageShowInfoButton();
            }catch (NullPointerException exception) {
                JOptionPane.showMessageDialog(null,"Invalid Selection");
            }
        });
    }

    /**
     * This Method Performs the Operations of TrainerPageUpdate Button
     */
    public void clickTrainerPageUpdateButton() {
        view.getTrainerPage().getUpdateButton().addActionListener(e->{
            try{
                String trainID = view.getTrainerPage().getTrainID();
                String trainerID = view.getTrainerPage().getTrainerID();
                boolean isCompleted = view.getTrainerPage().getSessionCompletedCheckBox().isSelected();
                boolean isCollected= view.getTrainerPage().getPaymentCollectedCheckBox().isSelected();
                String feedback = view.getTrainerPage().getFeedbackTextField().getText();

                if(feedback.equals("")) {
                    feedback = "feedback";
                }

                User user = model.getUserByTrainID(trainID,trainerID);

                user.setCompleted(isCompleted);
                user.setCollected(isCollected);
                user.setFeedback(feedback);

                if(model.updateUserInfoToSpecificTrainerFile(view.getTrainerPage().getTrainerID(),user)) {
                    JOptionPane.showMessageDialog(null,"User Data Updated Successfully");
                    view.getTrainerPage().dispose();
                    view.setTrainerPage(new TrainerPage(trainerID,1));
                    view.getTrainerPage().setVisible(true);
                    setTrainerPageButton();
                }
            }catch (Exception ex) {

            }
        });
    }

    public void clickRegisterPageButton() {
        view.getManagerPage().getAdminRegistrationButton().addActionListener(e->{
            view.getManagerPage().dispose();
            view.setRegisterPage(new RegisterPage());
            view.getRegisterPage().setVisible(true);
            setRegisterPageButtons();
        });
    }

    /**
     * Combines All Features of Login Page for ReCreated Objects to work properly.
     */
    public void setLoginPageButtons() {
        clickLoginButton();
    }

    /**
     * Combines All Features of Manager Page for ReCreated Objects to work properly.
     */
    public void setManagerPageButton() {
        clickRegisterPageButton();
        clickUserRegisterButton();
        setSessionBookingData();
        clickAddSessionButton();
        clickDeleteSessionButton();
        clickReportGenerateByManagerButton();
        clickManagerPageLogoutButton();
        clickManagerPageDigitCheck();
    }

    /**
     * Combines All Features of Trainer Page for ReCreated Objects to work properly.
     */
    public void setTrainerPageButton() {
        clickReportGenerateByTrainerButton();
        clickTrainerPageShowInfoButton();
        clickTrainerPageUpdateButton();
        clickTrainerLogoutButton();
    }

    /**
     * Combines All Features of Register Page for ReCreated Objects to work properly.
     */
    public void setRegisterPageButtons() {
        clickAdminRegisterButton();
        clickRegisterPageBackButton();
        clickRegisterPagePhoneNumber();
    }
}
