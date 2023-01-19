package com.platzi.javatest.discounts;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void totalZeroWhenThereArePrices() {

        PriceCalculator priceCalculator = new PriceCalculator();

        assertThat(priceCalculator.getTotal(), is(0.0));
    }

    @Test
    public void totalIsTheSumOfPrice() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(10.2);
        priceCalculator.addPrice(15.5);

        assertThat(priceCalculator.getTotal(), is(25.7));
    }

    @Test
    public void applyDiscountToPrices() {
        PriceCalculator priceCalculator = new PriceCalculator();

        priceCalculator.addPrice(100);
        priceCalculator.addPrice(50);
        priceCalculator.addPrice(50);

        priceCalculator.setDiscount(25);

        assertThat(priceCalculator.getTotal(), is(150.0));
    }
}