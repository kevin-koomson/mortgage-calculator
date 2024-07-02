package com.kevo.mortgageCalculator.models;

import com.kevo.mortgageCalculator.enums.LoanType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoanInput {
    @NotNull(message = "Please provide principal amount")
    @Min(0)
    public Double principal;

    @NotNull(message = "Please provide a valid rate")
    @Digits(message = "Please provide valid number", integer = 2, fraction = 2)
    @Min(0)
    @Max(40)
    public Double rate;

    @NotNull(message = "Please provide number of years")
    @Min(0)
    public Double years;

    public LoanType type = LoanType.FIXED;
    public Boolean save = false;
    public Boolean download = false;
}
