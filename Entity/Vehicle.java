package Entity;

import enums.VehicleType;

public class Vehicle {

    String vehicleNumber;
    VehicleType vehicleType;

    public VehicleType getVehicleType() {
        return vehicleType;
    }



    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Vehicle(String vehicleNumber,VehicleType vehicleType)
    {
        this.vehicleNumber=vehicleNumber;
        this.vehicleType=vehicleType;
    }
}
