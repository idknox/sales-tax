package ianknox;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class OrderTest extends TestCase {
    @Test
    public void testOrderExists() {
        Order newOrder = new Order(new ArrayList<LineItem>());
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

        LineItem firstExpectedItem = new LineItem("Book 1", "book", 1, 12.49);
        LineItem secondExpectedItem = new LineItem("CD 1", "music", 1, 16.49);
        LineItem thirdExpectedItem = new LineItem("chocolate", "food", 1, 0.85);

        List expectedReceiptItems = new ArrayList();
        expectedReceiptItems.add(firstExpectedItem);
        expectedReceiptItems.add(secondExpectedItem);
        expectedReceiptItems.add(thirdExpectedItem);

        Order testOrder = new Order(cartItems);

        Double actualOrderTotal = testOrder.getOrderTotal();
        Double actualTaxTotal = testOrder.getTaxTotal();
        List actualReceiptItems = testOrder.getReceiptItems();

        assertEquals(expectedReceiptItems, actualReceiptItems);
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

        LineItem firstExpectedItem = new LineItem("imported box of chocolates", "food", 1, 10.50);
        LineItem secondExpectedItem = new LineItem("imported bottle of perfume", "cosmetics", 1, 54.65);

        List expectedReceiptItems = new ArrayList();
        expectedReceiptItems.add(firstExpectedItem);
        expectedReceiptItems.add(secondExpectedItem);

        Order testOrder = new Order(cartItems);

        Double actualOrderTotal = testOrder.getOrderTotal();
        Double actualTaxTotal = testOrder.getTaxTotal();
        List actualReceiptItems = testOrder.getReceiptItems();

        assertEquals(expectedReceiptItems, actualReceiptItems);
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


        LineItem firstExpectedItem = new LineItem("imported bottle of perfume", "cosmetics", 1, 32.19);
        LineItem secondExpectedItem = new LineItem("bottle of perfume", "cosmetics", 1, 20.89);
        LineItem thirdExpectedItem = new LineItem("packet of headache pills", "medical", 1, 9.75);
        LineItem fourthExpectedItem = new LineItem("imported chocolates", "food", 1, 11.85);

        List expectedReceiptItems = new ArrayList();
        expectedReceiptItems.add(firstExpectedItem);
        expectedReceiptItems.add(secondExpectedItem);
        expectedReceiptItems.add(thirdExpectedItem);
        expectedReceiptItems.add(fourthExpectedItem);

        Order testOrder = new Order(cartItems);

        Double actualOrderTotal = testOrder.getOrderTotal();
        Double actualTaxTotal = testOrder.getTaxTotal();
        List actualReceiptItems = testOrder.getReceiptItems();

        assertEquals(expectedReceiptItems, actualReceiptItems);
        assertEquals(6.70, actualTaxTotal);
        assertEquals(74.68, actualOrderTotal);
    }
}