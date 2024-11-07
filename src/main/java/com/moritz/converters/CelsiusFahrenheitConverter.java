package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CelsiusFahrenheitConverter extends Converter<Double> {

    private static final Logger LOGGER = LogManager.getLogger(Converter.class);

    public CelsiusFahrenheitConverter() {
        LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
    }

    @Override
    public Double convert(Double input) {
        Double result = (input * 9 / 5) + 32;
        LOGGER.info("Converted {}° into {}Fahrenheit", input, result);
        return result;
    }
}
