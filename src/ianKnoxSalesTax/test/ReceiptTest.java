package test;

import ianKnoxSalesTax.main.Receipt;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class ReceiptTest extends TestCase {
    @Test
    public void testReceiptExists() {
        Receipt receipt = new Receipt();
    }

    @Test
    public void testReceiptPrintsBasicItems() {
        Receipt receipt = new Receipt();

        HashMap firstItem = new HashMap();
        firstItem.put("name", "Book 1");
        firstItem.put("category", "book");
        firstItem.put("quantity", "1");
        firstItem.put("amount", "12.49");


        HashMap secondItem = new HashMap();
        secondItem.put("name", "CD 1");
        secondItem.put("category", "music");
        secondItem.put("quantity", "1");
        secondItem.put("amount", "14.99");


        HashMap thirdItem = new HashMap();
        thirdItem.put("name", "chocolate");
        thirdItem.put("category", "food");
        thirdItem.put("quantity", "1");
        thirdItem.put("amount", "0.85");

        ArrayList input = new ArrayList();
        input.add(firstItem);
        input.add(secondItem);
        input.add(thirdItem);

        HashMap firstExpectedItem = new HashMap();
        firstExpectedItem.put("name", "Book 1");
        firstExpectedItem.put("quantity", "1");
        firstExpectedItem.put("amount", "12.49");


        HashMap secondExpectedItem = new HashMap();
        secondExpectedItem.put("name", "CD 1");
        secondExpectedItem.put("quantity", "1");
        secondExpectedItem.put("amount", "16.49");

        HashMap thirdExpectedItem = new HashMap();
        thirdExpectedItem.put("name", "chocolate");
        thirdExpectedItem.put("quantity", "1");
        thirdExpectedItem.put("amount", "0.85");

        HashMap taxItem = new HashMap();
        taxItem.put("name", "sales tax");
        taxItem.put("amount", "1.50");

        HashMap total = new HashMap();
        total.put("name", "total");
        total.put("amount", "29.83");

        ArrayList output = new ArrayList();
        output.add(firstExpectedItem);
        output.add(secondExpectedItem);
        output.add(thirdExpectedItem);
        output.add(taxItem);
        output.add(total);

        assertEquals(output, receipt.printout(input));
    }

    @Test
    public void testReceiptPrintsImportedItems() {
        Receipt receipt = new Receipt();

        HashMap firstItem = new HashMap();
        firstItem.put("name", "imported box of chocolates");
        firstItem.put("category", "food");
        firstItem.put("quantity", "1");
        firstItem.put("amount", "10.00");

        HashMap secondItem = new HashMap();
        secondItem.put("name", "imported bottle of perfume");
        secondItem.put("category", "cosmetics");
        secondItem.put("quantity", "1");
        secondItem.put("amount", "47.50");

        ArrayList input = new ArrayList();
        input.add(firstItem);
        input.add(secondItem);

        HashMap firstExpectedItem = new HashMap();
        firstExpectedItem.put("name", "imported box of chocolates");
        firstExpectedItem.put("quantity", "1");
        firstExpectedItem.put("amount", "10.50");

        HashMap secondExpectedItem = new HashMap();
        secondExpectedItem.put("name", "imported bottle of perfume");
        secondExpectedItem.put("quantity", "1");
        secondExpectedItem.put("amount", "54.65");

        HashMap taxItem = new HashMap();
        taxItem.put("name", "sales tax");
        taxItem.put("amount", "7.65");

        HashMap total = new HashMap();
        total.put("name", "total");
        total.put("amount", "65.15");

        ArrayList output = new ArrayList();
        output.add(firstExpectedItem);
        output.add(secondExpectedItem);
        output.add(taxItem);
        output.add(total);

        assertEquals(output, receipt.printout(input));
    }

    @Test
    public void testReceiptPrintsoutImportedandOtherTaxedItems() {
        Receipt receipt = new Receipt();

        HashMap firstItem = new HashMap();
        firstItem.put("name", "imported bottle of perfume");
        firstItem.put("category", "cosmetics");
        firstItem.put("quantity", "1");
        firstItem.put("amount", "27.99");

        HashMap secondItem = new HashMap();
        secondItem.put("name", "bottle of perfume");
        secondItem.put("category", "cosmetics");
        secondItem.put("quantity", "1");
        secondItem.put("amount", "18.99");

        HashMap thirdItem = new HashMap();
        thirdItem.put("name", "packet of headache pills");
        thirdItem.put("category", "medical");
        thirdItem.put("quantity", "1");
        thirdItem.put("amount", "9.75");

        HashMap fourthItem = new HashMap();
        fourthItem.put("name", "imported chocolates");
        fourthItem.put("category", "food");
        fourthItem.put("quantity", "1");
        fourthItem.put("amount", "11.25");

        ArrayList input = new ArrayList();
        input.add(firstItem);
        input.add(secondItem);
        input.add(thirdItem);
        input.add(fourthItem);

        HashMap firstExpectedItem = new HashMap();
        firstExpectedItem.put("name", "imported bottle of perfume");
        firstExpectedItem.put("quantity", "1");
        firstExpectedItem.put("amount", "32.19");

        HashMap secondExpectedItem = new HashMap();
        secondExpectedItem.put("name", "bottle of perfume");
        secondExpectedItem.put("quantity", "1");
        secondExpectedItem.put("amount", "20.89");

        HashMap thirdExpectedItem = new HashMap();
        thirdExpectedItem.put("name", "packet of headache pills");
        thirdExpectedItem.put("quantity", "1");
        thirdExpectedItem.put("amount", "9.75");

        HashMap fourthExpectedItem = new HashMap();
        fourthExpectedItem.put("name", "imported chocolates");
        fourthExpectedItem.put("quantity", "1");
        fourthExpectedItem.put("amount", "11.85");

        HashMap taxItem = new HashMap();
        taxItem.put("name", "sales tax");
        taxItem.put("amount", "6.70");

        HashMap total = new HashMap();
        total.put("name", "total");
        total.put("amount", "74.68");

        ArrayList output = new ArrayList();
        output.add(firstExpectedItem);
        output.add(secondExpectedItem);
        output.add(thirdExpectedItem);
        output.add(fourthExpectedItem);
        output.add(taxItem);
        output.add(total);

        assertEquals(output, receipt.printout(input));
    }
}