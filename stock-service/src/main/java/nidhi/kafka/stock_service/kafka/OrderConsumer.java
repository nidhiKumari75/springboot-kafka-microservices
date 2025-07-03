package nidhi.kafka.stock_service.kafka;

import nidhi.kafka.base_domains.dto.OrderEvent;
import nidhi.kafka.stock_service.Repo.StockServiceRepo;
import nidhi.kafka.stock_service.entity.StockServiceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private StockServiceRepo serviceRepo;

    public OrderConsumer(StockServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(OrderEvent event){
        LOGGER.info("order event received in stock service => {}", event.toString());

        //save the order details received
        StockServiceEntity stockServiceEntity = new StockServiceEntity();
        stockServiceEntity.setOrderEvent(event.toString());

        serviceRepo.save(stockServiceEntity);

    }
}
