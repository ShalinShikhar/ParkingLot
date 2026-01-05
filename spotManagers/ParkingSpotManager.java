package spotManagers;
import Entity.ParkingSpot;
import LookupStratery.ParkingLookupStratergy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {
    List<ParkingSpot> spots;
    ParkingLookupStratergy stratergy;
    private final ReentrantLock lock = new ReentrantLock(true);

    protected ParkingSpotManager(List<ParkingSpot> spots,ParkingLookupStratergy stratergy)
    {
        this.spots=spots;
        this.stratergy=stratergy;
    }
    public ParkingSpot park()
    {
        lock.lock();
        try{
            ParkingSpot spot=stratergy.selectSpot(spots);
            if(spot==null)
            {
                return null;
            }
            spot.occupySpot();
            return spot;
        }
        finally {
            lock.unlock();
        }

    }
    public void unPark(ParkingSpot spot)
    {
        lock.lock();
        try{
            spot.releaseSpot();
        }
        finally {
            lock.unlock();
        }
    }
    public boolean hasFreeSpot()
    {
        lock.lock();
        try{
            return spots.stream().anyMatch(ParkingSpot::isSpotFree);
        }
        finally {
            lock.unlock();
        }
    }

}
