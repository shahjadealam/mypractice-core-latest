Lets say i am writting method to transfer money to another account.
Then i will write a method and inside method there will be nos of line codes.
lets say for business logic i have 15 lines but apart from business logic we need to have
logs releated lines, security releatred lines, transactional releated lines right.
so I need to maintain all these things for each of the method.
as a develooer our focus is to write business logic only but here i need to write all the things in every method.

1.
Account transferMoney(){
-logs
- security releated code
- transcation begiin
  -Business logic 15line
- transaction completed
- logs
  }
- now what i can do I will make a helper class and then i will create methods for logs(), security(), transactions()
and then instead of writting lines of code i will just call the method inside my transfer method right.
- but the still i have to create the instace of Helper class and call the method mannualy.
- so to overcome all this things the AOP concepts comes in the market.
  - using AOP concept even we dont need to call the method, it will call automatically :-)
1.1
Account transferMoney(){
logs()
security()
transactions()
business logic
}

Now what is AOP ?
Aspect Oriented Programming. compliments oops its also provide modularity.
- so the helper class here is called Aspect. will marked as @Aspect
- Aspect: means all the cross-cutting concern like logging,security,transaction will be part of aspect class.
- Advice: means when the methods should be called
- PointCut : when and where you want to call this method
  The role of pointcut will inform to spring aop who will be my actual target, where i am going to implement this peace of code [advice]
- Join point: a point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution

@Around : we annotate the aop method where i need to write the logging logic.
  Also need to tell the method name of pointcut.
@PointCut : Will specify where,on which class,on which method this advice method will be implement.
Example : Centralized Logging ref : github/my-app-latest

ref : https://www.youtube.com/watch?v=RVvKPP5HyaA
code : aop package


## Custom Annotation
https://www.youtube.com/watch?v=P5sAaFY3O2w
