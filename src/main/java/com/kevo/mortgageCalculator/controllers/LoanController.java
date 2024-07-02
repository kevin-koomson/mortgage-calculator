package com.kevo.mortgageCalculator.controllers;

import com.kevo.mortgageCalculator.models.LoanInput;
import com.kevo.mortgageCalculator.service.factories.LoanFactory;
import com.kevo.mortgageCalculator.service.products.Loan;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RequiredArgsConstructor
@RestController
@Slf4j
public class LoanController {
    public final LoanFactory loanFactory = new LoanFactory();
    @PostMapping("/calculate-loan")
    @ResponseStatus(HttpStatus.OK)
    public Loan createLoan(@RequestBody @Valid LoanInput input) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        return loanFactory.createLoan(input);
    };
}
