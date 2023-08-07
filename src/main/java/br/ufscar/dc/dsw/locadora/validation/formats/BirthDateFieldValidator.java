package br.ufscar.dc.dsw.locadora.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BirthDateFieldValidator implements ConstraintValidator<BirthDateField, String> {

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
    if (fieldValue == null) return true; // Ignoramos se o campo é nulo em requisições de atualização
    if (fieldValue.isBlank()) return false;

    try {
      LocalDate birthDate = LocalDate.parse(fieldValue);
      LocalDate today = LocalDate.now();
      return birthDate.isBefore(today);
    } catch (Exception e) {
      return false;
    }
  }
}