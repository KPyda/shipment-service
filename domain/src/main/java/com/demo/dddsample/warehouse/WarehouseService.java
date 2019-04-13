package com.demo.dddsample.warehouse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseFactory warehouseFactory;

    ShipmentAdded addShipment(AddShipmentCommand command) {
        Shipment createdShipment = warehouseFactory.createShipment(command);
        Shipment savedShipment = warehouseRepository.save(createdShipment);
        return savedShipment.shipmentAdded();
    }

    ShipmentUpdated updateShipment(UpdateShipmentCommand command) {
        Shipment shipment = warehouseRepository.load(command.getShipmentId());
        shipment.updateShipmentDetails(command);
        warehouseRepository.save(shipment);
        return shipment.shipmentUpdated();
    }

}
