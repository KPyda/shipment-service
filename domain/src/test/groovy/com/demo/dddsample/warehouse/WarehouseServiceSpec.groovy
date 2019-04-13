package com.demo.dddsample.warehouse


import spock.lang.Specification
import spock.lang.Unroll

class WarehouseServiceSpec extends Specification implements WarehouseTrait {

    def warehouseRepositoryInMemory = new WarehouseRepositoryInMemory(new ShipmentModificationPolicy() {
        @Override
        boolean verify(UpdateShipmentCommand command) {
            return true
        }
    })
    def warehouseFactory = new WarehouseFactory()
    def warehouse = new WarehouseService(warehouseRepositoryInMemory, warehouseFactory)

    @Unroll
    def 'should add shipment: #shipmentId to warehouse'() {
        given:
        final AddShipmentCommand command = createShipmentCommand(shipmentId, productId)

        when:
        final ShipmentAdded shipmentAdded = warehouse.addShipment(command)

        then:
        shipmentAdded.getShipmentId() == shipmentId

        where:
        productId | shipmentId || expectedShipmentId
        "1"       | "2"        || "2"
        "1"       | "31"       || "31"
    }


    def 'should load and update shipment'() {
        given:
        def shipmentId = "1"
        warehouseRepositoryInMemory.save(Shipment.ofAddShipmentCommand(createShipmentCommand(shipmentId, "2")))
        def command = new UpdateShipmentCommand(shipmentId, "2")

        when:
        def shipmentUpdated = warehouse.updateShipment(command)

        then:
        shipmentUpdated.getShipmentId() == shipmentId
        noExceptionThrown()
    }

}
