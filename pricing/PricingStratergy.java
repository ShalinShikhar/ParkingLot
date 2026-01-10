package pricing;

import parkinglot.Ticket;

public interface PricingStratergy {
    public double calculate(Ticket ticket);
}
