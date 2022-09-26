package view;

import javax.swing.*;
import java.awt.*;

/**
 * Admin Template that is extended by ManagerPage and TrainerPage
 */
public class AdminTemplate extends FrameSetup {
    private JPanel componentPanel;

    /**
     *  Admin Template Constructor
     */
    public AdminTemplate() {
        setContainer();
        setComponentPanel();
    }

    /**
     *  Sets Container
     */
    public void setContainer() {
        //Method Overriding Concept Used

        super.setContainer();  //Here we get setContainer() of parent class

        getContainer().setLayout(new BorderLayout(100, 30));
    }

    /**
     *  Sets Component Panel
     */
    public void setComponentPanel() {
        getContainer().add(getNullLabel(), BorderLayout.EAST);
        getContainer().add(getNullLabel(), BorderLayout.WEST);
        getContainer().add(getNullLabel(), BorderLayout.NORTH);
        getContainer().add(getNullLabel(), BorderLayout.SOUTH);

        componentPanel = new JPanel();
        componentPanel.setBackground(Color.WHITE);
        componentPanel.setLayout(new BorderLayout());
        getContainer().add(componentPanel,BorderLayout.CENTER);
    }

    public JPanel getComponentPanel() {
        return componentPanel;
    }
}
