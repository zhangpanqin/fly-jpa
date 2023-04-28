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

### CascadeType.REMOVE 和 orphanRemoval

`CascadeType.REMOVE` 是级联删除关联的 entity，当删除 父 entity.

```java
public class UserEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id",name = "userId")
    private Set<BlogEntity> blogs;
}
public class BlogEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String title;

    private Long userId;

    private String content;
}
// 级联删除 BlogEntity
UserJpaRepository.delete(UserEntity)
```

`orphanRemoval` 也可以删除 entity 或者解除关联关系。

```java
UserEntity.blogs.remove(someBlogEntity);
// 设置 `orphanRemoval` 为 true, 删除 remove 的那个 entity,设置为 false ,会更新 BlogEntity 移除关联关系。
UserJpaRepository.update(UserEntity);
```

## BaseEntity
- 建议 @version 不设置默认值，防止保存的时候，误以为是更新操作，触发查询操作。

```java
public abstract class BaseEntity implements Serializable {
  	@Id
    public Long id;

    @Column
    @Version
    private Integer version;
}
```

JPA 保存的时候会判断 `@version` 标记的字段是否是基本数据类型：

- 如果 `@version` 是基本数据类型会判断 `@Id` 是基本数据类型吗，如果是等于 0 说明是新对象，如果不是基本数据类型，会判断是否为 null,  为 null 说明是新对象。
- 如果 `@version` 不是基本数据类型，只会判断 `@version` 是否是 null，是 null 则 entity 是新对象。



综上所述，推荐设置 Id 和 version 为包装类型，且没有默认值。

- 减少条件判断
- null 更容易表意



新对象只会保存。如果不是新对象，会触发根据 id 查询数据是否存在，再判断是否更新。



## 级联操作

### CascadeType.PERSIST

保存 user 的时候级联保存 blog

```java
@Test
void save() {
  var userEntity = buildUserEntity(USER_ID);
  var blogEntity = buildBlogEntity(1L, USER_ID);
  userEntity.setBlogs(Set.of(blogEntity));
  jpaRepository.save(userEntity);
}
```

### CascadeType.MERGE

接触 user 和 blog1 的关系通过 update 语句，在插入一条数据 blog2 数据

```java
@Test
void update() {
  var userEntity = buildUserEntity(USER_ID);
  var blogEntity = buildBlogEntity(1L, USER_ID);
  userEntity.setBlogs(Sets.newLinkedHashSet(blogEntity));
  jpaRepository.save(userEntity);


  var blogEntity2 = buildBlogEntity(2L, USER_ID);
  userEntity.setBlogs(Sets.newLinkedHashSet(blogEntity2));
  System.out.println("1111111111111111111111111111");
  jpaRepository.save(userEntity);
}
```

### CascadeType.REMOVE

当没有软删除的时候，级联删除都是 delete 语句。

当存在软删除的时候：

- update 更新 user 为删除语句
- update 接触 blog 和 user 的关系，而不会删除 blog

```java
@Test
void delete() {
  var userEntity = buildUserEntity(USER_ID);
  var blogEntity = buildBlogEntity(1L, USER_ID);
  var blogEntity2 = buildBlogEntity(2L, USER_ID);
  userEntity.setBlogs(Set.of(blogEntity, blogEntity2));
  jpaRepository.save(userEntity);
  System.out.println("1111111111111111111111111111");
  jpaRepository.deleteById(USER_ID);
}
```



### CascadeType.DETACH

只是解除关联关系而不会删除数据，不管有没有软删除

- delete 语句删除 user，当存在软删除的时候，只是更新 delete_at 的值
- update 接触 blog 和 user 的关系，而不会删除 blog

```java
@Test
void delete() {
  var userEntity = buildUserEntity(USER_ID);
  var blogEntity = buildBlogEntity(1L, USER_ID);
  var blogEntity2 = buildBlogEntity(2L, USER_ID);
  userEntity.setBlogs(Set.of(blogEntity, blogEntity2));
  jpaRepository.save(userEntity);
  System.out.println("1111111111111111111111111111");
  jpaRepository.deleteById(USER_ID);
}
```





### CascadeType.REFRESH

开发不会用，一般是框架内部使用，用于重新从数据库 load 对应的 entity 以及级联 refreshCascadeType.DETACHyd 

```java
@BeforeTransaction
void before() {
  var userEntity = buildUserEntity(USER_ID);
  var blogEntity = buildBlogEntity(1L, USER_ID);
  var blogEntity2 = buildBlogEntity(2L, USER_ID);
  userEntity.setBlogs(Set.of(blogEntity, blogEntity2));
  jpaRepository.save(userEntity);
}
@Test
@Transactional
void refresh() throws InterruptedException {
  var userEntity = jpaRepository.findById(USER_ID).get();
  System.out.println("1111111111111111111111111111");
  entityManager.refresh(userEntity);
  System.out.println(userEntity);
}
```



## 缓存

### 一级缓存(session):内部缓存

事务范围：缓存只能被当前事务访问。缓存的生命周期依赖于事务的生命周期，当事务结束时，缓存也就结束生命周期。



```java
// 清除 session 内 entity 缓存
var session = entityManager.unwrap(Session.class);
session.clear();


entityManager.clear()
```

https://learnjava.co.in/hibernate-caching-explained/

 

### 二级缓存(sessionFactory)：这个不推荐使用



## Dirty Check
