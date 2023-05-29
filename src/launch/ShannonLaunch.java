package launch;

import model.ShannonsTheorem;
import view.ShannonPresenter;
import view.ShannonView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class for launching the Shannons Theorem application. * 
 * 
 * Lab Professor: 
 * Siju Philip
 *
 * Date: Apr. 12, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class ShannonLaunch extends Application {

    /**
     * The entry point for the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Initializes the application.
     *
     * @param stage the primary stage for the application
     */
    @Override
    public void start(Stage stage) {
        ShannonsTheorem model = new ShannonsTheorem();
        ShannonView view = new ShannonView();

        Scene scene = new Scene(view);

        ShannonPresenter presenter = new ShannonPresenter(model, view);

        stage.setScene(scene);
        stage.setTitle("Shannons Theorem");
        stage.show();
    }
}
