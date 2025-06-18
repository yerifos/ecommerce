package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private double itemCost;
    private int itemCount;
    private double shippingCost = 10;
    private boolean discount = false;

    private List<OrderObserver> observers = new ArrayList<>();

    public Order(int id) {
        this.id = id;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void addItem(double price) {
        this.itemCost += price;
        this.itemCount += 1;
        System.out.println("Item added: $" + price);
        notifyObservers();
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public double getTotalPrice() {
        return itemCost + shippingCost;
    }

    public int getCount() {
        return itemCount;
    }

    public void setTotalPrice(double price) {
        this.itemCost = price - shippingCost;
    }

    public void setShippingCost(double cost) {
        this.shippingCost = cost;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public boolean isDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Order #" + id +
                " | Items: " + itemCount +
                " | ItemCost: $" + itemCost +
                " | Shipping: $" + shippingCost +
                " | Total: $" + getTotalPrice() +
                " | Discount applied: " + (discount ? "Yes" : "No");
    }
}
