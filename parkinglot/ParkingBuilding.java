package parkinglot;

import pricing.CostComputation;

import java.util.List;

public class ParkingBuilding {

    List<ParkingLevel> levels;
    public ParkingBuilding(List<ParkingLevel> levels, CostComputation costComputation)
    {
        this.levels=levels;
    }

}
