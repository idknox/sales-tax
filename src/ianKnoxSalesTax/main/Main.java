package ianKnoxSalesTax.main;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LineItem firstItem = new LineItem("imported bottle of perfume", "cosmetics", 1, 27.99);
        LineItem secondItem = new LineItem("bottle of perfume", "cosmetics", 1, 18.99);
        LineItem thirdItem = new LineItem("packet of headache pills", "medical", 1, 9.75);
        LineItem fourthItem = new LineItem("imported chocolates", "food", 1, 11.25);

        List cartItems = new ArrayList();
        cartItems.add(firstItem);
        cartItems.add(secondItem);
        cartItems.add(thirdItem);
        cartItems.add(fourthItem);

        Cart newCart = new Cart(cartItems);
        Order testOrder = new Order(newCart);
        testOrder.printReceipt();
    }

}
