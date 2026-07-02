package com.mranand4.lld.model.pricing;

import java.math.BigDecimal;

public class NormalPrice implements PricingStrategy {

    private BigDecimal price;

    public NormalPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
