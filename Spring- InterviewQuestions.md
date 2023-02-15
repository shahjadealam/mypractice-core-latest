#1 Microservices Cross Cutting Concern
    1. Security : To secure the API with Authentication & Authorization. like OAuth, Spring Security, API Gateway
    - Advantages of API Gateway : single entry point, attach & Malicius prevented, whitelists
    2. Configuration Management
    3. Logging & Monitoring
    4. Cashing
    5. Exception Handling
    6. Communication

#2. Transaction Management @Transactional
https://www.youtube.com/watch?v=95kxPSbHzVg

#3 How to resolve cicrcular dependancy
    use @Lazy or Setter Injection

4. How to create immutable class with Date field
   public final class ImmutableReminder{
   private final Date remindingDate;
   public ImmutableReminder (Date remindingDate) {
   this.remindingDate = new Date(remindingDate.getTime());
   }
   public Date getRemindingDate() {
   return (Date) remindingDate.clone();
   }
   }

5. communication in microservices
   - Two way to communicate.
   1. Synchronous Communication (Blocking)
       - Rest Template is a syncronous client. in future it will deprecate, as spring suggested to use webclient instead.
       - Feign Client is a synchronus (Blocking Client)
       - Web Client is a  asynchronouse (Non blocking client)
   2. Asynchronous communication (Non Blocking)
      - Messaging Queue like Rabbit MQ
ref : https://medium.com/design-microservices-architecture-with-patterns/microservices-communications-f319f8d76b71
      
6. Microservice Design Pattern SAGA
what is Distributed Transaction ?
    In micro service architecture there is multiple service running independenly with having their own database.
and each of the service must needs to manage the transaction, basically they must need to follow the ACID property.
TO managing transations in all of the services and applying ACID colaborately is very big problem.
so to solve this distributed problem SAGA pattern is designed.
SAGA Design pattern is solve the distributed transaction problem.
- in SAGA pattern distributed transaction is managed through localised transaction in the micro services.
so it means each micro service manage their own transaction but the question is how the distributed transaction will manage ?
- The solution is to keeping all of the transactions and based on requirement if any one is getting failed what action should be taken.
- example Order service, Product Service, Email Service and Email service is failed in this case what should be the state of transaction.
in term of saga it should rolledback.
    There are 3 types of transaction
    1. Potentially be reversed  called compansable transaction
    2. in this either all of the transaction will rolled back or one of the transaction will not like email
    3. Retry pattern in this it will retry the invocation and most of time it get succeed.
Implementation of Transaction : there are two types of SAGA
       1. Choreography Patten : It is based on Event. which is message Queue like kafka,RabbitMQ
       so there is no http calls.
       lets say there is two service one is Order is another is Payment.
       when any request comes to order service it will produce that request on Queue(Order-event) and Payment service will consume
       that Queue. and then payment service will process that request lets say validate the balance and then it will produce
       response on another Queue(Payement-event) and then Order service will consume this response.
       all this will.
       Basically it is based on Producer/Consumer pattern
       2. Orchestration Pattern : Centralised condinator for all
so Distributed transaction used Two-Phase Commit (2PC) Protocol.
ref: https://www.youtube.com/watch?v=Z4Ug7NL2VAk

8. how do you handle failure of distributed microservices ?
    We need to implement circuit breaker pattern. 
   1. Hystrix
   2. Resiliecy4j
ref : https://www.youtube.com/watch?v=37B8ovdX3Eo
   
9. How to secure your API ?
    By Spring security . there are two-way one is to extend WebSecurityConfigureAdapter in my own config class
    and override the overloaded configure method .
      second is to create beans of the methods.
ref : https://www.youtube.com/watch?v=WorfSfWEyvs

10. What is CompletableFuture and its uses ?
    It is used to perform asynchronous computations.
Asynchronous means non-blocking operation. that is in multi-threading.
let's say I have created thread of 10 using ExecutorService and implemented Callable and then submit to Executor.
so when task will submit it will return a placeholder of type Future and until task is completed then you will get the actual
output after calling the get() method. and get method is blocking operation.
Example : lets say we have a order flow and there are methods of each like CreateOrder(), MakePayment(), CreateDelivery(), sendEmail()
so in this case if I am assigning threads on each of the methods then I have to write like first submit of task createOrdder()
then get the value with the help of get() method then again I will submit task for makePayment() and then get() method an so on..
but here we can see whenever we are calling get() method, so potentially it's blocking to main thread. and its bother to 
main thread ideally it should not.
- to solve this CompletableFuture comes and now with the help of this feature even we don't need to call get method not care about threadpoll
not bother to main method . we can just call the async method of Future method and passing the chaining methods.
- let say we have 100 orders and then apply the same concept.
for(int i=0;i<100;i++){
CompletableFuture.supplyAsync(()-> getOrder())
  .thenApply(order -> makePayment(order))
  .thenApply(order -> makeDelivery(order))
  .thenApply(order -> sendEmail());
- }
# What is CORS 
In Spring boot we have cors which stands for Cross-Origin Resource Sharing, 
it basically means that the host which is representing the UI, and the host which serves the data both are different. 
Means both are running on a different host, in such type of cases we may encounter this problem which running the application. 
Let’s say we have one application in angular which runs on a different host, and the backend is in spring boot which runs on a different host,
so while making any request for data to the backend we may encounter this error in the console. It is a very common and very well-known term in spring boot. 
Spring boot provides us good support to configure this.
1) Use @CrossOrigin at method level
   @CrossOrigin
   @RequestMapping(method = RequestMethod.GET)
2) Use @CrossOrigin at the controller level:
     @CrossOrigin(origins = "your host", maxAge = 3600)
     @RestController
3. Global CORS Configuration
   @Configuration
   @EnableWebMvc
   public class WebConfig implements WebMvcConfigurer {

   @Override
   public void addCorsMappings(CorsRegistry registry) {
   registry.addMapping("/**");
   }
   }
