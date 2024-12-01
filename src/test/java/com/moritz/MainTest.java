package com.moritz;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.moritz.converters.*;

public class MainTest {
    /**
     * Test that we can succsessfully a converter
     */
    @Test
    public void setConverter(){
        ConvertManager cm = new ConvertManager(null);
        cm.setConverter(new FahrenheitCelsiusConverter());
        assertTrue(cm.getConverter() instanceof FahrenheitCelsiusConverter);
    }

    /**
     * Test that we can't convert any values without setting a converter
     */
    @Test
    public void convertWithoutConverter() {
        ConvertManager cm = new ConvertManager(null);
        assertThrows(IllegalStateException.class, () -> {
          Double result = cm.convert(10.0);
        });
    }


    /**
     * Test that we can convert with a selected converter
     */
    @Test
    public void convertWithConverter(){
      ConvertManager cm = new ConvertManager(null);
      cm.setConverter(new FahrenheitCelsiusConverter());
      assertNotNull(cm.convert(10.0));
    }

    /**
     * Test that FahrenheitCelsiusConverter is working properly
     */
    @Test
    public void testFahrenheitCelsiusConverter(){
      ConvertManager cm = new ConvertManager(null);
      cm.setConverter(new FahrenheitCelsiusConverter());
      assertEquals(cm.convert(120.2), 49.0);
    }

    /**
     * Test that CelsiusFahrenheitConverter is working properly
     */
    @Test
    public void testCelciusToFahrenheitConverter(){
      ConvertManager cm = new ConvertManager(null);
      cm.setConverter(new CelsiusFahrenheitConverter());
      assertEquals(cm.convert(49.0), 120.2);
    }

    /**
     * Test that FootMeterConverter is working properly
     */
    @Test
    public void testFootToMeterConverter(){
      ConvertManager cm = new ConvertManager(null);
      cm.setConverter(new FootMeterConverter());
      assertEquals(cm.convert(49.0), 14.9352);
    }

  }

