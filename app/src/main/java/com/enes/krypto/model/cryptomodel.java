package com.enes.krypto.model;

import com.google.gson.annotations.SerializedName;

public class cryptomodel {
    @SerializedName("currency")
    String currency;
    @SerializedName("price")
    String price;

    public cryptomodel(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
