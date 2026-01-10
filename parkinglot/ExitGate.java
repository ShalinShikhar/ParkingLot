package parkinglot;

import payment.payment;
import pricing.CostComputation;

public class ExitGate {
    private final CostComputation costComputation;
    public ExitGate(CostComputation costComputation)
    {
        this.costComputation=costComputation;
    }
    public void completeExit(ParkingBuilding building, Ticket ticket, payment payment) {

            double amount=calculatePrice(ticket);
            boolean success=payment.pay(amount);
            if(!success)
            {
                throw new RuntimeException("Payment Failed. Exit denied");
            }
            building.release(ticket);
            System.out.println("Exit SuccessFull. Gate opened");
    }
    private double calculatePrice(Ticket ticket)
    {
        return costComputation.compute(ticket);
    }
}
