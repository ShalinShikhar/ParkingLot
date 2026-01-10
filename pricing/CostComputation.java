package pricing;

import parkinglot.Ticket;

public class CostComputation {
    private final PricingStratergy pricingStratergy;
    public CostComputation(PricingStratergy pricingStratergy)
    {
        this.pricingStratergy=pricingStratergy;
    }
    public double compute(Ticket ticket) {
        return pricingStratergy.calculate(ticket);
    }
}
