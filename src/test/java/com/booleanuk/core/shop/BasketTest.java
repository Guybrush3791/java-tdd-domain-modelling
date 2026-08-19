package com.booleanuk.core.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    private Basket b;

    public BasketTest() {

        b = new Basket();
    }

    @Test
    public void getPrice_twoItems_100() {

        Item i1 = new Item("Keyboard", 70f);
        Item i2 = new Item("Trackbal", 30f);

        b.add(i1);
        b.add(i2);

        float priceTot = b.getPriceTot();

        Assertions.assertEquals(priceTot, 100f);
    }

    @Test
    public void getPrice_negativeItems_illegalArgumentEx() {

        Item i1 = new Item("Keyboard", -70f);

        b.add(i1);

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> b.getPriceTot()
        );
    }

    @Test
    public void getReceipt_4items_validReciept() {

        Item i1 = new Item("Keyboard", 70f);
        Item i2 = new Item("Trackbal", 30f);

        b.add(i1, 3);
        b.add(i2);

        String exRes = """
Keyboard 3x 70.00$
Trackbal 1x 30.00$
---
100.00$
        """.trim();

        String res = b.getReceipt();

        Assertions.assertEquals(exRes, res);
    }
}
