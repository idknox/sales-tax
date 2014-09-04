package ianKnoxSalesTax.test;

import ianKnoxSalesTax.main.LineItem;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class LineItemTest extends TestCase {
    LineItem testItem;
    @Before
    void createLineItem() {
        testItem =  new LineItem("testName", "testCategory", 1, 0.00);
    }

    @Test
    public void testName() {
        System.out.println(testItem.getName());
        assertEquals("testName", testItem.getName());
    }

    public void testSetName() throws Exception {

    }

    public void testGetCategory() throws Exception {

    }

    public void testSetCategory() throws Exception {

    }

    public void testGetQuantity() throws Exception {

    }

    public void testSetQuantity() throws Exception {

    }

    public void testGetCostBeforeTax() throws Exception {

    }

    public void testSetCostBeforeTax() throws Exception {

    }

    public void testGetTaxRate() throws Exception {

    }

    public void testSetTaxRate() throws Exception {

    }

    public void testGetTaxAmount() throws Exception {

    }

    public void testSetTaxAmount() throws Exception {

    }

    public void testGetCostAfterTax() throws Exception {

    }

    public void testSetCostAfterTax() throws Exception {

    }

    public void testIsImported() throws Exception {

    }
}