package com.demo.dddsample.warehouse;

public interface ShipmentModificationPolicy {
    boolean verify(UpdateShipmentCommand command);
}
