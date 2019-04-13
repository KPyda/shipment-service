package com.demo.dddsample.warehouse;

import org.junit.Test;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class WarehouseServiceTest {

    private WarehouseRepository warehouseRepositoryInMemory = new WarehouseRepositoryInMemory(command -> true);
    private WarehouseFactory warehouseFactory = new WarehouseFactory();
    private final WarehouseService warehouseService = new WarehouseService(warehouseRepositoryInMemory, warehouseFactory);

    @Test
    public void shouldAddShipmentToWarehouse() {
//        given:
        final String productId = UUID.randomUUID()
                                     .toString();
        final AddShipmentCommand.ProductCommand productCommand = new AddShipmentCommand.ProductCommand(productId, "FOOD", 150, 100);
        AddShipmentCommand.ShipmentWay shipmentWay = new AddShipmentCommand.ShipmentWay(Collections.singletonList(productCommand));
        final String shipmentId = UUID.randomUUID()
                                      .toString();
        final AddShipmentCommand command = AddShipmentCommand.from(shipmentId, 10, shipmentWay, "");

//        when:
        final ShipmentAdded shipmentAdded = warehouseService.addShipment(command);

//        then:
        assertThat(shipmentAdded.getShipmentId()).isEqualTo(shipmentId);

    }
}