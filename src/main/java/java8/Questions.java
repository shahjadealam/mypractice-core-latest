package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Questions {
  public static void main(String[] args) {
    List<Employee> empList = Arrays.asList(
        new Employee(1, "Samir", 70, 5000),
        new Employee(2, "Kumar", 43, 6000),
        new Employee(3, "Arun", 56, 7000),
        new Employee(4, "Samir", 55, 4000),
        new Employee(5, "Tania", 36, 8000),
        new Employee(6, "Samir", 36, 3500)
    );


    //1. find the employess whos salary is greather then 5000
    //empList.stream().filter(e->e.getSalary()>5000).forEach(System.out::println);

    //2. sort the employess with name
    //empList.stream().sorted(Comparator.comparing(e->e.getName())).forEach(System.out::println);

    //3. sort the employee with name desending order
    //empList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);

    //4. print employee name start with s
    //empList.stream().filter(emp->emp.getName().startsWith("S")).forEach(System.out::println);

    //5. print names of emp
    //empList.stream().map(emp->emp.getName()).forEach(System.out::println);

    //6. count occurrence of name
    /*empList.stream().collect(Collectors.groupingBy(emp->emp.getName(),Collectors.counting()))
        .entrySet().stream().forEach(System.out::println);*/

    //7. find the highest salary
     //Employee employee = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().get();

    //8. find the second highest salary
   // Employee employee = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();

    //9. find the loweset salary
    Employee employee = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).findFirst().get();
    //System.out.println(employee);

    List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    //1. find sum of integers
  //int sum = intList.stream().collect(Collectors.summingInt(n->n.intValue()));

    //2. find sum of even number
    //int sum = intList.stream().filter(n->n%2==0).collect(Collectors.summingInt(Integer::intValue));

    //3 skip first three number and then sum
    //int sum = intList.stream().skip(3).collect(Collectors.summingInt(Integer::intValue));

    //4. skip last three number and sum of remaining
   // int sum = intList.stream().sorted(Collections.reverseOrder()).skip(3).collect(Collectors.summingInt(Integer::intValue));

    //5. find the max number
    //int sum = intList.stream().sorted(Collections.reverseOrder()).findFirst().get();
    //intList.stream().sorted().max(Comparator.comparing(Integer::intValue)).get();
    //intList.stream().min(Comparator.comparing(Integer::intValue)).get();
    //System.out.println(sum);

    String str = "aaabbddsd sdss fefe";
    // find occurance of character
    List<String> strList = Arrays.asList(str.split(""));
    //System.out.println(strList);
    //strList.stream().filter(a->!a.equals(" ")).collect(Collectors.groupingBy(a->a,Collectors.counting())).entrySet().forEach(System.out::println);

  //---------Map Operations-------------
    Map<Integer, String> map = new HashMap<>();
    map.put(1,"a");
    map.put(2,"b");
    map.put(4,"d");
    map.put(3,"c");

    //1. print all the elements
    //map.entrySet().stream().forEach(System.out::println);

    //2. sort map based on key
    //map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

    //3. sort map by value
    //map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

    Map<Employee, String> empMap = new HashMap<>();
    empMap.put(new Employee(1, "Samir", 70, 5000),"a");
    empMap.put(new Employee(2, "Kumar", 43, 6000),"b");
    empMap.put(new Employee(3, "Arun", 56, 7000),"d");
    empMap.put(new Employee(4, "Samir", 55, 4000),"c");

    //1. sort employee base on salary
    empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
  }
}

