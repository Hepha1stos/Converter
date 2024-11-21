package com.moritz;

/**
 * Konstanten zur Steuerung von Konvertern.
 */
public final class Constants {

  private Constants() {
      // Verhindert die Instanziierung
  } 

  /**
   * Menüoption zum Beenden des Programms.
   */
  public static final int EXIT_PROGRAM = 0;

  /**
   * Menüoption für die Konvertierung von Celsius in Fahrenheit.
   */
  public static final int CELSIUS_TO_FAHRENHEIT = 1;

  /**
   * Menüoption für die Konvertierung von Fahrenheit in Celsius.
   */
  public static final int FAHRENHEIT_TO_CELSIUS = 2;

  /**
   * Menüoption für die Konvertierung von Meter in Fuß.
   */
  public static final int METER_TO_FOOT = 3;

  /**
   * Menüoption für die Konvertierung von Fuß in Meter.
   */
  public static final int FOOT_TO_METER = 4;
}
