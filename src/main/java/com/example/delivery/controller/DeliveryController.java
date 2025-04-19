package com.example.delivery.controller;

/*import com.example.delivery.model.DeliveryRequest;
import com.example.delivery.model.DeliveryResponse;*/
import com.example.delivery.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/calculate-delivery-cost")
 /*   @PostMapping("/calculate-delivery-cost")*/
    public ResponseEntity<Integer> calculateDeliveryCost(@RequestBody Map<String, Integer> products) {
        if (products.isEmpty() || products.values().stream().allMatch(qty -> qty == null || qty <= 0)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            int minCost = deliveryService.calculateMinCost(products);
            return ResponseEntity.ok(minCost);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}