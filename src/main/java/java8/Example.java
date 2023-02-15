package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {
  public static void main(String[] args) {
    List<Integer> intList = Arrays.asList(1,2,3,4,5);

    //Consumer
    intList.stream().forEach(e->System.out.println(e));

    //Predicate
    intList.stream().filter(e->e%2==0).forEach(e->System.out.println(e));

    //Supplier
    System.out.println(intList.stream().findAny().orElseGet(() -> 0));

    //sorting
    System.out.println("_______SORTING___________");
    intList.stream().sorted().forEach(e->System.out.println(e)); //assending
    intList.stream().sorted((o1, o2) -> o1.compareTo(o2)).forEach(e->System.out.println(e));; //assending using comparator

    intList.stream().sorted(Comparator.reverseOrder()).forEach(e->System.out.println(e)); //decending using comparator

    List<String> strList = Arrays.asList("Peter","John","Mark");
    //filter()
    strList.stream().filter(e->e.startsWith("M")).forEach(System.out::print);

    Map<Integer, String> map = new HashMap<>();
    map.put(1,"a");
    map.put(2,"b");
    map.put(3,"c");
    map.put(4,"d");

    //Iterate using foreach
    map.forEach((key, value) -> System.out.println(key+":"+value));
    map.entrySet().stream().forEach(e->System.out.println(e));
    //filter()
    map.entrySet().stream().filter(a->a.getKey()%2==0).forEach(a->System.out.println(a));

  }
}
