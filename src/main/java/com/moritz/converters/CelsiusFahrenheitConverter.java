package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Konvertiert Celcius in Fahrenheit.
 */
public class CelsiusFahrenheitConverter extends Converter<Double> {

  /**
   * Instanz des Loggers.
   */
  private static final Logger LOGGER = LogManager.getLogger(CelsiusFahrenheitConverter.class);

  /**
   * OFFSET.
   */
  private static final int OFFSET = 32;

  /**
   * Zähler.
   */
  private static final int ZAEHLER = 9;

  /**
   * Nenner.
   */
  private static final int NENNER = 5;

  /**
   * Konstruktor der Klasse.
   */
  public CelsiusFahrenheitConverter() {
    LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
  }

  @Override
  public Double convert(final Double input) {
    try {
      Double result = (input * ZAEHLER / NENNER) + OFFSET;
      LOGGER.info("Converted {}° into {}Fahrenheit", input, result);
      return result;
    } catch (Exception e) {
      LOGGER.error("Error during conversion of {} Celsius", input, e);
      return null;
    }
  }
}
