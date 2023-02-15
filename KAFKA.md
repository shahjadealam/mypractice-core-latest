Introduction:
    Apache kafka is an open-source distributed event streaming platform.
- Event Streaming means two thing 1.Create Realtime stream 2.Process Realtime Stream
- for example Paytm which provides n number of transaction. lets say I am booking a flight/movie ticket
but same time this type of booking can be performed by more people in the globe. it means 
in one minute paytm sends millions Stream of data as events which is called Create Realtime Stream.
ref : https://www.youtube.com/watch?v=xGwzuz8F9k0
- example : Postman and Letter Box

# Basic introduction and Spring boot Implementation
ref : https://javatechonline.com/how-to-work-with-apache-kafka-in-spring-boot/
> Start Zookeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

> Start kafka server
.\bin\windows\kafka-server-start.bat .\config\server.properties

> Create topic
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic myKafkaTest

# A topic is stores stream of data. just like tables in database
    A topic contains partitions 
    A partitions have offsets.
    A message produced then it save to topic and inside topic it can be go to any partition randonly
whenever new message will come then offset will be increase by one based on partition.
![img_1.png](../MYPOC/my-application-latest/img_1.png)

# Example with Microservices
https://www.javaguides.net/2022/07/event-driven-microservices-using-spring-boot-and-apache-kafka.html
![img.png](../MYPOC/my-application-latest/img.png)

Implementation is inside kafka folder
    there is one Producer & Consumer for Create Order
    there is one Producer & Consumer for Process Order
    there is one Controller & Processor for commonly used
Flow : when order controller received request then it will pass to CreateOrderProducer and 
it will send that order to input topic then CreateOrderConsumer will consume the order and 
it will call to Processor to change the status from PENDING to SUCCESS and then it will call
to ProcessOrderProducer to send order to another output queue. now ProcessOrderConsumer
will consume the order and it will send to Processor to update the status in map.

there is /status/id api which will return the order status based on order id

#
