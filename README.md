## 一对一

### Users 和 Address
Users:
- username
- address_id

Address

- city



一方在 `UsersEntity` 可以直接查询出 `Address`

```java
public class UsersEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String username;

    @Column
    private Long addressId;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AddressEntity address;
}
```




```shell
curl --location --request GET 'http://localhost:8080/users'
curl --location --request GET 'http://localhost:8080/users/1'
```



### Users2 和 Address2

Users:

- username

Address

- city
- users_id



一方在 `Address` ，想查询 User 的时候关联出 Address，有三种方案。
- 双向 oneToOne

```java
public class UsersTwoEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String username;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id", nullable = false)
    private AddressTwoEntity address;
}
public class AddressTwoEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String city;

    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UsersTwoEntity usersTwo;
}
```
- user 和 address 设置一样的主键 id
只需要单方面在 user 设置join column
```java
public class UsersTwoEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String username;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id", nullable = false)
    private AddressTwoEntity address;
}
```

- 仅仅只需要单方面使用 manyToOne 在 user
```java
public class UsersTwoEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String username;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id", updatable = false, insertable = false)
    private AddressTwoEntity addressTwo;
}
```


```shell
curl --location --request GET 'http://localhost:8080/users2'
curl --location --request GET 'http://localhost:8080/users2/100'
```

