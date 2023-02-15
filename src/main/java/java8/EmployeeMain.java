package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMain {
  public static void main(String[] args) {
    List<Employee> empList = Arrays.asList(
        new Employee(1, "Samir", 70, 5000),
        new Employee(2, "Kumar", 43, 6000),
        new Employee(3, "Arun", 56, 7000),
        new Employee(4, "Samir", 55, 4000),
        new Employee(5, "Tania", 36, 8000),
        new Employee(6, "Samir", 36, 3500)
    );

    //filter
    // find the employee whos salary is greter than 5000
    //empList.stream().filter(e->e.getSalary()>5000).collect(Collectors.toList());
   //empList.stream().filter(e->e.getName().startsWith("S")).forEach(System.out::println);

    //Sorting
   // empList.stream().sorted(Comparator.comparing(e->e.getSalary())).forEach(System.out::println); //based on salary
    //empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println); //based on name
   /* empList.stream().sorted(Comparator.comparing(Employee::getName)).
        collect(Collectors.toList()).stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);*/

    Map<Integer, String> map = new HashMap<>();
    map.put(1,"a");
    map.put(2,"b");
    map.put(3,"d");
    map.put(4,"c");
    //sorting may
   // map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println); // by key
    //map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println); // by value

    // sorting Employee object based on sal
    Map<Employee, String> empMap = new HashMap<>();
    empMap.put(new Employee(1, "Samir", 70, 5000),"a");
    empMap.put(new Employee(2, "Kumar", 43, 6000),"b");
    empMap.put(new Employee(3, "Arun", 56, 7000),"d");
    empMap.put(new Employee(4, "Samir", 55, 4000),"c");
   // empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);//asc
    //empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);//desc
  //--------------------------Map vs FlatMap------------------------------//
  List<Customer> customerList = getAll();
  //map
  customerList.stream().map(customer->customer.getEmail()).forEach(System.out::println);
  List<String> emails = customerList.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());

  //flatmap
    customerList.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).forEach(System.out::println);

  }


  public static List<Customer> getAll() {
    return Stream.of(
        new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
        new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
        new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
        new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
    ).collect(Collectors.toList());
  }
}
