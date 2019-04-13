package com.demo.dddsample.warehouse;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Value
@AllArgsConstructor(access = PRIVATE)
public class AddShipmentCommand {
    private final String shipmentId;
    private final Integer weight;
    private final ShipmentWay shipmentWay;
    private final String supplier;

    public static AddShipmentCommand from(String shipmentId,
                                          Integer weight,
                                          ShipmentWay shipmentWay, String supplier) {
        return new AddShipmentCommand(shipmentId, weight, shipmentWay, supplier);
    }

    @Value
    static class ShipmentWay {
        private final List<ProductCommand> productCommands;
    }

    @Value
    static class ProductCommand  {
        private final String productId;
        private final String productType;
        private final Integer price;
        private final Integer weight;

        public Product getProduct() {
            return new Product(productId, productType, price, weight);
        }
    }
}
