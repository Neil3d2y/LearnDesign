package personpkg;

import personpkg.vehiclepkg.Vehicle;

public class Mazda extends Vehicle{
    @Override
    public void start() {
        System.out.println("Started my Mazda..");
    }

    public void fly() throws CarCannotFly {
        throw new CarCannotFly("MDZZ");
    }
}