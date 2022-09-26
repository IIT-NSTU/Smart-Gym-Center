package view;

import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Parent CLass of all View CLasses that contains all the basic features that a JFrame Must Have
 */
public class FrameSetup extends JFrame {

    private Container container;    //Frame Container Declaration

    private final ImageIcon displayPicture =
            new ImageIcon(this.getClass().getResource("/resources/displayPicture.png"));
    private final ImageIcon  appIcon =
            new ImageIcon(this.getClass().getResource("/resources/appIcon.png"));
    private final ImageIcon  loginButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/loginButton.png"));
    private final ImageIcon  registerButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/registerButton.png"));
    private final ImageIcon  submitBookingButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/submitBookingButton.png"));
    private final ImageIcon  reportGenerateButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/reportGenerateButton.png"));
    private final ImageIcon  logoutButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/logoutButton.png"));
    private final ImageIcon  backButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/backButton.png"));
    private final ImageIcon  logoutPageIcon =
            new ImageIcon(this.getClass().getResource("/resources/logoutPage.png"));
    private final ImageIcon  addSessionButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/addSessionButton.png"));
    private final ImageIcon  deleteSessionButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/deleteSessionButton.png"));
    private final ImageIcon showInfoButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/showInfoButton.png"));
    private final ImageIcon  updateButtonIcon =
            new ImageIcon(this.getClass().getResource("/resources/updateButton.png"));

    /**
     *  FrameSetup Constructor
     */
    public FrameSetup() {
        setFrame();
        setContainer();
        setAppIcon();
    }

    /**
     *  Sets Frame Basic Features
     */
    public void setFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("APU Gym Centre Management System");
    }

    /**
     *  Sets Container
     */
    public void setContainer() {
        container = this.getContentPane();
        container.setBackground(Color.WHITE);
    }

    /**
     *  Sets Application Icon
     */
    public void setAppIcon() {
        this.setIconImage(appIcon.getImage());
    }

    public Container getContainer() {
        return container;
    }

    public JLabel getNullLabel() {
        return new JLabel();
    }

    public ImageIcon getDisplayPicture() {
        return displayPicture;
    }

    public ImageIcon getLoginButtonIcon() {
        return loginButtonIcon;
    }
    public ImageIcon getRegisterButtonIcon() {
        return registerButtonIcon;
    }

    public ImageIcon getSubmitBookingButtonIcon() {
        return submitBookingButtonIcon;
    }

    public ImageIcon getReportGenerateButtonIcon() {
        return reportGenerateButtonIcon;
    }

    public ImageIcon getLogoutButtonIcon() {
        return logoutButtonIcon;
    }

    public ImageIcon getBackButtonIcon() {
        return backButtonIcon;
    }

    public ImageIcon getLogoutPageIcon() {
        return logoutPageIcon;
    }

    public ImageIcon getAddSessionButtonIcon() {
        return addSessionButtonIcon;
    }

    public ImageIcon getDeleteSessionButtonIcon() {
        return deleteSessionButtonIcon;
    }

    public ImageIcon getUpdateButtonIcon() {
        return updateButtonIcon;
    }

    public ImageIcon getShowInfoButtonIcon() {
        return showInfoButtonIcon;
    }
}
