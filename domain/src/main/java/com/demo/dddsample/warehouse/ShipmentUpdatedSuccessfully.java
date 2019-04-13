package com.demo.dddsample.warehouse;

import lombok.Value;

@Value
class ShipmentUpdatedSuccessfully implements DomainEvent {
    private final String shipmentId;
}
