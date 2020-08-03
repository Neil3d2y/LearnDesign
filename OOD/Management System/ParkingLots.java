public class ParkingLots {
    private static ParkingLot _instance = null;
    // display level info
    private List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    // Singleton Design
    public synchronized static ParkingLot getInstance() {
        if (_instance == null) {
            _instance = new ParkingLot();
        }
        return _instance;
    }

    public int getAvailableCount() {

    }
    // 应该作为辅助函数 被park函数调用 不需要知道可用车位
    private List<Spot> findSpots(Vehicle v) {

    }

    public Ticket parkVehicle(Vehicle v) {

    }
}

class Level {
    // display spots
    private List<Spot> spots;

    public int getAvailableCount() {

    }
}

class Spot {
    private boolean available;

    public boolean isAvailiable() {

    }
    public takeSpot() {

    }
    public leaveSpot() {

    }
}

/*
Ticket
*/

class Ticket {
    private Vehicle v;
    private List<Spot> spots;
}

/*
Vehicle
*/

abstract class Vehicle {
    protected getSize();
}

class Car extends Vehicle {
    @Override
    public getSize() {
        
    }
}

class Bust extends Vehicle {
    @Override
    public getSize() {

    }
}

