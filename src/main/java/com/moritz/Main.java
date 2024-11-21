package com.moritz;




import com.moritz.converters.CelsiusFahrenheitConverter;
import com.moritz.converters.ConvertManager;
import com.moritz.converters.FahrenheitCelsiusConverter;
import com.moritz.converters.FootMeterConverter;
import com.moritz.converters.MeterFootConverter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Hauptklasse des Konvertierungsprogramms.
 */
public final class Main {

  private Main() {
      // Leerer Konstruktor
  }

  /**
   * Der Einstiegspunkt für das Programm.
   *
   * @param args die Befehlszeilenargumente
   */
  public static void main(final String[] args) {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    ConvertManager manager = new ConvertManager(null);

    while (true) {
      System.out.println("Was möchten Sie konvertieren?");
      System.out.println("1: Celsius in Fahrenheit");
      System.out.println("2: Fahrenheit in Celsius");
      System.out.println("3: Meter in Fuß");
      System.out.println("4: Fuß in Meter");
      System.out.println("0: Das Programm beenden");

      System.out.print("\nAuswahl: ");
      int selection = scanner.nextInt();

      if (selection == Constants.EXIT_PROGRAM) {
        System.out.println("Das Programm wird beendet!");
        break;
      }

      switch (selection) {
        case Constants.CELSIUS_TO_FAHRENHEIT:
          manager.setConverter(new CelsiusFahrenheitConverter());
          break;
        case Constants.FAHRENHEIT_TO_CELSIUS:
          manager.setConverter(new FahrenheitCelsiusConverter());
          break;
        case Constants.METER_TO_FOOT:
          manager.setConverter(new MeterFootConverter());
          break;
        case Constants.FOOT_TO_METER:
          manager.setConverter(new FootMeterConverter());
          break;
        default:
          System.out.println("Ungültige Eingabe: " + selection);
      }
      System.out.print("\nGib den Wert ein, den du konvertieren möchtest: ");
      Double input = scanner.nextDouble();
      Double result = manager.convert(input);
      System.out.println("\n Ergebnis: " + result + "\n");
    }
    scanner.close();
  }
}
