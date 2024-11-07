package com.moritz.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FootMeterConverter extends Converter<Double> {

    private static final Logger LOGGER = LogManager.getLogger(FootMeterConverter.class);

    public FootMeterConverter() {
        LOGGER.info("New instance of {}  ", this.getClass().getSimpleName());
    }

    @Override
    public Double convert(Double input) {
        try {
            Double result = input * 0.3048;
            LOGGER.info("Converted {}Foot into {}Meter", input, result);
            return result;
        } catch (Exception e) {
            LOGGER.error("Error during conversion of {} Foot: {}", input, e);
            return null;
        }

    }

}
