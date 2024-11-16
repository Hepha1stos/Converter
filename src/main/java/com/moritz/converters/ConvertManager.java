package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConvertManager {

    /**
     * Aktuell ausgewählter Konverter.
     */
    private Converter<Double> currentConverter;

    /**
     * Instanz des Loggers.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(CelsiusFahrenheitConverter.class);

    /**
     * Konstruktor.
     *
     * @param converter
     */
    public ConvertManager(final Converter<Double> converter) {
        this.currentConverter = converter;
    }

    /**
     * Setzt den übergebenden Konverter.
     *
     * @param converter
     */
    public void setConverter(final Converter<Double> converter) {
        LOGGER.info("Changed Converter to {}",
                converter.getClass().getSimpleName());
        this.currentConverter = converter;
    }

    /**
     * Konvertiert den gegeben Wert.
     *
     * @param input Inputwert
     * @return Der konvertierte Wert
     */
    public Double convert(final Double input) {
        if (currentConverter == null) {
            LOGGER.error("Tried to convert without a Converter");
            throw new IllegalStateException("No converter selected");
        }
        return currentConverter.convert(input);
    }

}
