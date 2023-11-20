package com.incometax.models.dto;

public enum TypeTax {
    FOURTH_CATEGORY("4ta Categoria"),
    FIFTH_CATEGORY("5ta Categoria");

    private String typeTax;

    TypeTax(String typeTax) {
        this.typeTax = typeTax;
    }

    public String getTypeTax() {
        return typeTax;
    }
}
