package ianknox;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class OrderTest extends TestCase {
    @Test
    public void testReceiptExists() {
        Order newOrder = new Order(new Cart(new ArrayList<LineItem>()));
    }

    @Test
    public void testReceiptTotalsBasicItems() {

        LineItem firstItem = new LineItem("Book 1", "book", 1, 12.49);
        LineItem secondItem = new LineItem("CD 1", "music", 1, 14.99);
        LineItem thirdItem = new LineItem("chocolate", "food", 1, 0.85);

        List cartItems = new ArrayList();
        cartItems.add(firstItem);
        cartItems.add(secondItem);
        cartItems.add(thirdItem);

        Cart newCart = new Cart(cartItems);

        LineItem firstOrderItem = new LineItem("Book 1", "book", 1, 12.49);
        LineItem secondOrderItem = new LineItem("CD 1", "music", 1, 16.49);
        LineItem thirdOrderItem = new LineItem("chocolate", "food", 1, 0.85);

        List output = new ArrayList();
        output.add(firstOrderItem);
        output.add(secondOrderItem);
        output.add(thirdOrderItem);

        Order testOrder = new Order(newCart);

        Double actualOrderTotal = testOrder.getOrderTotal();
        Double actualTaxTotal = testOrder.getTaxTotal();

        assertEquals(1.50, actualTaxTotal);
        assertEquals(29.83, actualOrderTotal);
    }

    @Test
    public void testReceiptTotalsImportedItems() {

        LineItem firstItem = new LineItem("imported box of chocolates", "food", 1, 10.00);
        LineItem secondItem = new LineItem("imported bottle of perfume", "cosmetics", 1, 47.50);

        List cartItems = new ArrayList();
        cartItems.add(firstItem);
        cartItems.add(secondItem);

        Cart newCart = new Cart(cartItems);

        LineItem firstExpectedItem = new LineItem("imported box of chocolates", "food", 1, 10.50);
        LineItem secondExpectedItem = new LineItem("imported bottle of perfume", "cosmetics", 1, 54.65);

        List output = new ArrayList();
        output.add(firstExpectedItem);
        output.add(secondExpectedItem);

        Order testOrder = new Order(newCart);

        Double actualOrderTotal = testOrder.getOrderTotal();
        Double actualTaxTotal = testOrder.getTaxTotal();

        assertEquals(7.65, actualTaxTotal);
        assertEquals(65.15, actualOrderTotal);
    }

    @Test
    public void testReceiptTotalsImportedAndOtherTaxedItems() {

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

        LineItem firstExpectedItem = new LineItem("imported bottle of perfume", "cosmetics", 1, 32.19);
        LineItem secondExpectedItem = new LineItem("bottle of perfume", "cosmetics", 1, 20.89);
        LineItem thirdExpectedItem = new LineItem("packet of headache pills", "medical", 1, 9.75);
        LineItem fourthExpectedItem = new LineItem("imported chocolates", "food", 1, 11.85);

        List output = new ArrayList();
        output.add(firstExpectedItem);
        output.add(secondExpectedItem);
        output.add(thirdExpectedItem);
        output.add(fourthExpectedItem);


        Double actualOrderTotal = testOrder.getOrderTotal();
        Double actualTaxTotal = testOrder.getTaxTotal();

        assertEquals(6.70, actualTaxTotal);
        assertEquals(74.68, actualOrderTotal);
    }
}