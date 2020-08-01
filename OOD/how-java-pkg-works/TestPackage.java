import personpkg.Person;
import personpkg.shapepkg.*;
import personpkg.Mazda;

public class TestPackage {
    public static void main(String[] args) {
        Person newPerson = new Person("Neil", "Zhong");
        System.out.println(newPerson.toString());

        Circle circle = new Circle(2.5);
        circle.getArea();

        Triangle triangle = new Triangle(10, 4);
        triangle.getArea();
        triangle.draw();

        Mazda mycar = new Mazda();
        mycar.start();
    }
}

class Triangle implements Shape {
    double a;
    double b;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void draw() {
        System.out.println("I draw a triangle..");
    }

    public double area() {
        return a * b * 0.5;
    }

    public void getArea() {
        System.out.println("Area of Triangle is " + this.area());
    }
}