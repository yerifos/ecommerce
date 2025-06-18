package ecommerce;

public class PriceObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200 && !order.isDiscount()) {
            applyDiscount(order);
        }
    }

    private void applyDiscount(Order order) {
        System.out.println("PriceObserver: Applying $20 discount.");
        double newTotal = order.getTotalPrice() - 20;
        order.setTotalPrice(newTotal);
        order.setDiscount(true);
    }
}
