package com.moritz.converters;

/**
 * Basisklasse der Konverter.
 */
abstract class Converter<T> {

  /**
   * Konstruktor - duh.
   */
  public Converter() {
    super();
  }
  
  /**
 * Konvertierungsmethode.
 * Default-Zugriffsmodifikator wird verwendet.
 */
  protected abstract T convert(T input);

}
