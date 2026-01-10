package payment;

public class CashPayment implements payment{
    @Override
    public boolean pay(double amount) {
        System.out.println("Cash paid : "+amount);
        return true;
    }
}
