package ianKnoxSalesTax.main;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    public List printout(List<LineItem> lineItems) {
        Double totalTaxAmount = 0.00;
        Double totalCost = 0.00;

        List output = new ArrayList();

        for (LineItem lineItem : lineItems) {
            Double totalTaxRate = lineItem.getTaxRate();

            lineItem.setTaxAmount(lineItem.getCost() * lineItem.getTaxRate());

            Double taxAmountRounded = Math.ceil(lineItem.getTaxAmount() / 0.05) * 0.05;

            Double costAfterTax = lineItem.getCost() + taxAmountRounded;
            System.out.println(costAfterTax);
            Double costAfterTaxRounded = Math.round(costAfterTax * 100.0) /100.0;
            LineItem outputItem = new LineItem(lineItem.getName(), lineItem.getCategory(), lineItem.getQuantity(), costAfterTaxRounded);
            output.add(outputItem);

            totalTaxAmount += taxAmountRounded;
            totalCost += costAfterTaxRounded;
            totalCost *= lineItem.getQuantity();
        }

        LineItem taxItem = new LineItem("sales tax", "tax", 1, totalTaxAmount);

        LineItem total = new LineItem("total", "total", 1, totalCost);

        output.add(taxItem);
        output.add(total);
        return output;
    }
}