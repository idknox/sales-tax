package ianKnoxSalesTax.main;


import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List cartItems = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line;
            String[][] entries = new String[][]{};
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] entry = line.split(",");
                LineItem item = new LineItem(entry[1], entry[2], Integer.parseInt(entry[0]), Double.parseDouble(entry[3]));
                cartItems.add(item);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        Cart newCart = new Cart(cartItems);
        Order testOrder = new Order(newCart);
        testOrder.printReceipt();
    }
}
