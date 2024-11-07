package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConvertManager {

    private Converter<Double> currentConverter;
    private static final Logger LOGGER = LogManager.getLogger(CelsiusFahrenheitConverter.class);

    public ConvertManager(Converter<Double> converter) {
        this.currentConverter = converter;
    }

    public void setConverter(Converter<Double> converter) {
        LOGGER.info("Changed Converter to {}", converter.getClass().getSimpleName());
        this.currentConverter = converter;
    }

    public Double convert(Double input) {
        if (currentConverter == null) {
            LOGGER.error("Tried to convert without a Converter");
            throw new IllegalStateException("No converter selected");
        }
        return currentConverter.convert(input);
    }

}
