package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import static javax.swing.BorderFactory.createMatteBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class RegisterPage extends StartingTemplate {

    private JTextField usernameTextField, nameTextField, phoneNumberTextField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JRadioButton managerRadioButton, trainerRadioButton;
    private JButton backButton;

    /**
     *  Register Page Constructor
     */
    public RegisterPage() {
        this.setSize(900, 675);
        this.setLocationRelativeTo(null);
        setComponentPanel();
    }

    /**
     *   Sets Component Panel
     */
    public void setComponentPanel() {

        GridLayout gridLayout = new GridLayout(16, 1);
        gridLayout.setVgap(5);
        getComponentPanel().setLayout(gridLayout);

        JLabel headerLabel = new JLabel("Registration");
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        getComponentPanel().add(headerLabel);

        getComponentPanel().add(getNullLabel());

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.GRAY);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        getComponentPanel().add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        usernameTextField.setForeground(Color.black);
        usernameTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        getComponentPanel().add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password (Minimum 6 characters)");
        passwordLabel.setForeground(Color.GRAY);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        getComponentPanel().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setForeground(Color.black);
        passwordField.setFont(new Font("Arial", Font.BOLD, 16));
        passwordField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        getComponentPanel().add(passwordField);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.GRAY);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        getComponentPanel().add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        nameTextField.setForeground(Color.black);
        nameTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        getComponentPanel().add(nameTextField);

        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setForeground(Color.GRAY);
        phoneNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        getComponentPanel().add(phoneNumberLabel);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Arial", Font.BOLD, 16));
        phoneNumberTextField.setForeground(Color.black);
        phoneNumberTextField.setBorder(createMatteBorder(0, 0, 2, 0, Color.blue));
        getComponentPanel().add(phoneNumberTextField);

        setButtons();
    }

    public void setButtons() {

        ButtonGroup buttonGroup = new ButtonGroup();
        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setBackground(Color.WHITE);

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

        radioButtonPanel.add(managerRadioButton);
        radioButtonPanel.add(trainerRadioButton);

        getComponentPanel().add(radioButtonPanel);

        getComponentPanel().add(getNullLabel());

        registerButton = new JButton(getRegisterButtonIcon());
        registerButton.setBorder(null);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(Color.WHITE);
        getComponentPanel().add(registerButton);

        getComponentPanel().add(getNullLabel());

        backButton = new JButton(getBackButtonIcon());
        backButton.setBorder(null);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBackground(Color.WHITE);
        getComponentPanel().add(backButton);
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public JRadioButton getManagerRadioButton() {
        return managerRadioButton;
    }

    public JRadioButton getTrainerRadioButton() {
        return trainerRadioButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
