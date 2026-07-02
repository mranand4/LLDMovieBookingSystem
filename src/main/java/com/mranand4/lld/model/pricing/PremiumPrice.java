package com.mranand4.lld.model.pricing;

import java.math.BigDecimal;

public class PremiumPrice implements PricingStrategy {

    private BigDecimal price;

    public PremiumPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}

