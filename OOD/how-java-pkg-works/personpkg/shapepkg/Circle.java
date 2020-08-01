package personpkg.shapepkg;

public class Circle implements Shape{
    
    double r;
    double pi = 3.14;
    
    public Circle(double r) {
        this.r = r;
    }

    public double area() {
        return r * r * pi;
    }

    public void draw() {
        System.out.println("I draw a circle here...");
    }

    public void getArea() {
        System.out.println("The area is " + this.area());
    }

}