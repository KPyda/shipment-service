package com.demo.dddsample.warehouse;

public interface WarehouseRepository {
    Shipment save(Shipment createdShipment);

    Shipment load(String shipmentId);
}
