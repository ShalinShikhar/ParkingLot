package spotManagers;

import Entity.ParkingSpot;
import LookupStratery.ParkingLookupStratergy;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager{

    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkingLookupStratergy stratergy)
    {
        super(spots,stratergy);
    }
}
