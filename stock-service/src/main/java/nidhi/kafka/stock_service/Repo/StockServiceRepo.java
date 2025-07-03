package nidhi.kafka.stock_service.Repo;

import nidhi.kafka.stock_service.entity.StockServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockServiceRepo extends JpaRepository<StockServiceEntity, Long> {

}
