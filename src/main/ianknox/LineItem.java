package ianknox;

public class LineItem {
    private String name;
    private String category;
    private Integer quantity;
    private Double cost;
    private Double taxRate;
    private Double taxAmount;
    private Boolean imported;
    private Boolean basicTaxExempt;

    public LineItem(String name, String category, Integer quantity, Double cost) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.cost = cost;
        this.imported = calculateImportedStatus();
        this.basicTaxExempt = calculateExemptionStatus();
        this.taxRate = calculateTaxRate();
        this.taxAmount = calculateTaxAmount();
    }

    private Boolean calculateImportedStatus() {
        if (this.name.contains("imported")) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean calculateExemptionStatus() {
        return (this.category.equals("food") || this.category.equals("medical") || this.category.equals("book"));
    }

    private Double calculateTaxRate() {
        Double rate = 0.00;

        if (!this.basicTaxExempt) {
            rate += 0.10;
        }
        if (this.imported) {
            rate += 0.05;
        }
        return rate;
    }

    private Double calculateTaxAmount() {

        Double roundedToNickel = Math.ceil((this.cost * this.taxRate) / 0.05) * 0.05;

        return (double) Math.round(roundedToNickel * 100) / 100;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineItem lineItem = (LineItem) o;

        if (basicTaxExempt != null ? !basicTaxExempt.equals(lineItem.basicTaxExempt) : lineItem.basicTaxExempt != null)
            return false;
        if (category != null ? !category.equals(lineItem.category) : lineItem.category != null) return false;
        if (cost != null ? !cost.equals(lineItem.cost) : lineItem.cost != null) return false;
        if (imported != null ? !imported.equals(lineItem.imported) : lineItem.imported != null) return false;
        if (name != null ? !name.equals(lineItem.name) : lineItem.name != null) return false;
        if (quantity != null ? !quantity.equals(lineItem.quantity) : lineItem.quantity != null) return false;
        if (taxAmount != null ? !taxAmount.equals(lineItem.taxAmount) : lineItem.taxAmount != null) return false;
        if (taxRate != null ? !taxRate.equals(lineItem.taxRate) : lineItem.taxRate != null) return false;

        return true;
    }
}

