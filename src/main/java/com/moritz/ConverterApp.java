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
@SuppressWarnings("PMD.SystemPrintln")
public final class ConverterApp {

  private ConverterApp() {
    // prevent instantiation
  }

  /**
   * Der Einstiegspunkt für das Programm.
   *
   * @param args die Befehlszeilenargumente
   */
  public static void main(final String[] args) {
    try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {

      final ConvertManager manager = new ConvertManager(null);
      final CelsiusFahrenheitConverter cTof = new CelsiusFahrenheitConverter();
      final FahrenheitCelsiusConverter fToc = new FahrenheitCelsiusConverter();
      final MeterFootConverter mTof = new MeterFootConverter();
      final FootMeterConverter fTom = new FootMeterConverter();

      while (true) {
        System.out.println("Was möchten Sie konvertieren?");
        System.out.println("1: Celsius in Fahrenheit");
        System.out.println("2: Fahrenheit in Celsius");
        System.out.println("3: Meter in Fuß");
        System.out.println("4: Fuß in Meter");
        System.out.println("0: Das Programm beenden");
        System.out.print("\nAuswahl: ");

        final int selection = scanner.nextInt();
        if (selection == Constants.getExitProgram()) {

          System.out.println("Das Programm wird beendet!");
          break;
        }

        switch (selection) {
          case Constants.C_TO_F:
            manager.setConverter(cTof);
            break;
          case Constants.F_TO_C:
            manager.setConverter(fToc);
            break;
          case Constants.METER_TO_FOOT:
            manager.setConverter(mTof);
            break;
          case Constants.FOOT_TO_METER:
            manager.setConverter(fTom);
            break;
          default:
  
            System.out.println("Ungültige Eingabe: " + selection);
        }
        System.out.print("\nGib den Wert ein, den du konvertieren möchtest: ");
        final Double input = scanner.nextDouble();
        final Double result = manager.convert(input);
        System.out.println("\n Ergebnis: " + result + "\n");
      }
      scanner.close();
    } 
  }
}
