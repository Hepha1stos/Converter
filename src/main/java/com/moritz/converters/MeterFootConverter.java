package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Konvertiert Meter in imperiale Fuß.
 */
public class MeterFootConverter extends Converter<Double> {

  /**
   * Instanziiere den LOGGER.
   */
  private static final Logger LOGGER
          = LogManager.getLogger(FootMeterConverter.class);

  /**
   * Umrechnungsfaktor von Meter zu Fuß.
   */
  private static final double FOOT = 0.3048;

  /**
   * Konstruktor der Klasse.
   */
  public MeterFootConverter() {
    LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
  }

  /**
   * Konvertiere Meter in Fuß.
   */
  @Override
  public Double convert(final Double input) {
    try {
      Double result = input / FOOT;
      LOGGER.info("Converted {}Meter into {}Foot", input, result);
      return result;
    } catch (Exception e) {
      LOGGER.error("Error during conversion of {}Meter: {}", input, e);
      return null;
    }
  }
}
