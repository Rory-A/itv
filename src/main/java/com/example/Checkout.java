package com.example;

import java.util.HashMap;
import java.util.List;

public class Checkout {

    public Object calculateCost(List<String> basket, HashMap<String, Integer> normalPricing,
            HashMap<String, HashMap<Integer, Integer>> specialPricing) {

        HashMap<String, Integer> itemOccurences = new HashMap<>();
        Integer totalCost = 0;
        Integer totalDiscount = 0;

        for(String item : basket){
            if(itemOccurences.get(item) != null) {
                itemOccurences.put(item, itemOccurences.get(item) + 1);

                //if there is special pricing for this item && the quantity specified in the special pricing has now been met 
                //e.g this would be true if there are now 3 occurrences of A in the basket, and A has a 3 for 130 special price
                if(specialPricing.containsKey(item) 
                && specialPricing.get(item).get(itemOccurences.get(item)) != null) {
                    totalDiscount += (normalPricing.get(item) * itemOccurences.get(item)) - specialPricing.get(item).get(itemOccurences.get(item));
                    itemOccurences.put(item, 0);
                }
            }
            else {
                itemOccurences.put(item, 1);
            }

            totalCost += normalPricing.get(item);
        }

        return totalCost - totalDiscount;
    }

}
