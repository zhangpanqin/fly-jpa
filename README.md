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



一方在 `Address` ，没办法查询 User 的时候关联出 Address，除非 User 和 Address 同时设置 `OneToOne`，或者 user 和 address 的 id 用一样的。

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



```shell
curl --location --request GET 'http://localhost:8080/users2'
curl --location --request GET 'http://localhost:8080/users2/1'
```

