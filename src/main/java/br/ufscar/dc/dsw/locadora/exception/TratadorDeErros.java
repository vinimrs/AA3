package br.ufscar.dc.dsw.locadora.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class TratadorDeErros {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity tratarErro404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
    List<FieldError> erros = ex.getFieldErrors();
    return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity tratarErro400(HttpMessageNotReadableException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity tratarErroValidacao(ConstraintViolationException ex) {
//    List<String> erros = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
//    List<Path> campos = ex.getConstraintViolations().stream().map(ConstraintViolation::getPropertyPath).toList();
//    System.out.println(campos);

    Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

    System.out.println(constraintViolations);

    Set<DadosErroValidacao> messages = new HashSet<>(constraintViolations.size());

    constraintViolations.forEach(constraintViolation -> {
      messages.add(new DadosErroValidacao(constraintViolation.getPropertyPath().toString(),
          constraintViolation.getMessage()));
    });
    //    messages.addAll(constraintViolations.stream()
//        .map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
//            constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
//        .toList());

    return ResponseEntity.badRequest().body(messages);
  }

//  @ExceptionHandler(BadCredentialsException.class)
//  public ResponseEntity tratarErroBadCredentials() {
//    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
//  }
//
//  @ExceptionHandler(AuthenticationException.class)
//  public ResponseEntity tratarErroAuthentication() {
//    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
//  }
//
//  @ExceptionHandler(AccessDeniedException.class)
//  public ResponseEntity tratarErroAcessoNegado() {
//    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
//  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity tratarErro500(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
  }

  @ExceptionHandler(JpaSystemException.class)
  public ResponseEntity tratarErro500(JpaSystemException ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
  }

  private record DadosErroValidacao(String field, String message) {
    public DadosErroValidacao(FieldError erro) {
      this(erro.getField(), erro.getDefaultMessage());
    }
  }

}