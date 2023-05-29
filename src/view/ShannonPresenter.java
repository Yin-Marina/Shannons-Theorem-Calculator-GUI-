package view;

import model.ShannonsTheorem;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * The presenter class for the Shannons Theorem application. * 
 * 
 * Lab Professor:
 * Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class ShannonPresenter {

    private final ShannonsTheorem model;
    private final ShannonView view;
    private final SimpleStringProperty BandWidthInternal = new SimpleStringProperty();
    private final SimpleStringProperty SignalToNoiseRatioInternal = new SimpleStringProperty();
    private final SimpleStringProperty MaxDataRateInternal = new SimpleStringProperty();

    /**
     * Creates a new instance of the ShannonPresenter class.
     *
     * @param model the model for the application
     * @param view the view for the application
     */
    public ShannonPresenter(ShannonsTheorem model, ShannonView view) {
        this.model = model;
        this.view = view;
        bindToModel();
        attachViewEvents();
    }

    /**
     *
     * This class is responsible for binding the model properties to the
     * internal string properties and attaching the view events to its
     * corresponding methods.
     */
    private void bindToModel() {
        BandWidthInternal.bindBidirectional(model.getBandWidthStrProperty());
        SignalToNoiseRatioInternal.bindBidirectional(model.getSignalToNoiseRatioStrProperty());
        MaxDataRateInternal.bindBidirectional(model.getMaxDataRateStrProperty());
    }

    /**
     *
     * This method attaches events to the view components and responds
     * accordingly. If the values entered by the user are valid, it calls the
     * calculateData() method. Otherwise, it displays an error message using the
     * Alert class.
     */
    private void attachViewEvents() {
        // could use handlers instead, 
        // but TextField would need mult. for app to work correctly
        view.bandWidthFld.textProperty().bindBidirectional(BandWidthInternal);
        view.signalToNoiseRatioFld.textProperty().bindBidirectional(SignalToNoiseRatioInternal);
        view.maxDataRateFld.textProperty().bindBidirectional(MaxDataRateInternal);
        view.calculateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if ((model.getBandWidthStrProperty().get().matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$"))
                        && (model.getSignalToNoiseRatioStrProperty().get().matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$"))) {
                    calculateData();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText("Please enter a valid number and not:");
                    alert.setContentText(model.getBandWidthStrProperty().get() + "\n" + model.getSignalToNoiseRatioStrProperty().get());
                    alert.showAndWait();
                }
            }
        });
    }

    /**
     *
     * This method converts the string properties of the model to double values
     * and sets the value of the maxDataRateStrProperty of the model.
     */
    private void calculateData() {
        model.setBandWidth(Double.parseDouble(model.getBandWidthStrProperty().get()));
        model.setSignalToNoiseRatio(Double.parseDouble(model.getSignalToNoiseRatioStrProperty().get()));
        model.setMaxDataRateStrProperty();
    }
}

//class

