package com.kevo.mortgageCalculator.entities;

import com.kevo.mortgageCalculator.service.products.Loan;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@Entity
@RequiredArgsConstructor
public class VariableLoan extends Loan {
    @Id
    @SequenceGenerator(
            name = "variableLoan"
    )
    private Long id;
}
