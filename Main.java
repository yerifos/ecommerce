package ecommerce;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(1001);

        order.attach(new PriceObserver());
        order.attach(new QuantityObserver());

        order.addItem(50);
        System.out.println(order);

        order.addItem(75);
        System.out.println(order);

        order.addItem(100);
        System.out.println(order);

        order.addItem(30);
        order.addItem(25);
        order.addItem(60);
        System.out.println(order);
    }
}
