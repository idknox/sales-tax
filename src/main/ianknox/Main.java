package ianknox;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CsvReader newFile = new CsvReader(args[0]);
        List cartItems = newFile.getLineItems();

        Cart newCart = new Cart(cartItems);
        Order testOrder = new Order(newCart);
        testOrder.printReceipt();
    }
}
