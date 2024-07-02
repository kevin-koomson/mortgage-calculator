package com.kevo.mortgageCalculator.service.factories;

import com.kevo.mortgageCalculator.entities.FixedLoan;
import com.kevo.mortgageCalculator.models.LoanInput;

public class FixedLoanFactory extends LoanFactory{
    @Override
    public FixedLoan createLoan(LoanInput input) {
        FixedLoan loan = new FixedLoan();
        loan.setPrincipal(input.getPrincipal());
        loan.setRate(input.getRate());
        loan.setYears(input.getYears());
        loan.calculateInterest();
        return loan;
    }
}
