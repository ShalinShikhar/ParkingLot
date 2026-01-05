package LookupStratery;

import Entity.ParkingSpot;

import java.util.List;

public interface ParkingLookupStratergy {

    ParkingSpot selectSpot(List<ParkingSpot> spots);

}
