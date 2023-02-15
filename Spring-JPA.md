# JPA Queries
> One option is to use Spring Data's method derivation, whereby the query is generated from the method name and signature.
1. @Query("SELECT u FROM User u WHERE u.status = 1")
   Collection<User> findAllActiveUsers();

1.2. @Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
Collection<User> findAllActiveUsersNative();

2. Indexed JPQL
   @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
   User findUserByStatusAndName(Integer status, String name);

3. Named Parameters
   @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
   User findUserByStatusAndNameNamedParams(@Param("status") Integer status, @Param("name") String name);

   Spring Data's method derivation
4. find passengers in ascending order by seat number
   List<Passenger> findByOrderBySeatNumberAsc();

5. finds passengers by last name and orders by seat number:
   List<Passenger> findByLastNameOrderBySeatNumberAsc(String lastName);

6. Sorting With a Sort Parameter
   List<Passenger> passengers = repository.findAll(Sort.by(Sort.Direction.ASC, "seatNumber"));

7. Sorting if Pagination
   Page<Passenger> page = repository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "seatNumber")));


# Spring Data JPA Relationship  ref : https://www.youtube.com/watch?v=8qhaDBCJh6I
1. One to Many : one customer can have multiple products like cloths, mobile, laptop etc
    Customer -> Product
- Create Customer Entity
  public class Customer {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String email;
  private String gender;
  @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
  @JoinColumn(name ="cp_fk",referencedColumnName = "id")
  private List<Product> products;
  }

- Create Customer Entity
  public class Product {
  @Id
  private int pid;
  private String productName;
  private int qty;
  private int price;
  }

- @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  public class OrderResponse {

  private String name;
  private String productName;

  public OrderResponse(String name, String productName) {
  this.name = name;
  this.productName = productName;
  }

  private int price;
  }

- JOIN QUERY
  @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
  public List<OrderResponse> getJoinInformation();

- Many-to-Many Relationship
- inside CourseEntity
  @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
  @JsonBackReference
  private Set<Student> students;

- inside StudentEntity
@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "STUDENT_COURSE_TABLE",
joinColumns = {
@JoinColumn(name = "student_id", referencedColumnName = "id")
},
inverseJoinColumns = {
@JoinColumn(name = "course_id", referencedColumnName = "id")
}
)
@JsonManagedReference
private Set<Course> courses;