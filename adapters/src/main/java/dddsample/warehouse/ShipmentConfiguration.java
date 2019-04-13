package dddsample.warehouse;

import com.demo.dddsample.warehouse.WarehouseFactory;
import com.demo.dddsample.warehouse.WarehouseRepository;
import com.demo.dddsample.warehouse.WarehouseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ShipmentConfiguration {

    @Bean
    WarehouseService warehouseService(WarehouseRepositorySpringData warehouseRepositorySpringData) {
        return new WarehouseService(warehouseRepository(warehouseRepositorySpringData), warehouseFactory());
    }

    @Bean
    WarehouseFactory warehouseFactory() {
        return new WarehouseFactory();
    }

    @Bean
    WarehouseRepository warehouseRepository(WarehouseRepositorySpringData warehouseRepositorySpringData) {
        return new WarehouseRepositoryImpl(warehouseRepositorySpringData);
    }
}
