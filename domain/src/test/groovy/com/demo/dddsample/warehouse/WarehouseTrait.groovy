package com.demo.dddsample.warehouse

trait WarehouseTrait {

    AddShipmentCommand createShipmentCommand(String shipmentId, String productId) {
        final AddShipmentCommand.ProductCommand product = new AddShipmentCommand.ProductCommand(productId, "FOOD", 150, 100)
        AddShipmentCommand.ShipmentWay list = new AddShipmentCommand.ShipmentWay([product])
        AddShipmentCommand.from(shipmentId, 10, list, "VIP")
    }
}