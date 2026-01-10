package parkinglot;

import Entity.Vehicle;
import payment.payment;

public class ParkingLot {

    private final ParkingBuilding building;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;
    public ParkingLot(ParkingBuilding building, EntranceGate entranceGate, ExitGate exitGate) {
        this.building = building;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
    }
    public Ticket vehicleArrives(Vehicle vehicle)
    {
        return entranceGate.enter(vehicle,building);
    }
    public void vehicleExits(Ticket ticket, payment payment)
    {
        exitGate.completeExit(building,ticket,payment);
    }



}
