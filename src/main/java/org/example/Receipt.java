package org.example;

import java.util.ArrayList;

public class Receipt {
    private ArrayList<OrderItem> orderItems;

    public Receipt() {
        orderItems = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("\n========== Nota Pemesanan ==========");
        for (OrderItem item : orderItems) {
            System.out.printf("%-20s x%d - Rp %.2f\n", item.getItemName(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.println("------------------------------------");
        System.out.printf("Total: Rp %.2f\n", calculateTotal());
        System.out.println("====================================\n");
    }
}
