package ianknox;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

public class Receipt {

    public ArrayList printout(ArrayList<HashMap<String, String>> lineItems) {
        Double totalTaxAmount = 0.00;
        ArrayList<HashMap<String, String>> output = new ArrayList<HashMap<String, String>>();

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
            output.add(outputItem);

            totalTaxAmount += taxAmountRounded;
        }
        HashMap taxItem = new HashMap();
//        double totalTaxRounded = ((double) (long) (totalTaxAmount * 20 + 0.5)) / 20;
        taxItem.put("amount", String.format("%.2f", totalTaxAmount));
        taxItem.put("name", "sales tax");
        output.add(taxItem);
        return output;
    }
}