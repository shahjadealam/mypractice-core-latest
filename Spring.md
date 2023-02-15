---------------reference---------
for Spring boot/Java concept : https://www.javainuse.com/messaging/rabbitmq
for video tutorials: https://javatechonline.com/

## Configure multiple databse in Spring boot Application
	https://www.youtube.com/watch?v=iDogrHEo4x0

## Docker
Docker is a centralized platform for packaging, deploying, and running applications.
Docker is containerization which we use to deploy our application.
but what if we want to scale the application. want to deploy multiple instance of application.
for this we use kubernetes
- We use becasue docker image can be run on any of the OS. so no dependent on JDK version

## Kubernetes
Its a tool which use to deploy docker images on server easily
deplyement become easy
scalablity easy : can have multiple pods/nods to scale and availablity of the app
monitioring : provide inbuild feature like see logs and see cpu usage etc

## SAGA Design Pattern Micro-services
1) Choreography based: Having Queue with independent queue input/output for each services

2) Orchestration basee : Having centralized command server
   each service intracted with command names

reference : https://www.youtube.com/watch?v=WnZ7IcaN_JA
https://javatechonline.com/microservices-tutorial/

## Micro-services
- Best Practice : https://dzone.com/articles/7-microservices-best-practices-for-developers

## Put vs post mapping in Rest API
Read difference part only
https://www.geeksforgeeks.org/diffrence-between-put-and-post-http-requests/

## Spring Boot Annotations
-> @Bean
- It is used to explicitly declare a single bean, rather than letting Spring do it automatically.
- We should use @Bean, if you want specific implementation based on dynamic condition
- It is a method level annotation
- tells Spring 'here is an instance of this class, please keep hold of it and give it back to me when I ask'.

-> @Autowired says 'please give me an instance of this class, for example, one that I created with an @Bean/@Component annotation
earlier'.

-> @Component
- If any class is annotated with @Component it will be automatically detect by using classpath scan.
- It is a class level annotation
