package br.ufscar.dc.dsw.locadora.locadora.validation.uniques;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

//  @Autowired
//  private IClienteDAO dao;

  @Override
  public boolean isValid(String CPF, ConstraintValidatorContext context) {
//    if (dao != null) {
//      Cliente cliente = dao.findByCpf(CPF);
//      return cliente == null;
//    } else {
//      // Durante a execução da classe LocadoraMVC
//      // não há injeção de dependência
//      return true;
//    }
    return true;
  }
}