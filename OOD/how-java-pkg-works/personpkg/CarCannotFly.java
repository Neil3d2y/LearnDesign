package personpkg;

public class CarCannotFly extends RuntimeException {
    public CarCannotFly() {}

    public CarCannotFly(final String message) { super(message); }
}
