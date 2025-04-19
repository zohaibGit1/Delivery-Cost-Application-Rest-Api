package com.example.delivery.util;

import java.util.HashMap;
import java.util.Map;

public class CostCalculator {

    public static int calculateMinDeliveryCost(Map<String, Integer> products) {
        Map<String, Integer> itemCounts = new HashMap<>(products);
        int totalCost = 0;

        // Bundle 1: A-1, G-1, H-1, I-3 => 86
        while (itemCounts.getOrDefault("A", 0) >= 1 &&
                itemCounts.getOrDefault("G", 0) >= 1 &&
                itemCounts.getOrDefault("H", 0) >= 1 &&
                itemCounts.getOrDefault("I", 0) >= 3) {

            totalCost += 86;
            itemCounts.put("A", itemCounts.get("A") - 1);
            itemCounts.put("G", itemCounts.get("G") - 1);
            itemCounts.put("H", itemCounts.get("H") - 1);
            itemCounts.put("I", itemCounts.get("I") - 3);
        }

        // Bundle 2: A-1, B-1, C-1, G-1, H-1, I-1 => 118
        while (itemCounts.getOrDefault("A", 0) >= 1 &&
                itemCounts.getOrDefault("B", 0) >= 1 &&
                itemCounts.getOrDefault("C", 0) >= 1 &&
                itemCounts.getOrDefault("G", 0) >= 1 &&
                itemCounts.getOrDefault("H", 0) >= 1 &&
                itemCounts.getOrDefault("I", 0) >= 1) {

            totalCost += 118;
            itemCounts.put("A", itemCounts.get("A") - 1);
            itemCounts.put("B", itemCounts.get("B") - 1);
            itemCounts.put("C", itemCounts.get("C") - 1);
            itemCounts.put("G", itemCounts.get("G") - 1);
            itemCounts.put("H", itemCounts.get("H") - 1);
            itemCounts.put("I", itemCounts.get("I") - 1);
        }

        // Bundle 3: A-1, B-1, C-1 => 78
        while (itemCounts.getOrDefault("A", 0) >= 1 &&
                itemCounts.getOrDefault("B", 0) >= 1 &&
                itemCounts.getOrDefault("C", 0) >= 1) {

            totalCost += 78;
            itemCounts.put("A", itemCounts.get("A") - 1);
            itemCounts.put("B", itemCounts.get("B") - 1);
            itemCounts.put("C", itemCounts.get("C") - 1);
        }

        // Bundle 4: A-1, B-1, C-1, D-1 => 168
        while (itemCounts.getOrDefault("A", 0) >= 1 &&
                itemCounts.getOrDefault("B", 0) >= 1 &&
                itemCounts.getOrDefault("C", 0) >= 1 &&
                itemCounts.getOrDefault("D", 0) >= 1) {

            totalCost += 168;
            itemCounts.put("A", itemCounts.get("A") - 1);
            itemCounts.put("B", itemCounts.get("B") - 1);
            itemCounts.put("C", itemCounts.get("C") - 1);
            itemCounts.put("D", itemCounts.get("D") - 1);
        }


        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            totalCost += entry.getValue() * getDefaultUnitPrice(entry.getKey());
        }

        return totalCost;
    }

    private static int getDefaultUnitPrice(String product) {
        return 0;
    }
}
