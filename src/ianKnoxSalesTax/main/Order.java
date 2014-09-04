package ianKnoxSalesTax.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Cart items;
    private Double taxTotal;
    private Double orderTotal;

    public Order(Cart lineItems) {
        this.items = lineItems;
        this.orderTotal = computeOrderTotal();
        this.taxTotal = computeTaxTotal();
    }

    public Cart getLineItems() {
        return items;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public List<LineItem> getReceiptItems() {
        List output = new ArrayList();

        for (LineItem lineItem : this.items.getCartItems()) {
            lineItem.setCost((double) Math.round((lineItem.getCost() + lineItem.getTaxAmount()) * 100) / 100);
            output.add(lineItem);
        }
        return output;
    }

    public void printReceipt() {
        for (LineItem lineItem : this.items.getCartItems()) {
            System.out.print(lineItem.getQuantity().toString() + " " + lineItem.getName() + ": ");
            System.out.print(String.format("%.2f", lineItem.getCost()) + "\n");
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", this.taxTotal));
        System.out.println("Total: " + String.format("%.2f", this.orderTotal));
    }

    private Double computeOrderTotal() {
        Double total = 0.00;
        for (LineItem lineItem : getReceiptItems()) {
            total += lineItem.getCost();
        }
        return (double) Math.round(total * 100) / 100;
    }

    private Double computeTaxTotal() {
        Double total = 0.00;
        for (LineItem lineItem : this.items.getCartItems()) {
            total += lineItem.getTaxAmount();
        }
        return (double) Math.round(total * 100) / 100;
    }

}