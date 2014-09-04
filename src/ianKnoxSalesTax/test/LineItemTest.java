package ianKnoxSalesTax.test;

import ianKnoxSalesTax.main.LineItem;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class LineItemTest extends TestCase {

    @Test
    public void testName() {
        LineItem testItem =  new LineItem("testName", "testCategory", 1, 0.00);

        assertEquals("testName", testItem.getName());
    }
}