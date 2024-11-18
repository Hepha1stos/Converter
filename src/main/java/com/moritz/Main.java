package com.moritz;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;


import com.moritz.converters.CelsiusFahrenheitConverter;
import com.moritz.converters.ConvertManager;
import com.moritz.converters.FahrenheitCelsiusConverter;
import com.moritz.converters.FootMeterConverter;
import com.moritz.converters.MeterFootConverter;

/**
 * Hauptklasse des Konvertierungsprogramms.
 */
public final class Main {

    /**
     * Menüoption zum Beenden des Programms.
     */
    private static final int EXIT_PROGRAM = 0;

    /**
     * Menüoption für die Konvertierung von Celsius in Fahrenheit.
     */
    private static final int CELSIUS_TO_FAHRENHEIT = 1;

    /**
     * Menüoption für die Konvertierung von Fahrenheit in Celsius.
     */
    private static final int FAHRENHEIT_TO_CELSIUS = 2;

    /**
     * Menüoption für die Konvertierung von Meter in Fuß.
     */
    private static final int METER_TO_FOOT = 3;

    /**
     * Menüoption für die Konvertierung von Fuß in Meter.
     */
    private static final int FOOT_TO_METER = 4;

    private Main() {
        // Utility-Klasse, Konstruktor versteckt
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

            if (selection == EXIT_PROGRAM) {
                System.out.println("Das Programm wird beendet!");
                break;
            }

            switch (selection) {
                case CELSIUS_TO_FAHRENHEIT:
                    manager.setConverter(new CelsiusFahrenheitConverter());
                    break;
                case FAHRENHEIT_TO_CELSIUS:
                    manager.setConverter(new FahrenheitCelsiusConverter());
                    break;
                case METER_TO_FOOT:
                    manager.setConverter(new MeterFootConverter());
                    break;
                case FOOT_TO_METER:
                    manager.setConverter(new FootMeterConverter());
                    break;
                default:
                    System.out.println("Ungültige Eingabe: " + selection);
            }

            System.out.print(
                    "\nGib den Wert ein, den du konvertieren möchtest: "
            );
            Double input = scanner.nextDouble();
            Double result = manager.convert(input);
            System.out.println("\n Ergebnis: " + result + "\n");
        }
    }
}
