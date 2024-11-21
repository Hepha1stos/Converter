package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Klasse um eine einfache Implementierung der Konverter zu gewährleisten.
 */
@SuppressWarnings("PMD.GuardLogStatement")
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
   * @param converter - Konverter.
   */
  public ConvertManager(final Converter<Double> converter) {
    this.currentConverter = converter;
  }

  /**
   * Setzt den übergebenden Konverter.
   *
   * @param converter - der Konverter, der genutzt werden soll.
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
   * 
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
