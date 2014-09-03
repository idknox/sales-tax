package test;

import ianKnoxSalesTax.main.LineItem;
import ianKnoxSalesTax.main.Receipt;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptTest extends TestCase {
    @Test
    public void testReceiptExists() {
        Receipt receipt = new Receipt();
    }

    @Test
    public void testReceiptPrintsBasicItems() {
        Receipt receipt = new Receipt();

        LineItem firstItem = new LineItem("Book 1", "book", 1, 12.49);
        LineItem secondItem = new LineItem("CD 1", "music", 1, 14.99);
        LineItem thirdItem = new LineItem("chocolate", "food", 1, 0.85);

        List input = new ArrayList();
        input.add(firstItem);
        input.add(secondItem);
        input.add(thirdItem);

        LineItem firstExpectedItem = new LineItem("Book 1", "book", 1, 12.49);
        LineItem secondExpectedItem = new LineItem("CD 1", "music", 1, 16.49);
        LineItem thirdExpectedItem = new LineItem("chocolate", "food", 1, 0.85);
        LineItem taxItem = new LineItem("sales tax", "tax", 1, 1.50);
        LineItem total = new LineItem("total", "total", 1, 29.83);

        List output = new ArrayList();
        output.add(firstExpectedItem);
        output.add(secondExpectedItem);
        output.add(thirdExpectedItem);
        output.add(taxItem);
        output.add(total);

        List printed = receipt.printout(input);
        assertEquals(output, printed);
    }

//    @Test
//    public void testReceiptPrintsImportedItems() {
//        Receipt receipt = new Receipt();
//
//        Map firstItem = new HashMap();
//        firstItem.put("name", "imported box of chocolates");
//        firstItem.put("category", "food");
//        firstItem.put("quantity", "1");
//        firstItem.put("amount", "10.00");
//
//        Map secondItem = new HashMap();
//        secondItem.put("name", "imported bottle of perfume");
//        secondItem.put("category", "cosmetics");
//        secondItem.put("quantity", "1");
//        secondItem.put("amount", "47.50");
//
//        List input = new ArrayList();
//        input.add(firstItem);
//        input.add(secondItem);
//
//        Map firstExpectedItem = new HashMap();
//        firstExpectedItem.put("name", "imported box of chocolates");
//        firstExpectedItem.put("quantity", "1");
//        firstExpectedItem.put("amount", "10.50");
//
//        Map secondExpectedItem = new HashMap();
//        secondExpectedItem.put("name", "imported bottle of perfume");
//        secondExpectedItem.put("quantity", "1");
//        secondExpectedItem.put("amount", "54.65");
//
//        Map taxItem = new HashMap();
//        taxItem.put("name", "sales tax");
//        taxItem.put("amount", "7.65");
//
//        Map total = new HashMap();
//        total.put("name", "total");
//        total.put("amount", "65.15");
//
//        List output = new ArrayList();
//        output.add(firstExpectedItem);
//        output.add(secondExpectedItem);
//        output.add(taxItem);
//        output.add(total);
//
//        assertEquals(output, receipt.printout(input));
//    }
//
//    @Test
//    public void testReceiptPrintsoutImportedandOtherTaxedItems() {
//        Receipt receipt = new Receipt();
//
//        Map firstItem = new HashMap();
//        firstItem.put("name", "imported bottle of perfume");
//        firstItem.put("category", "cosmetics");
//        firstItem.put("quantity", "1");
//        firstItem.put("amount", "27.99");
//
//        Map secondItem = new HashMap();
//        secondItem.put("name", "bottle of perfume");
//        secondItem.put("category", "cosmetics");
//        secondItem.put("quantity", "1");
//        secondItem.put("amount", "18.99");
//
//        Map thirdItem = new HashMap();
//        thirdItem.put("name", "packet of headache pills");
//        thirdItem.put("category", "medical");
//        thirdItem.put("quantity", "1");
//        thirdItem.put("amount", "9.75");
//
//        Map fourthItem = new HashMap();
//        fourthItem.put("name", "imported chocolates");
//        fourthItem.put("category", "food");
//        fourthItem.put("quantity", "1");
//        fourthItem.put("amount", "11.25");
//
//        List input = new ArrayList();
//        input.add(firstItem);
//        input.add(secondItem);
//        input.add(thirdItem);
//        input.add(fourthItem);
//
//        Map firstExpectedItem = new HashMap();
//        firstExpectedItem.put("name", "imported bottle of perfume");
//        firstExpectedItem.put("quantity", "1");
//        firstExpectedItem.put("amount", "32.19");
//
//        Map secondExpectedItem = new HashMap();
//        secondExpectedItem.put("name", "bottle of perfume");
//        secondExpectedItem.put("quantity", "1");
//        secondExpectedItem.put("amount", "20.89");
//
//        Map thirdExpectedItem = new HashMap();
//        thirdExpectedItem.put("name", "packet of headache pills");
//        thirdExpectedItem.put("quantity", "1");
//        thirdExpectedItem.put("amount", "9.75");
//
//        Map fourthExpectedItem = new HashMap();
//        fourthExpectedItem.put("name", "imported chocolates");
//        fourthExpectedItem.put("quantity", "1");
//        fourthExpectedItem.put("amount", "11.85");
//
//        Map taxItem = new HashMap();
//        taxItem.put("name", "sales tax");
//        taxItem.put("amount", "6.70");
//
//        Map total = new HashMap();
//        total.put("name", "total");
//        total.put("amount", "74.68");
//
//        List output = new ArrayList();
//        output.add(firstExpectedItem);
//        output.add(secondExpectedItem);
//        output.add(thirdExpectedItem);
//        output.add(fourthExpectedItem);
//        output.add(taxItem);
//        output.add(total);
//
//        assertEquals(output, receipt.printout(input));
//    }
}