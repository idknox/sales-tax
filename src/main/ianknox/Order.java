package ianknox;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<LineItem> cartItems;
    private Double taxTotal;
    private Double orderTotal;

    public Order(List cartItems) {
        this.cartItems = cartItems;
        this.orderTotal = computeOrderTotal();
        this.taxTotal = computeTaxTotal();
    }

    public List<LineItem> getReceiptItems() {
        List output = new ArrayList();

        for (LineItem cartItem : this.cartItems) {
            Double costAfterTax = (double) Math.round((cartItem.getCost() + cartItem.getTaxAmount()) * 100) / 100;

            LineItem receiptItem = new LineItem(cartItem.getName(), cartItem.getCategory(), cartItem.getQuantity(), costAfterTax);
            output.add(receiptItem);
        }
        return output;
    }

    public void printReceipt() {
        for (LineItem receiptItem : getReceiptItems()) {
            System.out.print(receiptItem.getQuantity().toString() + " " + receiptItem.getName() + ": ");
            System.out.print(String.format("%.2f", receiptItem.getCost()) + "\n");
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", this.taxTotal));
        System.out.println("Total: " + String.format("%.2f", this.orderTotal));
    }

    private Double computeOrderTotal() {
        Double total = 0.00;
        for (LineItem receiptItem : getReceiptItems()) {
            total += receiptItem.getCost();
        }
        return (double) Math.round(total * 100) / 100;
    }

    private Double computeTaxTotal() {
        Double total = 0.00;
        for (LineItem cartItem : this.cartItems) {
            total += cartItem.getTaxAmount();
        }
        return (double) Math.round(total * 100) / 100;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }
}