# jms-activemq

## Description
This project is broken in two modules: ***producer*** and ***consumer***

The producer will send messages to the ActiveMQ broken, to be ridden to the consumer.

## Running
#### Pre requisite
To run this project, is important that you have a cluster of Apache ActiveMQ running. You can do it with docker:
```sh
docker run -it --rm -p 8161:8161 -p 61616:61616 vromero/activemq-artemis
```

### Now Running...
First, compile your projects:
```sh
make build
```
Than, put you ***consumer*** to listen the Queue:
```sh
make consume
```

After that, you could send the messages with your ***producer***:
```sh
make produce
```
