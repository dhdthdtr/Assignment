package com.example.assignment;

public class BakeryProduct {
    private String productName;
    private String productImage;

    // constructor
    public BakeryProduct(String productImage, String productName) {
        this.productName = productName;
        this.productImage = productImage;
    }

    // get product name
    public String getProductName() {
        return productName;
    }

    // get product image
    public String getProductImage() {
        return productImage;
    }

}
