package com.synopsis.ms_inventory.bean;

import java.math.BigDecimal;

public class Inventory {

    private String codProduct;
    private String nameProduct;
    private BigDecimal quantityProduct;

    public Inventory(String codProduct, String nameProduct, BigDecimal quantityProduct) {
        this.codProduct = codProduct;
        this.nameProduct = nameProduct;
        this.quantityProduct = quantityProduct;
    }

    public String getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(String codProduct) {
        this.codProduct = codProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public BigDecimal getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(BigDecimal quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "codProduct='" + codProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantityProduct=" + quantityProduct +
                '}';
    }
}
