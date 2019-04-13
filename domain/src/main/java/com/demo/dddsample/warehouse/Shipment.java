package com.demo.dddsample.warehouse;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@RequiredArgsConstructor
public class Shipment {

    private final String shipmentId;
    private final Integer weight;
    private final List<Product> list;
    private final String supplier;

    @Setter
    private ShipmentModificationPolicy shipmentModificationPolicy;
    @Setter
    private DomainEventSender domainEventSender;

    public static Shipment ofAddShipmentCommand(AddShipmentCommand command) {
        return new Shipment(command.getShipmentId(),
                            command.getWeight(),
                            command.getShipmentWay()
                                   .getProductCommands()
                                   .stream()
                                   .map(AddShipmentCommand.ProductCommand::getProduct)
                                   .collect(Collectors.toList()),
                            command.getSupplier());
    }

    public ShipmentAdded shipmentAdded() {
        return new ShipmentAdded(shipmentId);
    }

    public void updateShipmentDetails(UpdateShipmentCommand command) {
        if (shipmentModificationPolicy.verify(command)) {
            // TODO: 2019-04-13 handling
            domainEventSender.send(new ShipmentUpdatedSuccessfully(shipmentId));
        } else {
            throw new IllegalStateException("You can't touch this!");
        }
    }

    public ShipmentUpdated shipmentUpdated() {
        return new ShipmentUpdated(shipmentId);
    }
}
