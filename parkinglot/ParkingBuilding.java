package parkinglot;

import Entity.ParkingSpot;
import Entity.Vehicle;
import pricing.CostComputation;

import java.util.List;

public class ParkingBuilding {

    List<ParkingLevel> levels;
    public ParkingBuilding(List<ParkingLevel> levels, CostComputation costComputation)
    {
        this.levels=levels;
    }

    Ticket allocalte(Vehicle vehicle)
    {
        for(ParkingLevel parkingLevel : levels)
        {
            if(parkingLevel.hasAvaibility(vehicle.getVehicleType()))
            {
                ParkingSpot spot=parkingLevel.park(vehicle.getVehicleType());
                if(spot!=null)
                {
                    Ticket ticket=new Ticket(vehicle,parkingLevel,spot);
                    System.out.println("Parking allocated at level : "+parkingLevel.getLevelNumber()+"spot : "+spot.getSpotId());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("parking full");
    }
    void release(Ticket ticket)
    {
        ticket.getlevel().unPark(ticket.getVehicle().getVehicleType(),ticket.getSpot());
    }

}
