package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Konvertiert Temperaturen von Fahrenheit nach Celsius.
 */
public class FahrenheitCelsiusConverter extends Converter<Double> {

    /**
     * Instanziiere den Logger.
     */
    private static final Logger LOGGER
            = LogManager.getLogger(FahrenheitCelsiusConverter.class);

    /**
     * Offset.
     */
    private static final double OFFSET = 32.0;

    /**
     * Zähler.
     */
    private static final double FAKTOR_ZAEHLER = 5.0;

    /**
     * Nenner.
     */
    private static final double FAKTOR_NENNER = 9.0;

    /**
     * Standardkonstruktor. Protokolliert die Erstellung einer neuen Instanz.
     */
    public FahrenheitCelsiusConverter() {
        LOGGER.info("Neue Instanz von {}", this.getClass().getSimpleName());
    }

    /**
     * Konvertiert eine Temperatur von Fahrenheit nach Celsius.
     *
     * @param input Temperatur in Fahrenheit, die umgerechnet werden soll
     * @return die umgerechnete Temperatur in Celsius oder null bei einem Fehler
     */
    @Override
    public Double convert(final Double input) {
        try {
            // Umrechnung von Fahrenheit in Celsius
            Double ergebnis
                    = (input - OFFSET) * FAKTOR_ZAEHLER / FAKTOR_NENNER;
            LOGGER.info(
                    "{} Fahrenheit wurde zu {}° Celsius konvertiert",
                    input,
                    ergebnis
            );
            return ergebnis;
        } catch (Exception e) {
            // Fehlerbehandlung und Logging bei einer Ausnahme
            LOGGER.error(
                    "Fehler bei der Umrechnung von {} Fahrenheit",
                    input,
                    e
            );
            return null;
        }
    }
}
