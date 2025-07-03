# 🚀 Spring Boot Kafka Microservices Project

A microservices-based backend system using **Spring Boot**, **Apache Kafka**, and **MySQL**, designed to manage end-to-end order processing — including placing orders, updating stock, and notifying customers.

---

## 📌 Project Overview

This project demonstrates an asynchronous, event-driven architecture using Kafka for communication between decoupled microservices:

- 📦 **Order Service** – Receives and processes customer orders.
- 🏪 **Stock Service** – Listens to order events and updates inventory.
- ✉️ **Email Service** – Sends confirmation emails upon successful order placement.

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Apache Kafka
- Spring Kafka
- Spring Data JPA
- MySQL
- Spring Mail
- Docker & Docker Compose

---

## 📁 Folder Structure

springboot-kafka-microservices/
│
├── base-domains/                  # Shared Data Transfer Objects (DTOs)
│   └── src/main/java/.../dto/
│
├── order-service/                # Publishes order events to Kafka
│   ├── src/main/java/.../        # Order service code
│   └── src/main/resources/
│       └── application.properties
│
├── stock-service/                # Consumes events and updates stock
│   ├── src/main/java/.../
│   └── src/main/resources/
│       └── application.properties
│
└── email-service/                # Consumes events and sends emails
    ├── src/main/java/.../
    └── src/main/resources/
        └── application.properties

---

## ⚙️ How It Works

1. A customer places an order via the Order Service.
2. Order details are sent to a Kafka topic (`order-topic`).
3. Stock Service and Email Service listen to this topic.
4. Stock Service updates inventory.
5. Email Service sends a confirmation email to the customer.

---

## 📌 How to Run

### Clone the Repository

```bash
git clone https://github.com/nidhiKumari75/springboot-kafka-microservices.git
cd springboot-kafka-microservices
```

### Start with Docker (Recommended)

```bash
docker-compose up --build
```

### Or Run Services Manually

Start MySQL and Kafka manually, then run each service:

```bash
cd order-service
mvn spring-boot:run
```
Repeat for `stock-service` and `email-service`.

---

### 🔧 Configuration

#### 🔹 Kafka (`application.properties`)
properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=order_group
spring.kafka.topic.name=order-topic

#### 🔹 MySQL (`application.properties`)
properties
spring.datasource.url=jdbc:mysql://localhost:3306/order_details
spring.datasource.username=root
spring.datasource.password=yourpassword

#### 🔹 Email (`email-service`)
properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

---

## 📦 API Example

### ➕ Place an Order

**POST** `/api/v1/orders`

json
{
  "name": "mobile",
  "quantity": 3,
  "price": 80000
}
````
