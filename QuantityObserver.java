package ecommerce;

public class QuantityObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        shippingCost(order);
    }

    public void shippingCost(Order order) {
        if (order.getCount() > 5) {
            System.out.println("QuantityObserver: Free shipping applied.");
            order.setShippingCost(0);
        } else {
            order.setShippingCost(10);
        }
    }
}
