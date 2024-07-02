package com.kevo.mortgageCalculator.service.factories;

import com.kevo.mortgageCalculator.annotations.RateExecution;
import com.kevo.mortgageCalculator.models.LoanInput;
import com.kevo.mortgageCalculator.service.products.Loan;

import java.lang.reflect.InvocationTargetException;

public class LoanFactory {
    public Loan createLoan(LoanInput input) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        return switch(input.type) {
            case FIXED -> (new FixedLoanFactory()).createLoan(input);
            case VARIABLE -> {
                Loan variable = (new VariableLoanFactory()).createLoan(input);
                RateExecution.change(variable);
                yield variable;
            }
            default -> null;
        };
    }
}
