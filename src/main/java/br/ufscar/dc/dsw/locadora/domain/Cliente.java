package br.ufscar.dc.dsw.locadora.domain;

import br.ufscar.dc.dsw.locadora.dto.cliente.DadosAtualizacaoCliente;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosCadastroCliente;
import br.ufscar.dc.dsw.locadora.validation.BirthDate;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueCPF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

  @UniqueCPF(message = "{Unique.cliente.CPF}")
  @NotBlank
  @Size(min = 15, max = 15)
  @Column(unique = true)
  private String cpf;

  @NotBlank
  @Size(min = 14, max = 14)
  private String phoneNumber;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Sexo sex;

  @BirthDate(message = "{BirthDate.cliente}")
  @Column(columnDefinition = "Date")
  private LocalDate birthDate;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "client")
  private List<Locacao> locacoes;

  public Cliente() {
    this.role = "ROLE_CLIENTE";
  }

  public Cliente(DadosCadastroCliente dados) {
    super(dados.username(), dados.password(), dados.name(), dados.email());
    this.role = "ROLE_CLIENTE";
    this.cpf = dados.cpf();
    this.phoneNumber = dados.phoneNumber();
    this.sex = dados.sex();
    this.birthDate = dados.birthDate();
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

  public void atualizar(DadosAtualizacaoCliente dados) {
    if (dados.password() != null) {
      this.setPassword(dados.password());
    }

    if (dados.name() != null) {
      this.setName(dados.name());
    }

    if (dados.email() != null) {
      this.setEmail(dados.email());
    }

    if (dados.cpf() != null) {
      this.setCpf(dados.cpf());
    }

    if (dados.phoneNumber() != null) {
      this.setPhoneNumber(dados.phoneNumber());
    }

    if (dados.sex() != null) {
      this.setSex(dados.sex());
    }

    if (dados.birthDate() != null) {
      this.setBirthDate(dados.birthDate());
    }

    if (dados.username() != null) {
      this.setUsername(dados.username());
    }

  }
}
