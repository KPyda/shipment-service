package dddsample.warehouse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
class ShipmentEntity {
    @Id
    private String shipmentId;
}
