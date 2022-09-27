import controller.GymCenterController;
import model.GymCenterModel;
import view.GymCentreView;

public class App {
    public static void main(String[] args) {
        GymCenterModel model = new GymCenterModel();
        GymCentreView view = new GymCentreView();
        GymCenterController controller = new GymCenterController(model,view);
    }
}