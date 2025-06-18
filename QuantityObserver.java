package ecommerce;

public class QuantityObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        if (order.getItemCount() > 5) {
            System.out.println("QuantityObserver: Free shipping applied.");
            order.setShippingCost(0);
        } else {
            order.setShippingCost(10);
        }
    }
}

