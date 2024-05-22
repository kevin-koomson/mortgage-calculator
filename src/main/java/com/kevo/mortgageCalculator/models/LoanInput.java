package com.kevo.mortgageCalculator.models;

import lombok.Data;

@Data
public class LoanInput {
    public Double principal;
    public Double rate;
    public Double years;
}
