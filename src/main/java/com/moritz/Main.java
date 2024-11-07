package com.moritz;

import java.util.Scanner;

import com.moritz.converters.CelsiusFahrenheitConverter;
import com.moritz.converters.ConvertManager;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConvertManager manager = new ConvertManager(null);

        while (true) {
            System.out.println("Was möchten Sie konvertieren?");
            System.out.println("1: Celsius in Fahrenheit");
            System.out.println("2: Fahrenheit in Celcius");
            System.out.println("3: Meter in Fuß");
            System.out.println("4: Fuß in Meter");
            System.out.println("0: Das Programm beenden");

            int selection = scanner.nextInt();

            if (selection == 0) {
                System.out.println("Das Programm wird beendet!");
                break;
            }

            switch (selection) {
                case 1:
                    manager.setConverter(new CelsiusFahrenheitConverter());
                    break;
            }

            System.out.print("Gib den Wert ein, den du konvertieren möchtest: ");
            Double input = scanner.nextDouble();
            Double result = manager.convert(input);
            System.out.println("Ergebnis: " + result);
        }

    }
}
