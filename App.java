import controller.GymCenterController;
import model.GymCenterModel;
import view.GymCentreView;

/**
 * This is the Only Class that contains the Main Method. This Class Combines All the Main
 * Portions of this Project.They are Model(For BackEnd) View (For Front End) Controller (As Intermediate Role)
 */
public class App {
    public static void main(String[] args) {
        GymCenterModel model = new GymCenterModel();
        GymCentreView view = new GymCentreView();
        GymCenterController controller = new GymCenterController(model,view);
    }
}