package com.kevo.mortgageCalculator.service.products;

import lombok.Data;

@Data
public abstract class Loan {
    private Double principal;
    private Double rate;
    private Double years;
    private Double calculatedInterest;

    private Double calculateInterest() {
        calculatedInterest = principal * (rate/100) * years;
        return calculatedInterest;
    };

}
