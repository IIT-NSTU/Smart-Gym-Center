package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import static javax.swing.BorderFactory.createMatteBorder;

import javax.swing.*;

public class LoginPage extends StartingTemplate {

    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JRadioButton managerRadioButton, trainerRadioButton;

    /**
     * Login Page Constructor
     */
    public LoginPage() {
        setComponentPanel();
    }

    /**
     * Sets Component Panel
     */
    public void setComponentPanel() {

        getComponentPanel().setLayout(new GridLayout(12, 1));

        JLabel headerLabel = new JLabel("User Login");
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        getComponentPanel().add(headerLabel);

        getComponentPanel().add(getNullLabel());

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.GRAY);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        getComponentPanel().add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        usernameTextField.setForeground(Color.black);
        usernameTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        getComponentPanel().add(usernameTextField);

        getComponentPanel().add(getNullLabel());

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.GRAY);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        getComponentPanel().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setForeground(Color.black);
        passwordField.setFont(new Font("Arial", Font.BOLD, 16));
        passwordField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        getComponentPanel().add(passwordField);

        getComponentPanel().add(getNullLabel());

        setButtons();
    }

    public void setButtons() {

        ButtonGroup buttonGroup = new ButtonGroup();
        managerRadioButton = new JRadioButton("Manager");
        managerRadioButton.setBackground(Color.WHITE);
        managerRadioButton.setForeground(Color.GRAY);
        managerRadioButton.setFocusPainted(false);
        managerRadioButton.setFont(new Font("Arial", Font.BOLD, 18));
        buttonGroup.add(managerRadioButton);

        trainerRadioButton = new JRadioButton("Trainer");
        trainerRadioButton.setBackground(Color.WHITE);
        trainerRadioButton.setForeground(Color.GRAY);
        trainerRadioButton.setFocusPainted(false);
        trainerRadioButton.setFont(new Font("Arial", Font.BOLD, 18));
        buttonGroup.add(trainerRadioButton);

        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setBackground(Color.WHITE);
        radioButtonPanel.add(managerRadioButton);
        radioButtonPanel.add(trainerRadioButton);
        getComponentPanel().add(radioButtonPanel);

        getComponentPanel().add(getNullLabel());

        loginButton = new JButton(getLoginButtonIcon());
        loginButton.setBorder(null);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(Color.white);
        getComponentPanel().add(loginButton);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JRadioButton getManagerRadioButton() {
        return managerRadioButton;
    }

    public JRadioButton getTrainerRadioButton() {
        return trainerRadioButton;
    }
}
