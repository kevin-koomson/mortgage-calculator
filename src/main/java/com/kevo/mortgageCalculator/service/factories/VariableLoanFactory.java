package com.kevo.mortgageCalculator.service.factories;

import com.kevo.mortgageCalculator.entities.FixedLoan;
import com.kevo.mortgageCalculator.models.LoanInput;

import java.util.concurrent.ThreadLocalRandom;

public class VariableLoanFactory extends LoanFactory{
    @Override
    public FixedLoan createLoan(LoanInput input) {
        FixedLoan loan = new FixedLoan();
        loan.setPrincipal(input.principal);
        loan.setRate(generateRate());
        loan.setYears(input.years);
        loan.calculateInterest();
        return loan;
    }
    private Double generateRate(){
        return ThreadLocalRandom.current().nextDouble(1, 20);
    }
}
