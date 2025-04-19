package com.example.delivery.service;

import com.example.delivery.util.CostCalculator;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeliveryService {

    public int calculateMinCost(Map<String, Integer> products) {
        return CostCalculator.calculateMinDeliveryCost(products);
    }
}
