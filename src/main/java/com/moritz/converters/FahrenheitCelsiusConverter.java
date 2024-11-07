package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FahrenheitCelsiusConverter extends Converter<Double> {

    private static final Logger LOGGER = LogManager.getLogger(FahrenheitCelsiusConverter.class);

    public FahrenheitCelsiusConverter() {
        LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
    }

    @Override
    public Double convert(Double input) {
        try {
            Double result = (input - 32) * 5 / 9;
            LOGGER.info("Converted {} Fahrenheit into {}° Celsius", input, result);
            return result;
        } catch (Exception e) {
            LOGGER.error("Error during conversion of {} Fahrenheit", input, e);
            return null;
        }
    }
}
