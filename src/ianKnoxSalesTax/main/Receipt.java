package ianKnoxSalesTax.main;

import java.util.ArrayList;
import java.util.HashMap;

public class Receipt {

    public ArrayList printout(ArrayList<HashMap<String, String>> lineItems) {
        Double totalTaxAmount = 0.00;
        Double totalCost = 0.00;

        ArrayList output = new ArrayList();

        for (HashMap<String, String> lineItem : lineItems) {
            Double itemTotalTaxRate = 0.00;

            if (lineItem.get("category") != "food" && lineItem.get("category") != "book" && lineItem.get("category") != "medical") {
                itemTotalTaxRate += 0.10;
            }
            if (lineItem.get("name").contains("imported")) {
                itemTotalTaxRate += 0.05;
            }
            Double taxAmount = Double.parseDouble(lineItem.get("amount")) * itemTotalTaxRate;

            Double taxAmountRounded = Math.ceil(taxAmount / 0.05) * 0.05;

            Double amountWithTax = Double.parseDouble(lineItem.get("amount")) + taxAmountRounded;

            HashMap outputItem = new HashMap();
            outputItem.put("amount", String.format("%.2f", amountWithTax));
            outputItem.put("name", lineItem.get("name"));
            outputItem.put("quantity", lineItem.get("quantity"));
            output.add(outputItem);

            totalTaxAmount += taxAmountRounded;
            totalCost += amountWithTax;
        }
        HashMap taxItem = new HashMap();
        taxItem.put("name", "sales tax");
        taxItem.put("amount", String.format("%.2f", totalTaxAmount));

        HashMap total = new HashMap();
        total.put("name", "total");
        total.put("amount", String.format("%.2f", totalCost));

        output.add(taxItem);
        output.add(total);
        return output;
    }
}