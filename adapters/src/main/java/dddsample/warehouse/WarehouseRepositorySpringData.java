package dddsample.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

interface WarehouseRepositorySpringData extends JpaRepository<ShipmentEntity, String> {
}
