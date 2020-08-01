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

