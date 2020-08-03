# Mock the manager of this system

## Think of nouns in system
Parking Lot
1. Parking lot
2. Cars

## Think of Core object inputs/outputs
- Parking lot
    - Car (in)
    - pot (out)

## Use Case (从管理员角度思考)
1. Reserve 

2. Serve

3. Checkout

## Classes
收据式的信息方式
Library: 静态，
books: 动态 (书的总数可以改变，书的状态可以改变)

所以设计成:

```java

class Book {}

class Lib {
    List<Book> bookCollection;
    ...
}
```

以上的设计有三点不好:
1. Lib 静态 Book 动态，Lib（Lib管理系统）本身是不需要Book信息的
2. 加入了 inversive dependency
3. Coupling

## Cases
根据类思考
1. Bus/Car/Motocycle (把自己想象成为*Core Object*管理员)
则Car不重要，parkinglots是核心类
2. Parkinglots
- Available count
- Park car
- Clear spot
- price

联系Use Case
1. Reservation: X
2. Serve: Park Vehicle, Get count
3. Checkout: clear spot + calculate price