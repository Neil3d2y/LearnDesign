# SOLID principles
1. Single Responsibility Principe
2. Open Close
Open to extension and close to modification
```java
public class AeraCalculator {
    private double res;
    public double getArea() {
        return this.res;
    }

    public void calculateArea(Shape s) {
        this.res = s.getArea();
    }
}

public interface Shape {
    public double getArea();
}

public class Triangle implements Shape {
    public double getArea() {
        return a * b / 2;
    }
}
```

3. Liskov substitution 
4. Interface segregation 
5. Dependency inversion


## Design Pattern
1. Strategy Design Pattern

Elevator Scheduler Design

2. Singleton Design Pattern
Ensure a **class** has only one instance, provide a global point of access to it.

Parking Lots:
> `ParkingLots` 自身就是唯一的instance

```java
public class ParkingLot {
    private static ParkingLot _instance = null;

    private List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (_instance == null) {
            _instance = new ParkingLot();
        }
        return _instance;
    }
}
```

1. `constructor` is *private*
2. 定义 `private static ParkingLot _instanc = null`
3. 定义 `public static ParkingLot getInstance()`
4. `static`: 修饰class的attributes and methods, 使之属于类的而不是类的实例

```diff
!    public static synchronized ParkingLot getInstance() {
!       ...
!    }
```
以上是用Lock实现线程安全的做法
其他做法
> 静态内部类 (*static nested classes*)
```java
public class ParkingLot {
    private ParkingLot(){}

    private static class LazyParkingLot {
        static final ParkingLot _instance = new ParkingLot();
    }

    public static ParkingLot getInstance() {
        return LazyPar5kingLot._instance;
    }
}
```

[为什么需要java内部类](https://juejin.im/post/6844903566293860366)


### Law of Demeter (SOLID 意外第六法则)
Only talk to closly related units
Don't talk to strangers.

```diff
# Bad
-obj.getX().getY().getZ().doSomething();

# Good
+obj.dosomething();
```