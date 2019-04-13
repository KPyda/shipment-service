package com.demo.dddsample.warehouse;

public class WarehouseFactory {

    public Shipment createShipment(AddShipmentCommand command) {
        // TODO: 2019-04-13 mapping logic can happen here
        return Shipment.ofAddShipmentCommand(command);
    }
}
