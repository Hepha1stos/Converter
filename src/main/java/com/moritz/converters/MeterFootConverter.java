package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Konvertiert Meter in imperiale Fuß.
 */
@SuppressWarnings("PMD.GuardLogStatement")
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
    super();
    LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
  }

  /**
   * Konvertiere Meter in Fuß.
   */
  @Override
  public Double convert(final Double input) {
    final Double result;
    try {
      result = input / FOOT;
      LOGGER.info("Converted {}Meter into {}Foot", input, result);
    } catch (NumberFormatException e) {
      LOGGER.error("Error during conversion of {}Meter: {}", input, e);
      throw e;
    }
    return result;
  }
}
