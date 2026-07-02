package com.mranand4.lld.model.pricing;

import java.math.BigDecimal;

// Helps us to dynamically change price of seats at runtime
public interface PricingStrategy {

    BigDecimal getPrice();
}
