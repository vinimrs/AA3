package br.ufscar.dc.dsw.locadora.locadora.validation.uniques;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

//  @Autowired
//  private IUsuarioDAO dao;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
//    if (dao != null) {
//      Usuario usuario = dao.getUserByUsername(username);
//      return usuario == null;
//    } else {
//      // Durante a execução da classe LivrariaMvcApplication
//      // não há injeção de dependência
//      return true;
//    }
    return true;
  }
}