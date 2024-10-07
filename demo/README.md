# Kafka, Zookeeper docker install
docker-compose -f kafka-docker-compose.yml up -d

# Docker build
docker build -t kafka:1.0.0 .
