# Spring Boot Protocol Buffers (Protobuf) Demo

A demonstration project showing how to implement Protocol Buffers (Protobuf) serialization in Spring Boot microservices
architecture with a producer-consumer pattern.

## Overview

This project demonstrates:

- Binary serialization using Google Protocol Buffers
- Comparison between JSON and Protobuf serialization
- Microservices communication with multiple serialization formats
- Spring Boot REST API with content negotiation

## Project Structure

The project consists of two Spring Boot microservices:

```
springboot-protobuf/
├── spring-boot-serialization-producer/   # RESTful API producer
└── spring-boot-serialization-consumer/   # Consumer service
```

### Producer Service

- **Port:** 8080
- **Purpose:** Provides RESTful web services that can serialize data in both JSON and Protobuf formats
- **Endpoints:**
    - `GET /order/{totalElement}` - Returns orders in JSON format
    - `GET /proto/order/{totalElement}` - Returns orders in Protobuf format

### Consumer Service

- **Port:** 8081
- **Purpose:** Consumes data from the producer service
- **Endpoints:**
    - `GET /order/{totalElement}` - Fetches and returns JSON data from producer
    - `GET /order/proto/{totalElement}` - Fetches and returns Protobuf data from producer
    - `GET /order/proto/formatted/{totalElement}` - Fetches Protobuf data and converts to JSON

## Technologies Used

- **Spring Boot:** 3.5.6
- **Java:** 17+
- **Protocol Buffers:** 4.32.1
- **Protobuf Compiler (protoc):** 3.21.12
- **Maven:** 3.x
- **Lombok:** For reducing boilerplate code
- **JUnit Jupiter:** 5.x for testing

## Protocol Buffer Definition

The project uses the following Protobuf schema (`order.proto`):

```protobuf
syntax = "proto3";

message Orders {
    repeated Order orders = 1;
}

message Order {
    string orderId = 1;
    Person person = 2;
    repeated Product product = 3;
}

message Person {
    string name = 1;
}

message Product {
    string id = 1;
    int32 priceInCents = 2;
    ProductType productType = 3;

    enum ProductType {
        GIFT = 0;
        COMMON = 1;
    }
}
```

## Prerequisites

- JDK 17 or higher
- Maven 3.x
- curl (for testing endpoints)

## Building the Project

Build both microservices:

```bash
mvn clean install
```

Or build without running tests:

```bash
mvn clean install -DskipTests
```

## Running the Applications

### Start the Producer Service

```bash
cd spring-boot-serialization-producer
mvn spring-boot:run
```

The producer will start on `http://localhost:8080`

### Start the Consumer Service

In a new terminal:

```bash
cd spring-boot-serialization-consumer
mvn spring-boot:run
```

The consumer will start on `http://localhost:8081`

## Testing the Endpoints

### Producer Endpoints

#### Get Orders as JSON

```bash
curl http://localhost:8080/order/5
```

#### Get Orders as Protobuf

```bash
curl -H "Accept: application/x-protobuf" http://localhost:8080/proto/order/5
```

### Consumer Endpoints

#### Get Orders via Consumer (JSON)

```bash
curl http://localhost:8081/order/3
```

#### Get Orders via Consumer (Protobuf)

```bash
curl http://localhost:8081/order/proto/3
```

#### Get Orders (Protobuf formatted as JSON)

```bash
curl http://localhost:8081/order/proto/formatted/3
```

## Performance Benefits

Protocol Buffers offer several advantages over JSON:

1. **Smaller Size:** Binary format is more compact than JSON text
2. **Faster Serialization:** Binary encoding/decoding is faster than JSON parsing
3. **Type Safety:** Strong typing reduces errors
4. **Backward Compatibility:** Schema evolution support
5. **Better Compression:** Binary data compresses better when transmitted over HTTP

## Key Features

- **Content Negotiation:** The producer can return either JSON or Protobuf based on the Accept header
- **Dual Format Support:** Both services demonstrate JSON and Protobuf serialization
- **Performance Monitoring:** Built-in StopWatch logging to measure serialization times
- **Compression:** HTTP compression enabled for optimal bandwidth usage

## Project Configuration

### Maven Plugins

- **protobuf-maven-plugin:** Compiles .proto files into Java classes
- **spring-boot-maven-plugin:** Packages the application as executable JAR
- **os-maven-plugin:** Detects OS and architecture for protoc binary

### Application Properties

**Producer (application.properties):**

```properties
server.compression.enabled=true
server.compression.mime-types=application/json,application/xml,text/html,text/xml,text/plain,application/javascript,text/css
```

**Consumer (application.properties):**

```properties
server.port=8081
app.config.producerProtobufUrl=http://localhost:8080/proto/order/
app.config.producerJsonUrl=http://localhost:8080/order/
```

## Development

### Generated Code

Protocol Buffer classes are automatically generated during compilation into:

- `target/generated-sources/protobuf/java/`

### Mock Data

The producer includes a `MockedDataProducer` class that generates sample order data for testing.

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This is a demo project for educational purposes.

## Contributing

Feel free to submit issues and enhancement requests!

## Version History

- **0.0.1-SNAPSHOT:** Initial release with Protobuf and JSON serialization support

## Additional Notes

- The project uses Spring Boot DevTools for rapid development
- Lombok is configured to reduce boilerplate code
- Tests use JUnit 5 (Jupiter)
- ARM64 (Apple Silicon) compatible with updated protoc version
