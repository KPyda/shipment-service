package com.demo.dddsample.warehouse;

import lombok.Value;

@Value
public class UpdateShipmentCommand {
    private final String shipmentId;
    private final String clientId;
}
