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

## 5C
1. Clarify
2. Core Objects
3. Cases
4. Classes
5. Correctness

## Java Mutex + Try Catch
```java
// final keyword:
/*
1. variable -> constant
2. method   -> not override
3. class    -> cannot inheritate
*/
private final Semaphore mutex = new Semaphore(1);

public Object getItem() throws InterrupException {
	try {
		mutex.acquire();
		return getItem();
	}
	catch(Exception e) {
		throws new ArithmeticException("Access Denied");
	}
	finally {
		mutex.release();
	}
}
```

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

3. State Design Pattern (状态机)
> ATM machine, vending machine

```java

interface State {
    /*
    state 中的method是相关于状态与状态改变的方法 take vending machine as example
    1. selectItem
    2. insertCoin
    3. vending
    4. refund
    */
    
    void selectItem();
    void insertCoin();
    Item vending();
    List<Coin> refund();
}

/*
use abstract class to implemets interface
so the other class can extends
*/
abstract class AbstarctState implements State {
    // protected
    protected VendingMachine instance;

    public AbstractState(VendingMachine VM) {
        this.instance = VM;
    }
}

public class NoSelectionState extends AbstractState {
    VendingMachine instance;

    // use super
    public NoSelectionState(VendingMachine VM) {
        super(VM);
    }

    @Override
    public void selectItem(String selection) {
        instance.setSelectedItem(selection);
        instance.changeToHasSelectionState();
    }

    @Override
    public void insertCoin(List<Coins> inputs) {
        throw new NoSelectionException();
    }

    @Override
    public void vending() {
        throw new NoSelectionException(); 
    }

    @Override
    public List<Coins> refund() {
        throw new NoSelectionException(); 
    }
}

public class InsertedCoinState extends AbstractState {
    //...
}

public class VendingMachine {
    State state;

    // Four States as Attributes
    /*
    1. NoSelectionState
    2. InsertedCoinState
    3. VendingState
    4. RefundState
    */
    private NoSelectionState noSelectionState;
    private InsertedCoinState insertedCoinState;
    private VendingState vendingState;
    private RefundSate refundSate;
    private State currentState;

    private VendingMachine() {
        noSelectionState = new NoSelectionSate(this);
        insertedCoinState = new InsertedCoinState(this);
        vendingState = new VendingState(this);
        refundState = new RefundState(this);
        // initial currentState to noSelection
        currentState = noSelectionState;
    }

    // state应该设置为private
    // 但是state的转化设计为public
    public void changeToHasSelectedState() {
        currentState = insertedCoinState;
    }

    public void changeToVendingState() {
        currentState = vendingState;
    }

    public void changeToRefundState() {
        currentState = refundState;
    }

    //重点来了：
    // vending machine的行为应该由当前的state决定

    public void selectItem(String selection) {
        currentState.selectItem(selection);
    }

    public void insertCoins(List<Coins> inputs) {
        currentState.insertCoins(inputs);
    }

    public Item vending() {
        currentState.vending();
    }

    public List<Coins> refund() {
        currentState.refund();
    }
}
```
总结：
索要设计的*系统*拥有不同的*状态*
系统和状态拥有一样的`list of Methods`，系统的行为其实是系统不同时期*状态*的行为
抽象的过程用**`interface`**实现
>所以，interface && system && state 都是一样的template

4. Factory Design Pattern
Kindle 生成不同的电子书格式
```java

interface BookFactory {
    void uploadBook();
}

class PDFFactory implements BookFactory {
    public uploadBook() {
        //...
    }
}

class MOBIFactory implements BookFactory {
    public upload() {
        //...
    }
}
```

Three types Factory design pattern
1. simple factory
2. factory method
3. abstract factory

> Factory 与 Strategy 很相似也一般会用在一起，区别是 Strategy is about behavior. Factory is about creation/instatation.
- Factory is about `behavior`
- Strategy is about `creation` and `instatation`

(Factory vs Strategy)[https://stackoverflow.com/questions/5375187/strategy-design-pattern-and-factory-method-design-pattern]


5. Decorator Design Pattern
参考coffee maker.

#### Law of Demeter (SOLID 意外第六法则)
Only talk to closly related units
Don't talk to strangers.

```diff
# Bad
-obj.getX().getY().getZ().doSomething();

# Good
+obj.dosomething();
```
