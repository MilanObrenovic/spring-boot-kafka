# Spring Boot + Kafka

## Start Docker Compose

```shell
docker compose up -d
```

## Create a topic

```shell
docker exec -it kafka-server kafka-topics --create --topic topic-example --bootstrap-server localhost:9092
```

## Add events to a Kafka topic (producer)

```shell
docker exec -it kafka-server kafka-console-producer --topic topic-example --bootstrap-server localhost:9092
>hello world
>kafka topic event
>demo 1
>demo 2
```

## Read events from a Kafka topic (consumer)

```shell
docker exec -it kafka-server kafka-console-consumer --topic topic-example --from-beginning --bootstrap-server localhost:9092
```
