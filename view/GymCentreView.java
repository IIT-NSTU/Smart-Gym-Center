package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import static javax.swing.BorderFactory.createMatteBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * This is the GymCentreView Page of this project that Contains all the FrontEnd Programs
 */
public class GymCentreView extends StartingTemplate {
    private JLabel progressLabel;
    private JProgressBar progressbar;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ManagerPage managerPage;
    private TrainerPage trainerPage;

    /**
     *   Constructor of GymCentreView Class
     */
    public GymCentreView() {
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        managerPage = new ManagerPage(0);
        trainerPage = new TrainerPage("",0);
        setComponentPanel();
        runThread();
    }

    /**
     *  Sets Component Panel
     */
    public void setComponentPanel() {

        getComponentPanel().setLayout(new GridLayout(13, 1));
        getComponentPanel().add(getNullLabel());

        JLabel welcomeLabel = new JLabel("WELCOME TO");
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        getComponentPanel().add(welcomeLabel);

        getComponentPanel().add(getNullLabel());

        JLabel projectNameLabelPart1 = new JLabel("SMART");
        projectNameLabelPart1.setHorizontalAlignment(JLabel.CENTER);
        projectNameLabelPart1.setForeground(Color.BLACK);
        projectNameLabelPart1.setFont(new Font("Monospaced", Font.BOLD, 28));
        getComponentPanel().add(projectNameLabelPart1);

        JLabel projectNameLabelPart2 = new JLabel("GYM ");
        projectNameLabelPart2.setHorizontalAlignment(JLabel.CENTER);
        projectNameLabelPart2.setForeground(Color.BLACK);
        projectNameLabelPart2.setFont(new Font("Monospaced", Font.BOLD, 28));
        getComponentPanel().add(projectNameLabelPart2);

        JLabel projectNameLabelPart3 = new JLabel("CENTER");
        projectNameLabelPart3.setHorizontalAlignment(JLabel.CENTER);
        projectNameLabelPart3.setForeground(Color.BLACK);
        projectNameLabelPart3.setFont(new Font("Monospaced", Font.BOLD, 28));
        getComponentPanel().add(projectNameLabelPart3);

        getComponentPanel().add(getNullLabel());
        getComponentPanel().add(getNullLabel());

        progressbar = new JProgressBar();
        progressbar.setBackground(Color.WHITE);
        progressbar.setForeground(Color.BLUE);
        progressbar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        progressbar.setBorder(createMatteBorder(0, 0, 20, 0, Color.WHITE));
        getComponentPanel().add(progressbar);

        progressLabel = new JLabel("0%");
        progressLabel.setForeground(Color.BLACK);
        progressLabel.setHorizontalAlignment(JLabel.CENTER);
        progressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        getComponentPanel().add(progressLabel);

        getComponentPanel().add(getNullLabel());
        getComponentPanel().add(getNullLabel());
    }

    /**
     * Runs the Loading UI and Opens Login Page
     */
    public void runThread() {

        this.setUndecorated(true);
        this.setSize(870, 450);
        this.setVisible(true);

        try {
            for (int i = 0; i <= 18; i++) {
                Thread.sleep(80);
                this.progressLabel.setText(i + "%");
                this.progressbar.setValue(i);
            }

            for (int i = 18; i <= 87; i++) {
                Thread.sleep(20);
                this.progressLabel.setText(i + "%");
                this.progressbar.setValue(i);
            }

            for (int i = 87; i <= 100; i++) {
                Thread.sleep(100);
                this.progressLabel.setText(i + "%");
                this.progressbar.setValue(i);
            }

            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.dispose();
        loginPage.setVisible(true);
    }

    public void setManagerPage(ManagerPage managerPage) {
        this.managerPage = managerPage;
    }

    public ManagerPage getManagerPage() {
        return managerPage;
    }

    public void setTrainerPage(TrainerPage trainerPage) {
        this.trainerPage = trainerPage;
    }

    public TrainerPage getTrainerPage() {
        return trainerPage;
    }

    public void setRegisterPage(RegisterPage registerPage) {
        this.registerPage = registerPage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
