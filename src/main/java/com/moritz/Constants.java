package com.moritz;

/**
 * Konstanten zur Steuerung von Konvertern.
 * Checkstyle heult rum, dass die Konstanten in eine
 * eigene Klassen sollen - PMD meckert, dass Sie es nicht sollen  -
 * ja was denn nun?
 */
@SuppressWarnings("PMD.DataClass")
public final class Constants {

  /**
   * Menüoption zum Beenden des Programms.
   */
  public static final int EXIT_PROGRAM = 0;

  /**
   * Menüoption für die Konvertierung von Celsius in Fahrenheit.
   */
  public static final int C_TO_F = 1;

  /**
   * Menüoption für die Konvertierung von Fahrenheit in Celsius.
   */
  public static final int F_TO_C = 2;

  /**
   * Menüoption für die Konvertierung von Meter in Fuß.
   */
  public static final int METER_TO_FOOT = 3;

  /**
   * Menüoption für die Konvertierung von Fuß in Meter.
   */
  public static final int FOOT_TO_METER = 4;

  private Constants() {
      // Verhindert die Instanziierung
  } 
  
  public static int getExitProgram() {
    return EXIT_PROGRAM;
  } 

  
}
