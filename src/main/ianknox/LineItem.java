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

