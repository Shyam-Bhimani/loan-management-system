package com.loan.week9.day4.src.main.java;

import com.loan.week9.day4.src.main.java.LoanValidator.LoanValidator;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class LoanValidationService {

    private final List<LoanValidator> validators;
    private final Map<String, LoanValidator> validatorMap;

    // Combine both dependencies into a single constructor to avoid compilation and Spring ambiguity errors
    public LoanValidationService(List<LoanValidator> validators, Map<String, LoanValidator> validatorMap) {
        this.validators = validators;
        this.validatorMap = validatorMap;
    }

    public void runAllValidators() {
        System.out.println("--- Starting Validation Chain ---");
        for (LoanValidator validator : validators) {
            validator.validate();
        }
    }

    public void printValidatorMap() {
        System.out.println("--- Starting Map Inspection ---");

        // Loop through the map to print bean name → implementation class
        validatorMap.forEach((beanName, validatorInstance) -> {
            System.out.println(beanName + " → " + validatorInstance.getClass().getSimpleName());
        });
    }
}
