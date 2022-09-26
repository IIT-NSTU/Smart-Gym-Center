package view;

import model.GymCenterModel;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createMatteBorder;

public class ManagerPage extends AdminTemplate {

    private JTabbedPane tabbedPane;
    private JPanel managerTrainerRegistrationPanel, userRegistrationPanel,bookingSessionPanel,customerDetailsPanel,logoutPanel,sessionsPanel;
    private JTextField nameTextField,phoneNumberTextField,amountTextField,sessionTextField;
    private JButton adminRegistrationButton,userRegistrationButton,submitBookingButton,addSessionButton,deleteSessionButton,reportGenerateButton,logoutButton;
    private JComboBox userComboBox,trainerComboBox,sessionComboBox,timeComboBox,deleteSessionComboBox;
    private JTextArea managerReportTextArea;

    /**
     * Manager Page Constructor
     * @param tabIndex TabIndex
     */
    public ManagerPage(int tabIndex) {
        setTabbedPane(tabIndex);
    }

    public void setTabbedPane(int tabIndex) {
        tabbedPane = new JTabbedPane();
        setManagerTrainerRegistrationPanel();
        setUserRegistrationPanel();
        setBookingSessionPanel();
        setSessionsPanel();
        setCustomerDetailsPanel();
        setLogoutPanel();
        tabbedPane.add("Admin Register" , managerTrainerRegistrationPanel);
        tabbedPane.add("User Registration",userRegistrationPanel);
        tabbedPane.add("Book TrainerPage & Session",bookingSessionPanel);
        tabbedPane.add("Sessions",sessionsPanel);
        tabbedPane.add("Customer Details",customerDetailsPanel);
        tabbedPane.add("Log Out",logoutPanel);
        tabbedPane.setSelectedIndex(tabIndex);
        getComponentPanel().add(tabbedPane,BorderLayout.CENTER);
    }

    public void setManagerTrainerRegistrationPanel() {
        managerTrainerRegistrationPanel = new JPanel();
        managerTrainerRegistrationPanel.setLayout(new BorderLayout(125,125));
        managerTrainerRegistrationPanel.setBackground(Color.WHITE);

        managerTrainerRegistrationPanel.add(getNullLabel(),BorderLayout.EAST);
        managerTrainerRegistrationPanel.add(getNullLabel(),BorderLayout.WEST);
        managerTrainerRegistrationPanel.add(getNullLabel(),BorderLayout.NORTH);
        managerTrainerRegistrationPanel.add(getNullLabel(),BorderLayout.SOUTH);

        adminRegistrationButton = new JButton(getRegisterButtonIcon());
        adminRegistrationButton.setBorder(null);
        adminRegistrationButton.setFocusPainted(false);
        adminRegistrationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminRegistrationButton.setBackground(Color.WHITE);
        managerTrainerRegistrationPanel.add(adminRegistrationButton,BorderLayout.CENTER);
    }

    public void setUserRegistrationPanel() {
        userRegistrationPanel = new JPanel();
        userRegistrationPanel.setBackground(Color.WHITE);
        userRegistrationPanel.setLayout(new BorderLayout(150,50));

        userRegistrationPanel.add(getNullLabel(),BorderLayout.SOUTH);
        userRegistrationPanel.add(getNullLabel(),BorderLayout.EAST);
        userRegistrationPanel.add(getNullLabel(),BorderLayout.WEST);
        userRegistrationPanel.add(getNullLabel(),BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setLayout(new GridLayout(6, 1));

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.GRAY);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        nameTextField.setForeground(Color.black);
        nameTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        inputPanel.add(nameTextField);

        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setForeground(Color.GRAY);
        phoneNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(phoneNumberLabel);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Arial", Font.BOLD, 16));
        phoneNumberTextField.setForeground(Color.black);
        phoneNumberTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        inputPanel.add(phoneNumberTextField);

        inputPanel.add(getNullLabel());

        userRegistrationButton = new JButton(getRegisterButtonIcon());
        userRegistrationButton.setBorder(null);
        userRegistrationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userRegistrationButton.setBackground(Color.WHITE);
        inputPanel.add(userRegistrationButton);

        userRegistrationPanel.add(inputPanel,BorderLayout.CENTER);
    }

    public void setBookingSessionPanel() {
        bookingSessionPanel = new JPanel();
        bookingSessionPanel.setBackground(Color.WHITE);
        bookingSessionPanel.setLayout(new BorderLayout(150,20));

        bookingSessionPanel.add(getNullLabel(),BorderLayout.SOUTH);
        bookingSessionPanel.add(getNullLabel(),BorderLayout.EAST);
        bookingSessionPanel.add(getNullLabel(),BorderLayout.WEST);
        bookingSessionPanel.add(getNullLabel(),BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setLayout(new GridLayout(12, 1));

        JLabel userLabel = new JLabel("Select User");
        userLabel.setForeground(Color.GRAY);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(userLabel);

        userComboBox = new JComboBox(new GymCenterModel().getALLUsers());
        userComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(userComboBox);

        JLabel trainerLabel = new JLabel("Select Trainer");
        trainerLabel.setForeground(Color.GRAY);
        trainerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(trainerLabel);

        trainerComboBox = new JComboBox(new GymCenterModel().getTrainers());
        trainerComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(trainerComboBox);

        JLabel sessionLabel = new JLabel("Select Session");
        sessionLabel.setForeground(Color.GRAY);
        sessionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(sessionLabel);

        sessionComboBox = new JComboBox(new GymCenterModel().getSessionList());
        sessionComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(sessionComboBox);

        JLabel timeLabel = new JLabel("Select Time");
        timeLabel.setForeground(Color.GRAY);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(timeLabel);

        timeComboBox = new JComboBox(new GymCenterModel().getTimeList());
        timeComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(timeComboBox);

        JLabel amountLabel = new JLabel("Payment Amount");
        amountLabel.setForeground(Color.GRAY);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(amountLabel);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Arial", Font.BOLD, 16));
        amountTextField.setForeground(Color.black);
        amountTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        inputPanel.add(amountTextField);

        inputPanel.add(getNullLabel());

        submitBookingButton = new JButton(getSubmitBookingButtonIcon());
        submitBookingButton.setBorder(null);
        submitBookingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitBookingButton.setBackground(Color.WHITE);
        inputPanel.add(submitBookingButton);

        bookingSessionPanel.add(inputPanel,BorderLayout.CENTER);
    }

    public void setSessionsPanel() {

        sessionsPanel = new JPanel();
        sessionsPanel.setBackground(Color.WHITE);
        sessionsPanel.setLayout(new BorderLayout(150,20));

        sessionsPanel.add(getNullLabel(),BorderLayout.SOUTH);
        sessionsPanel.add(getNullLabel(),BorderLayout.EAST);
        sessionsPanel.add(getNullLabel(),BorderLayout.WEST);
        sessionsPanel.add(getNullLabel(),BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setLayout(new GridLayout(9, 1));

        JLabel enterSessionLabel = new JLabel("Enter Session");
        enterSessionLabel.setForeground(Color.GRAY);
        enterSessionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(enterSessionLabel);

        sessionTextField = new JTextField();
        sessionTextField.setFont(new Font("Arial", Font.BOLD, 16));
        sessionTextField.setForeground(Color.black);
        sessionTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        inputPanel.add(sessionTextField);

        inputPanel.add(getNullLabel());

        addSessionButton = new JButton(getAddSessionButtonIcon());
        addSessionButton.setBorder(null);
        addSessionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addSessionButton.setFocusPainted(false);
        addSessionButton.setBackground(Color.WHITE);
        inputPanel.add(addSessionButton);

        inputPanel.add(getNullLabel());

        JLabel selectSessionLabel = new JLabel("Select Session");
        selectSessionLabel.setForeground(Color.GRAY);
        selectSessionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(selectSessionLabel);

        deleteSessionComboBox = new JComboBox(new GymCenterModel().getSessionList());
        deleteSessionComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(deleteSessionComboBox);

        inputPanel.add(getNullLabel());

        deleteSessionButton = new JButton(getDeleteSessionButtonIcon());
        deleteSessionButton.setBorder(null);
        deleteSessionButton.setFocusPainted(false);
        deleteSessionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteSessionButton.setBackground(Color.WHITE);
        inputPanel.add( deleteSessionButton);

        sessionsPanel.add(inputPanel,BorderLayout.CENTER);
    }

    public void setCustomerDetailsPanel() {

        customerDetailsPanel = new JPanel();
        customerDetailsPanel.setLayout(new BorderLayout());

        managerReportTextArea = new JTextArea();
        managerReportTextArea.setText(new GymCenterModel().getManagerReport());
        managerReportTextArea.setBackground(Color.WHITE);
        managerReportTextArea.setFont(new Font("Arial", Font.BOLD, 14));
        managerReportTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(managerReportTextArea);
        customerDetailsPanel.add(scrollPane,BorderLayout.CENTER);

        reportGenerateButton = new JButton(getReportGenerateButtonIcon());
        reportGenerateButton.setBorder(null);
        reportGenerateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reportGenerateButton.setBackground(Color.WHITE);
        customerDetailsPanel.add(reportGenerateButton,BorderLayout.SOUTH);
    }

    public void setLogoutPanel() {
        logoutPanel = new JPanel();
        logoutPanel.setLayout(new BorderLayout());

        logoutButton = new JButton(getLogoutPageIcon());
        logoutButton.setBorder(null);
        logoutButton.setFocusPainted(false);
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutButton.setBackground(Color.WHITE);
        logoutPanel.add(logoutButton,BorderLayout.CENTER);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public JButton getUserRegistrationButton() {
        return userRegistrationButton;
    }

    public JButton getSubmitBookingButton() {
        return submitBookingButton;
    }

    public JComboBox getUserComboBox() {
        return userComboBox;
    }

    public JComboBox getTrainerComboBox() {
        return trainerComboBox;
    }

    public JComboBox getSessionComboBox() {
        return sessionComboBox;
    }

    public JTextField getAmountTextField() {
        return amountTextField;
    }

    public void setUserComboBox(JComboBox userComboBox) {
        this.userComboBox = userComboBox;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getReportGenerateButton() {
        return reportGenerateButton;
    }

    public JButton getAddSessionButton() {
        return addSessionButton;
    }

    public JButton getDeleteSessionButton() {
        return deleteSessionButton;
    }

    public JComboBox getDeleteSessionComboBox() {
        return deleteSessionComboBox;
    }

    public JTextField getSessionTextField() {
        return sessionTextField;
    }

    public JComboBox getTimeComboBox() {
        return timeComboBox;
    }

    public JTextArea getManagerReportTextArea() {
        return managerReportTextArea;
    }

    public JButton getAdminRegistrationButton() {
        return adminRegistrationButton;
    }
}
