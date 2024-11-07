package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FahrenheitCelsiusConverter extends Converter<Double> {

    private static final Logger LOGGER = LogManager.getLogger(Converter.class);

    public FahrenheitCelsiusConverter() {
        LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
    }

    @Override
    public Double convert(Double input) {
        Double result = (input - 32) * 5 / 9;
        LOGGER.info("Converted {}Fahrenheit into {}°", input, result);
        return result;
    }
}
