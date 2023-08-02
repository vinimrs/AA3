package br.ufscar.dc.dsw.locadora.locadora.validation.uniques;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

//
//import br.ufscar.dc.dsw.locadora.dao.ILocadoraDAO;
//import br.ufscar.dc.dsw.domain.Locadora;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import jakarta.jakarta.ConstraintValidator;
//import jakarta.jakarta.ConstraintValidatorContext;
//
@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {
  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return false;
  }
//
//  @Autowired
//  private ILocadoraDAO dao;
//
//  @Override
//  public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
//    if (dao != null) {
//      Locadora locadora = dao.findByCnpj(CNPJ);
//      return locadora == null;
//    } else {
//      // Durante a execução da classe LivrariaMvcApplication
//      // não há injeção de dependência
//      return true;
//    }
//
//  }
}