package com.synopsis.ms_order.bean;
import java.math.BigDecimal;

public class Order {
    private String codProduct;
    private String nameProduct;
    private BigDecimal quantityProduct;
    private BigDecimal priceProduct;
    private BigDecimal total;

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

    public BigDecimal getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(BigDecimal priceProduct) {
        this.priceProduct = priceProduct;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
