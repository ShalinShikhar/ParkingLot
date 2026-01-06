package spotManagers;

import LookupStratery.ParkingLookupStratergy;

import java.util.List;
import Entity.ParkingSpot;

public class TwoWheelerSpotManager extends ParkingSpotManager{

    public TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingLookupStratergy stratergy)
    {
        super(spots,stratergy);
    }
}
