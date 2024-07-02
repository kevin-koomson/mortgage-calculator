package com.kevo.mortgageCalculator.entities;

import com.kevo.mortgageCalculator.annotations.ChangeRate;
import com.kevo.mortgageCalculator.annotations.LogExecutionTime;
import com.kevo.mortgageCalculator.annotations.RateExecution;
import com.kevo.mortgageCalculator.service.products.Loan;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class VariableLoan extends Loan {
    @Id
    @SequenceGenerator(
            name = "variableLoan"
    )
    private Long id;

    @LogExecutionTime // to implement
    @ChangeRate(interval = 30)
    private void resetRate() throws InvocationTargetException, IllegalAccessException {
        setRate(ThreadLocalRandom.current().nextDouble(1, 20));
    }
}
