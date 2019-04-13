package dddsample.warehouse;

import com.demo.dddsample.warehouse.Shipment;
import com.demo.dddsample.warehouse.WarehouseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class WarehouseRepositoryImpl implements WarehouseRepository {

    private final WarehouseRepositorySpringData warehouseRepositorySpringData;

    @Override
    public Shipment save(Shipment createdShipment) {
        // TODO: 2019-04-13 mapping from domain object to entities
        return null;
    }

    @Override
    public Shipment load(String shipmentId) {
        // TODO: 2019-04-13 mapping from domain object to entities
        return null;
    }
}
