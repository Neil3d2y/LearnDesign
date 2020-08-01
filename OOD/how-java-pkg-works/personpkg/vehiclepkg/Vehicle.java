package personpkg.vehiclepkg;

abstract public class Vehicle {
    protected void checkEgine() {
        System.out.println("I am good...");
    }

    abstract public void start();
}