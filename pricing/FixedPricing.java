package pricing;

import parkinglot.Ticket;

public class FixedPricing implements PricingStratergy{
    @Override
    public double calculate(Ticket ticket) {
            return 100;
    }
}
