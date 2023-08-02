package br.ufscar.dc.dsw.locadora.locadora.validation.uniques;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

//  @Autowired
//  private IUsuarioDAO dao;

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
//    if (dao != null) {
//      Usuario usuario = dao.getUserByEmail(email);
//      return usuario == null;
//    } else {
//      // Durante a execução da classe LivrariaMvcApplication
//      // não há injeção de dependência
//      return true;
//    }
    return true;
  }
}