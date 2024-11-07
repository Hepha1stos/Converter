package com.moritz;

import com.moritz.converters.CelsiusFahrenheitConverter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        CelsiusFahrenheitConverter c = new CelsiusFahrenheitConverter();
        c.convert(100.0);
    }
}
