package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * The ShannonView class represents the view component of the Shannon's Theorem
 * calculator. It extends the GridPane class and provides UI controls for the
 * user to input bandwidth and signal to noise ratio values and to display the
 * maximum data rate. * 
 * 
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class ShannonView extends GridPane {

    // Labels
    Label bandWidthLbl = new Label("Bandwidth:");
    Label singalToNoiseRatioLbl = new Label("Signal to Noise Ratio:");
    Label maxDataRateLbl = new Label("Max Data Rate:");

    // Fields
    TextField bandWidthFld = new TextField();
    TextField signalToNoiseRatioFld = new TextField();
    TextField maxDataRateFld = new TextField();

    // Buttons
    Button calculateBtn = new Button("Calculate");

    /**
     * Constructs a new ShannonView object and lays out the UI controls.
     */
    public ShannonView() {
        layoutForm();
    }

    /**
     * Lays out the UI controls.
     */
    private void layoutForm() {
        maxDataRateFld.setDisable(true);

        this.setHgap(5);
        this.setVgap(5);

        this.add(bandWidthLbl, 1, 2);
        this.add(singalToNoiseRatioLbl, 1, 3);
        this.add(maxDataRateLbl, 1, 4);

        this.add(bandWidthFld, 2, 2);
        this.add(signalToNoiseRatioFld, 2, 3);
        this.add(maxDataRateFld, 2, 4);

        // Add buttons and make them the same width
        VBox buttonBox = new VBox(calculateBtn);
        calculateBtn.setMaxWidth(Double.MAX_VALUE);

        this.add(buttonBox, 3, 3, 1, 5);

    }//layoutform()

}//class
