import Entity.ParkingSpot;
import Entity.Vehicle;
import LookupStratery.ParkingLookupStratergy;
import LookupStratery.RandomLookupStrategy;
import enums.VehicleType;
import parkinglot.*;
import payment.CashPayment;
import payment.UPIPayment;
import pricing.CostComputation;
import pricing.FixedPricing;
import spotManagers.FourWheelerSpotManager;
import spotManagers.ParkingSpotManager;
import spotManagers.TwoWheelerSpotManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {

    public static void main(String[] args)
    {
        ParkingLookupStratergy stratergy=new RandomLookupStrategy();
        Map<VehicleType, ParkingSpotManager> levelOneManagers=new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER,new TwoWheelerSpotManager(List.of(new ParkingSpot("L1-S1"),new ParkingSpot("L1-S2")),stratergy));
        levelOneManagers.put(VehicleType.FOUR_WHEELER,new FourWheelerSpotManager(List.of(new ParkingSpot("L1-S3")),stratergy));
        ParkingLevel level1=new ParkingLevel(1,levelOneManagers);

        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();
        levelTwoManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-S1")), stratergy));

        levelTwoManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L2-S2"),
                        new ParkingSpot("L2-S3")), stratergy));


        ParkingLevel level2 = new ParkingLevel(
                2, levelTwoManagers
        );

        ParkingBuilding parkingBuilding =
                new ParkingBuilding(
                        List.of(level1, level2)
                );

        ParkingLot parkingLot = new ParkingLot(
                parkingBuilding,
                new EntranceGate(),
                new ExitGate(new CostComputation(new FixedPricing()))
        );

        Vehicle bike = new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("CAR-201", VehicleType.FOUR_WHEELER);

        Ticket t1 = parkingLot.vehicleArrives(bike);
        Ticket t2 = parkingLot.vehicleArrives(car);

        parkingLot.vehicleExits(t1, new CashPayment());
        parkingLot.vehicleExits(t2, new UPIPayment());






    }
}
