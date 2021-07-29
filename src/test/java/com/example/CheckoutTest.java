package com.example;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class CheckoutTest 
{
    @Test
    public void calculateCost_singleItem()
    {
        Checkout checkout = new Checkout();
        List<String> items = new ArrayList<>();
        items.add("A");

        HashMap<String, Integer> normalPricing = new HashMap<>();
        normalPricing.put("A", 50);
        normalPricing.put("B", 30);
        normalPricing.put("C", 20);
        normalPricing.put("D", 15);

        HashMap<String, HashMap<Integer, Integer>> specialPricing = new HashMap<>();
        HashMap<Integer, Integer> aSpecialPricing = new HashMap<>();
        aSpecialPricing.put(3, 130);
        HashMap<Integer, Integer> bSpecialPricing = new HashMap<>();
        bSpecialPricing.put(2, 45);
        specialPricing.put("A", aSpecialPricing);
        specialPricing.put("B", bSpecialPricing);

        final Integer expectedCost = 50;

        assertEquals(expectedCost, checkout.calculateCost(items, normalPricing, specialPricing));
    }

    @Test
    public void calculateCost_withoutDiscounts()
    {
        Checkout checkout = new Checkout();
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");


        HashMap<String, Integer> normalPricing = new HashMap<>();
        normalPricing.put("A", 50);
        normalPricing.put("B", 30);
        normalPricing.put("C", 20);
        normalPricing.put("D", 15);

        HashMap<String, HashMap<Integer, Integer>> specialPricing = new HashMap<>();
        HashMap<Integer, Integer> aSpecialPricing = new HashMap<>();
        aSpecialPricing.put(3, 130);
        HashMap<Integer, Integer> bSpecialPricing = new HashMap<>();
        bSpecialPricing.put(2, 45);
        specialPricing.put("A", aSpecialPricing);
        specialPricing.put("B", bSpecialPricing);

        final Integer expectedCost = 50 + 30 + 20 + 15;

        assertEquals(expectedCost, checkout.calculateCost(items, normalPricing, specialPricing));
    }

    @Test
    public void calculateCost_withDiscounts()
    {
        Checkout checkout = new Checkout();
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("A");
        items.add("B");
        items.add("A");
        items.add("A");

        HashMap<String, Integer> normalPricing = new HashMap<>();
        normalPricing.put("A", 50);
        normalPricing.put("B", 30);
        normalPricing.put("C", 20);
        normalPricing.put("D", 15);

        HashMap<String, HashMap<Integer, Integer>> specialPricing = new HashMap<>();
        HashMap<Integer, Integer> aSpecialPricing = new HashMap<>();
        aSpecialPricing.put(3, 130);
        HashMap<Integer, Integer> bSpecialPricing = new HashMap<>();
        bSpecialPricing.put(2, 45);
        specialPricing.put("A", aSpecialPricing);
        specialPricing.put("B", bSpecialPricing);

        final Integer expectedCost = 130 + 50 + 45;

        assertEquals(expectedCost, checkout.calculateCost(items, normalPricing, specialPricing));
    }
}
