package java8;

public class Employee {
    private int id;
    private String name;
    private int age;

    private int salary;

    public Employee(int id, String name, int age, int salary) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.salary = salary;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getAge() { return this.age; }
   public int getSalary() { return this.salary; }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }
}
