package br.ufscar.dc.dsw.locadora.locadora.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

//  @UniqueCPF(message = "{Unique.cliente.CPF}")
  @NotBlank
  @Size(min = 14, max = 14)
  @Column(unique = true)
  private String cpf;

  @NotBlank
  @Size(min = 15, max = 15)
  private String phoneNumber;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Sexo sex;

//  @BirthDate(message = "{BirthDate.cliente}")
  @Column(columnDefinition = "Date")
  private LocalDate birthDate;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "client")
  private List<Locacao> locacoes;

  public Cliente() {
    this.role = "ROLE_CLIENTE";
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Sexo getSex() {
    return sex;
  }

  public void setSex(Sexo sex) {
    this.sex = sex;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public List<Locacao> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<Locacao> locacoes) {
    this.locacoes = locacoes;
  }
}
