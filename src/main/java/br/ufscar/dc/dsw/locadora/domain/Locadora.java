package br.ufscar.dc.dsw.locadora.domain;

import br.ufscar.dc.dsw.locadora.dto.locadora.DadosAtualizacaoLocadora;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosCadastroLocadora;
import br.ufscar.dc.dsw.locadora.validation.uniques.UniqueCNPJ;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Locadora")
public class Locadora extends Usuario {

  @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
  @NotBlank
  @Size(min = 18, max = 18, message = "{Size.locadora.CNPJ}")
  @Column(unique = true)
  private String cnpj;

  @NotBlank
  @Column(length = 50)
  private String city;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "rentalCompany")
  private List<Locacao> locacoes;

  public Locadora() {
    this.role = "ROLE_LOCADORA";
  }

  public Locadora(DadosCadastroLocadora dados) {
    this.setUsername(dados.username());
    this.setPassword(dados.password());
    this.setName(dados.name());
    this.setEmail(dados.email());
    this.cnpj = dados.cnpj();
    this.city = dados.city();
    this.role = "ROLE_LOCADORA";
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<Locacao> getLocacoes() {
    return locacoes;
  }

  public void atualizar(DadosAtualizacaoLocadora dados) {
    if (dados.username() != null) {
      this.setUsername(dados.username());
    }

    if (dados.password() != null) {
      this.setPassword(dados.password());
    }

    if (dados.name() != null) {
      this.setName(dados.name());
    }

    if (dados.email() != null) {
      this.setEmail(dados.email());
    }

    if (dados.cnpj() != null) {
      this.cnpj = dados.cnpj();
    }

    if (dados.city() != null) {
      this.city = dados.city();
    }
  }
}
