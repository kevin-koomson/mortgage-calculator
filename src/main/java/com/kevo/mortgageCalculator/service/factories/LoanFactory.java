package com.kevo.mortgageCalculator.service.factories;

import com.kevo.mortgageCalculator.models.LoanInput;
import com.kevo.mortgageCalculator.service.products.Loan;

public abstract class LoanFactory {
    public LoanInput validatedInput;
    public Loan createLoan(LoanInput input) {
        return null;
    }

}
