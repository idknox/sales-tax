package ianknox;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CsvReader newFile = new CsvReader(args[0]);
        List cartItems = newFile.getCartItems();

        Order testOrder = new Order(cartItems);
        testOrder.printReceipt();
    }
}
