package ianKnoxSalesTax.main;

public class LineItem {
    private String name;
    private String category;
    private Integer quantity;
    private Double cost;
    private Double taxRate;
    private Double taxAmount;
    private Boolean imported;
    private Boolean basicTaxExempt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineItem lineItem = (LineItem) o;

        if (!basicTaxExempt.equals(lineItem.basicTaxExempt)) return false;
        if (!category.equals(lineItem.category)) return false;
        if (!cost.equals(lineItem.cost)) return false;
        if (!imported.equals(lineItem.imported)) return false;
        if (!name.equals(lineItem.name)) return false;
        if (!quantity.equals(lineItem.quantity)) return false;
        if (!taxRate.equals(lineItem.taxRate)) return false;
        if (!taxAmount.equals(lineItem.taxAmount)) return false;

        return true;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    private Boolean calculateImportedStatus() {
        if (this.name.contains("imported")) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isImported() {
        return imported;
    }

    private Boolean calculateExemptionStatus() {
        return (this.category.equals("food") || this.category.equals("medical") || this.category.equals("book"));
    }

    public Boolean isExempt() {
        return basicTaxExempt;
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
        return Math.ceil((this.cost * this.taxRate) / 0.05) * 0.05;
    }
}
