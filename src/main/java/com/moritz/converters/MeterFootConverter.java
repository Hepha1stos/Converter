package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MeterFootConverter extends Converter<Double> {

    private static final Logger LOGGER = LogManager.getLogger(FootMeterConverter.class);

    public MeterFootConverter() {
        LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
    }

    @Override
    public Double convert(Double input) {
        try {
            Double result = input / 0.3048;
            LOGGER.info("Converted {}Meter into {}Foot", input, result);
            return result;
        } catch (Exception e) {
            LOGGER.error("Error during conversion of {}Meter: {}", input, e);
            return null;
        }
    }

}
