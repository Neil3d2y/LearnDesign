/*
Therefore, the members of an interface cannot be private. 
If you try to declare the members of an interface private, a compile time error is generated saying "modifier private not allowed here".

interface methods must all be public

So the implemented class must have interaface defined methods all be public, Otherwise

>> "attempting to assign weaker access privileges; was public"

*/

interface Coffee {
    double getCost();
    String getIngredients();
}

// Decorator Class
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee myCoffee;
    
    // Constructor
    public CoffeeDecorator(Coffee order) {
        myCoffee = order;
    }

    public double getCost() {
        return myCoffee.getCost();
    }

    public String getIngredients() {
        return myCoffee.getIngredients();
    }
}

// basic coffee

class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Expresso, Water";
    }
}

class withMilk extends CoffeeDecorator {
    
    public withMilk(Coffee order) {
        super(order);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }
}

class withSugar extends CoffeeDecorator {
    
    public withSugar(Coffee order) {
        super(order);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Sugar";
    }
}

public class CoffeMaker {
    public static void main(String[] args) {
        Coffee c = new SimpleCoffee();
        c = new withMilk(c);
        logger(c);
        c = new withSugar(c);
        logger(c);
        c = new withMilk(c);
        logger(c);
    }

    private static void logger(Coffee coffee) {
        System.out.println("The price is $" + coffee.getCost() + "\n with ingredients: " + coffee.getIngredients());
    }
}