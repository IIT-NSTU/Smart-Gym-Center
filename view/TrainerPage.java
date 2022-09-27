package view;

import model.GymCenterModel;

import javax.swing.*;
import java.awt.*;

public class TrainerPage extends AdminTemplate{

    private int tabIndex;
    private String trainID;
    private String trainerID;
    private JTabbedPane tabbedPane;
    private JButton reportGenerateButton,showInfoButton,updateButton,logoutButton;
    private JPanel customerDetailsPanel,updateCustomerInfoPanel,inputPanel,logoutPanel;
    private JComboBox trainComboBox;
    private JEditorPane editorPane;
    private JCheckBox paymentCollectedCheckBox,sessionCompletedCheckBox;
    private JTextField feedbackTextField;
    private JTextArea showSingleUserInfoTextArea;

    /**
     * Trainer Page Constructor
     */
    public TrainerPage(String trainerID,int tabIndex) {
        this.trainerID = trainerID;
        this.tabIndex = tabIndex;
        this.setSize(1400,675);
        this.setLocationRelativeTo(null);
        setTabbedPane();

    }

    public void setTabbedPane() {
        tabbedPane = new JTabbedPane();
        setCustomerDetailsPanel();
        setUpdateCustomerInfoPanel();
        setLogoutPanel();
        tabbedPane.add("Customer Details",customerDetailsPanel);
        tabbedPane.add("Update Customer Info",updateCustomerInfoPanel);
        tabbedPane.add("Log Out",logoutPanel);
        tabbedPane.setSelectedIndex(tabIndex);
        getComponentPanel().add(tabbedPane,BorderLayout.CENTER);
    }

    public void setCustomerDetailsPanel() {
        customerDetailsPanel = new JPanel();
        customerDetailsPanel.setLayout(new BorderLayout());

        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(new GymCenterModel().getHTMLContentOFTrainer(trainerID));
        editorPane.setBackground(Color.WHITE);
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        customerDetailsPanel.add(scrollPane,BorderLayout.CENTER);

        reportGenerateButton = new JButton(getReportGenerateButtonIcon());
        reportGenerateButton.setBorder(null);
        reportGenerateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reportGenerateButton.setBackground(Color.WHITE);
        customerDetailsPanel.add(reportGenerateButton,BorderLayout.SOUTH);
    }

    public void setUpdateCustomerInfoPanel() {
        updateCustomerInfoPanel = new JPanel();
        updateCustomerInfoPanel.setLayout(new GridLayout(1,2));

        setInputPanel();

        showSingleUserInfoTextArea = new JTextArea();
        showSingleUserInfoTextArea.setText("");
        showSingleUserInfoTextArea.setFont(new Font("Arial", Font.BOLD, 18));
        showSingleUserInfoTextArea.setBackground(Color.WHITE);
        showSingleUserInfoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(showSingleUserInfoTextArea);
        updateCustomerInfoPanel.add(scrollPane);
    }

    public void setInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setLayout(new GridLayout(10,1));

        JLabel userLabel = new JLabel("  Select (TrainID-UserName)");
        userLabel.setForeground(Color.GRAY);
        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(userLabel);

        trainComboBox = new JComboBox(new GymCenterModel().getTrainIDName(trainerID));
        trainComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(trainComboBox);

        showInfoButton = new JButton(getShowInfoButtonIcon());
        showInfoButton.setBorder(null);
        showInfoButton.setFocusPainted(false);
        showInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showInfoButton.setBackground(Color.WHITE);
        inputPanel.add(showInfoButton);

        JLabel paymentLabel = new JLabel("  Payment");
        paymentLabel.setForeground(Color.GRAY);
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(paymentLabel);

        paymentCollectedCheckBox = new JCheckBox("  Collected");
        paymentCollectedCheckBox.setFont(new Font("Arial", Font.BOLD, 18));
        paymentCollectedCheckBox.setBackground(Color.WHITE);
        paymentCollectedCheckBox.setEnabled(false);
        inputPanel.add(paymentCollectedCheckBox);

        JLabel sessionLabel = new JLabel("  Session");
        sessionLabel.setForeground(Color.GRAY);
        sessionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(sessionLabel);

        sessionCompletedCheckBox = new JCheckBox("  Completed");
        sessionCompletedCheckBox.setFont(new Font("Arial", Font.BOLD, 18));
        sessionCompletedCheckBox.setBackground(Color.WHITE);
        sessionCompletedCheckBox.setEnabled(false);
        inputPanel.add(sessionCompletedCheckBox);

        JLabel feedbackLabel = new JLabel(" Feedback");
        feedbackLabel.setForeground(Color.GRAY);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(feedbackLabel);

        feedbackTextField = new JTextField();
        feedbackTextField.setEnabled(false);
        feedbackTextField.setFont(new Font("Arial", Font.BOLD, 18));
        inputPanel.add(feedbackTextField);

        updateButton = new JButton(getUpdateButtonIcon());
        updateButton.setBorder(null);
        updateButton.setFocusPainted(false);
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateButton.setBackground(Color.WHITE);
        updateButton.setEnabled(false);
        inputPanel.add(updateButton);

        updateCustomerInfoPanel.add(inputPanel);
    }


    public void setLogoutPanel() {
        logoutPanel = new ImagePanel(new ImageIcon("GYM.jpg").getImage());
        logoutPanel.setLayout(new BorderLayout(250, 150));

        logoutPanel.add(getNullLabel(),BorderLayout.EAST);
        logoutPanel.add(getNullLabel(),BorderLayout.WEST);
        logoutPanel.add(getNullLabel(),BorderLayout.NORTH);
        logoutPanel.add(getNullLabel(),BorderLayout.SOUTH);

        logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 20));
        logoutButton.setBorder(null);
        logoutButton.setFocusPainted(false);
        logoutButton.setBackground(Color.BLUE);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutPanel.add(logoutButton,BorderLayout.CENTER);
    }

    public String getTrainerID() {
        return trainerID;
    }

    public JButton getReportGenerateButton() {
        return reportGenerateButton;
    }

    public JEditorPane getEditorPane() {
        return editorPane;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getShowInfoButton() {
        return showInfoButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JComboBox getTrainComboBox() {
        return trainComboBox;
    }

    public JCheckBox getPaymentCollectedCheckBox() {
        return paymentCollectedCheckBox;
    }

    public JCheckBox getSessionCompletedCheckBox() {
        return sessionCompletedCheckBox;
    }

    public JTextField getFeedbackTextField() {
        return feedbackTextField;
    }

    public JTextArea getShowSingleUserInfoTextArea() {
        return showSingleUserInfoTextArea;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }
}
