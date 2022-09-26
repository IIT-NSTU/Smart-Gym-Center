package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartingTemplate extends FrameSetup {

    private JPanel picturePanel, componentPanel;

    /**
     *  Starting Template Constructor
     */
    public StartingTemplate() {
        setContainer();
        setPanels();
        setPicturePanel();
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
     *  Sets Panels
     */
    public void setPanels() {
        getContainer().add(getNullLabel(), BorderLayout.EAST);
        getContainer().add(getNullLabel(), BorderLayout.WEST);
        getContainer().add(getNullLabel(), BorderLayout.NORTH);
        getContainer().add(getNullLabel(), BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        getContainer().add(mainPanel, BorderLayout.CENTER);

        picturePanel = new JPanel();
        picturePanel.setBackground(Color.WHITE);
        mainPanel.add(picturePanel);

        componentPanel = new JPanel();
        componentPanel.setBackground(Color.WHITE);
        mainPanel.add(componentPanel);
    }

    /**
     * Sets Picture Panel
     */
    public void setPicturePanel() {
        JLabel pictureLabel = new JLabel(getDisplayPicture());
        picturePanel.add(pictureLabel);
    }

    public JPanel getComponentPanel() {
        return componentPanel;
    }
}
