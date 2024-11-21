package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Konvertiert imperiale Fuß in metrische Meter.
 */
@SuppressWarnings("PMD.GuardLogStatement")
public class FootMeterConverter extends Converter<Double> {

  /**
   * Instanziiere den LOGGER.
   */
  private static final Logger LOGGER
          = LogManager.getLogger(FootMeterConverter.class);

  /**
   * Umrechnungsfaktor.
   */
  private static final double FOOT = 0.3048;

  /**
   * Konstruktor der Klasse.
   */
  public FootMeterConverter() {
    super();
    LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
  }

  /**
   * Konvertiere Fuß in Meter.
   */
  @Override
  public Double convert(final Double input) {
    final Double result;
    try {
      result = input * FOOT;
      LOGGER.info("Converted {}Foot into {}Meter", input, result);
    } catch (NumberFormatException e) {
      LOGGER.error("Error during conversion of {} Foot: {}", input, e);
      throw e;
    }
    return result;
  }
}
