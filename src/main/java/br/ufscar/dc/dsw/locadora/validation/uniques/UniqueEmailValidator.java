package br.ufscar.dc.dsw.locadora.validation.uniques;

import br.ufscar.dc.dsw.locadora.domain.Usuario;
import br.ufscar.dc.dsw.locadora.repository.IAdminRepository;
import br.ufscar.dc.dsw.locadora.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

  @Autowired
  private IUsuarioRepository repository;

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    System.out.println("Validating email: " + email);
    if (repository != null) {
      Usuario usuario = repository.findByEmail(email);
      System.out.println("Usuario: " + usuario);
      return usuario == null;
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
    }
    return true;
  }
}