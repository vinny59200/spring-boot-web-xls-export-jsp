package com.vv.domain;

public class TdoVV {
    private String codification;
    private String model;
    private int quantity;
    private String measureUnit;

    // Constructor
    public TdoVV( String codification, String model, int quantity, String measureUnit ) {
        this.codification = codification;
        this.model = model;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
    }

    // Getters
    public String getCodification() {
        return codification;
    }

    public String getModel() {
        return model;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    // Setters
    public void setCodification(String codification) {
        this.codification = codification;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    // ToString method for debugging
    @Override
    public String toString() {
        return "com.vv.domain.TdoVV{" +
                "codification='" + codification + '\'' +
                ", model='" + model + '\'' +
                ", quantity=" + quantity +
                ", measureUnit='" + measureUnit + '\'' +
                '}';
    }
}
