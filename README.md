## Criteria API helper to compose queries using Builder pattern with JPA Static Metamodel

### Initialization

1) Create an instance of ```CriteriaApiHelper``` by providing an instance of EntityManager:
```
...
CriteriaApiHelper criteriaApiHelper = new CriteriaApiHelper(entityManager);
...
```

2) Using Spring:
```
@Configuration
public class CriteriaApiHelperConfiguration {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public CriteriaApiHelper criteriaApiHelper() {
        return new CriteriaApiHelper(entityManager);
    }
}
```

### Usage

1) Select query
```
List<Order> listOfOrders = criteriaApiHelper.select(Order.class)
    .greaterThan(Order_.deliveryDate, LocalDateTime.now())
    .and(Order_.customer, Customer_.address,
        like(Address_.addressLine, "11 Aleksandr Pushkin St"),
        and(Address_.city,
            equal(City_.name, "Tbilisi"),
            equal(City_.country, Country_.name, "Georgia")
        ),
        in(Address_.city, 
            subquery(City.class)
                .isTrue(City_.isCapital)
                .select(),
            subquery(Customer.class)
                .isTrue(Customer_.isVip)
                .select(Customer_.address, Address_.city)
        )
    )
    .findAll();
```

2) Update query
```
int updatedOrders = criteriaApiHelper.update(Order.class)
    .in(Order_.customer, Customer_.id, List.of(1l, 2l, 3l))
    .lessThan(Order_.deliveryDate, LocalDateTime.now())
    .set(Order_.deliveryDate, LocalDateTime.now().plusDays(3))
    .execute();
```

3) Delete query
```
int deletedOrders = criteriaApiHelper.delete(Order.class)
    .in(Order_.customer, Customer_.id, List.of(1l, 2l, 3l))
    .execute();
```