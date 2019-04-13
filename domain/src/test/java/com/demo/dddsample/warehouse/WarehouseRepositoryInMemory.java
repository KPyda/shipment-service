package com.demo.dddsample.warehouse;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
class WarehouseRepositoryInMemory implements WarehouseRepository {

    private final HashMap<String, Shipment> database = new HashMap<>();
    private final ShipmentModificationPolicy shipmentModificationTestPolicy;

    @Override
    public Shipment save(Shipment createdShipment) {
        database.put(createdShipment.getShipmentId(), createdShipment);
        return createdShipment;
    }

    @Override
    public Shipment load(String shipmentId) {
        final Shipment shipment = database.get(shipmentId);
        shipment.setShipmentModificationPolicy(shipmentModificationTestPolicy);
        return shipment;
    }
}
