package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class that implements the "model" for an MVC application that calculates
 * Shannon's Theorem. * 
 * 
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 *
 */
public class ShannonsTheorem {

    private double bandWidth;
    private double signalToNoiseRatio;
    
    
    
    private final StringProperty bandWidthStrProperty = new SimpleStringProperty(this, "", null);
    private final StringProperty signalToNoiseRatioStrProperty = new SimpleStringProperty(this, "", null);
    private final StringProperty maxDataRateStrProperty = new SimpleStringProperty(this, "", null);

    /**
     * multi-argument constructor
     *
     * @param bandWidth the bandwidth in Hertz
     * @param signalToNoiseRatio SNR in dB
     */
    public ShannonsTheorem(double bandWidth, double signalToNoiseRatio) {
        this.bandWidth = bandWidth;
        this.signalToNoiseRatio = signalToNoiseRatio;
    }

    /**
     * no-arg constructor sets fields to zero
     */
    public ShannonsTheorem() {
        this(0.0, 0.0);
    }

    /**
     * Gets the bandWidth.
     *
     * @return the bandWidth
     */
    public double getBandWidth() {
        return bandWidth;
    }

    /**
     * Sets the bandWidth.
     *
     * @param bandWidth the bandWidth to set
     */
    public void setBandWidth(double bandWidth) {
        this.bandWidth = bandWidth;
    }

    /**
     * Gets the signalToNoiseRatio.
     *
     * @return the signalToNoiseRatio
     */
    public double getSignalToNoiseRatio() {
        return signalToNoiseRatio;
    }

    /**
     * Sets the signalToNoiseRatio.
     *
     * @param signalToNoiseRatio the signalToNoiseRatio to set
     */
    public void setSignalToNoiseRatio(double signalToNoiseRatio) {
        this.signalToNoiseRatio = signalToNoiseRatio;
    }

    /**
     * Calculates the logarithm base 2 of a given number.
     *
     * @param x the number to calculate the logarithm of
     * @return the logarithm base 2 of x
     */
    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    /**
     * Calculates the maximum data rate.
     *
     * @param BW the bandwidth
     * @param SNR the signal-to-noise-ratio
     * @return maximum data rate
     */
    public double maxDataRate(double BW, double SNR) {
        double SN = Math.pow(10, SNR / 10);
        return BW * log2(1 + SN);
    }

    /**
     * Calculates the maximum data rate using the current values of bandWidth
     * and signalToNoiseRatio.
     *
     * @return the maximum data rate
     */
    public double maxDataRate() {
        return maxDataRate(bandWidth, signalToNoiseRatio);
    }

    /**
     * Sets the string property of the bandWidth.
     */
    public void setBandWidthStrProperty() {

        bandWidthStrProperty.set(String.valueOf(this.bandWidth));

    }

    /**
     * Sets the string property of the signalToNoiseRatio.
     */
    public void setSignalToNoiseRatioStrProperty() {

        signalToNoiseRatioStrProperty.set(String.valueOf(this.signalToNoiseRatio));

    }

    /**
     * Sets the string property of the setMaxDataRate.
     */
    public void setMaxDataRateStrProperty() {

        maxDataRateStrProperty.set(String.valueOf(this.maxDataRate()));

    }

    /**
     *
     * Gets the string property for the bandwidth.
     *
     * @return the string property for the bandwidth.
     */
    public StringProperty getBandWidthStrProperty() {

        return bandWidthStrProperty;

    }

    /**
     *
     * Gets the string property for the signal-to-noise ratio.
     *
     * @return the string property for the signal-to-noise ratio.
     */
    public StringProperty getSignalToNoiseRatioStrProperty() {

        return signalToNoiseRatioStrProperty;

    }

    /**
     *
     * Gets the string property for the maximum data rate.
     *
     * @return the string property for the maximum data rate.
     */
    public StringProperty getMaxDataRateStrProperty() {

        return maxDataRateStrProperty;

    }

    /**
     *
     * Returns a string representation of this instance.
     *
     * @return a string representation of this instance.
     */
    @Override
    public String toString() {
        return "ShannonsTheory [bandWidth=" + bandWidth + ", signalToNoiseRatio=" + signalToNoiseRatio + "]";
    }

}
