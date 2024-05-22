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
public class FixedLoan extends Loan {
    @Id
    @SequenceGenerator(
            name = "fixedLoan"
    )
    private Long id;
}
