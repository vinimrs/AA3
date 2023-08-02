package br.ufscar.dc.dsw.locadora.locadora.validation;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

@Component
public class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {

  @Override
  public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
    if (birthDate == null) return false;

    LocalDate today = LocalDate.now();
    return birthDate.isBefore(today);
  }
}