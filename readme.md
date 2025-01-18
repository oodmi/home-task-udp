## Description 
System Design Document
Overview:
There is a warehouse equipped with various types of sensors that monitor environmental
conditions. These sensors provide measurements such as current temperature and
humidity, which are transmitted via UDP. The warehouse service interacts with all these
sensors and automatically publishes the measurements to a central monitoring service. This
service oversees multiple warehouses and activates an alarm if temperature or humidity
readings exceed configured thresholds.
System Design:
Your task is to design a reactive system that includes:
• Warehouse Service: Collects data from various sensors and sends it to the Central
Monitoring Service.
• Central Monitoring Service: Configured with thresholds for temperature and
humidity. Raises an alarm when sensor measurements cross these thresholds. The
alarm message should be visible in the logs/console.
V2.0
Specifications:
• Sensor Types: Temperature, Humidity
• Communication: Measurements are sent via UDP.
• Central Service Features: Threshold monitoring, alarm activation.
Technical Requirements:
• Temperature Sensor:
o UDP Port: 3344
o Measurement Syntax: sensor_id=t1; value=30
o Threshold: 35°C
• Humidity Sensor:
o UDP Port: 3355
o Measurement Syntax: sensor_id=h1; value=40
o Threshold: 50%
Development Expectations:
• No user interactions are required.
• A simple command line/console output is sufficient; no GUI is needed.
• Consider adding test coverage, if possible.
• Sensors can be simulated using any utility capable of sending UDP messages, such as
netcat.
• Usage of message broker is added advantage.
Submission Guidelines:
• You may use Kotlin or Java for implementation.
• You can upload the solution on GitHub and share the link.

## Getting Started

To run the Notes Service API locally, follow these steps:

```shell
# Clone the repository
git clone https://github.com/oodmi/home-task-udp.git

# Change into the project directory
cd home-task-udp

# Start kafka
docker-compose up -d

# Build the application
./gradlew build

# Run central-service
java -jar ./central-service/build/libs/central-service-0.0.1-SNAPSHOT.jar

# Run warehouse-service
java -jar ./warehouse-service/build/libs/warehouse-service-0.0.1-SNAPSHOT.jar

```

```shell
# Send Temperature measurements 
echo "sensor_id=t1; value=30" | nc -u 127.0.0.1 3344

# Send Humidity measurements 
echo "sensor_id=h1; value=40" | nc -u 127.0.0.1 3355
```
