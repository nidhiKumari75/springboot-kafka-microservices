package nidhi.kafka.stock_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class StockServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String orderEvent;

    public String getOrderEvent() {
        return orderEvent;
    }

    public void setOrderEvent(String orderEvent) {
        this.orderEvent = orderEvent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StockServiceEntity{" +
                "id=" + id +
                ", orderEvent='" + orderEvent + '\'' +
                '}';
    }
}
