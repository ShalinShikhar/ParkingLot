package parkinglot;

import Entity.Vehicle;

public class EntranceGate {

    public Ticket enter(Vehicle vehicle,ParkingBuilding building)
    {
        return building.allocalte(vehicle);
    }
}
