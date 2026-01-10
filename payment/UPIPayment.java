package payment;

public class UPIPayment implements payment{
    @Override
    public boolean pay(double amount) {
        System.out.println("UPI paid : "+amount);
        return true;
    }
}
