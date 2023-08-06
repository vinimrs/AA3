package br.ufscar.dc.dsw.locadora.domain;


import br.ufscar.dc.dsw.locadora.dto.admin.DadosAtualizacaoAdmin;
import br.ufscar.dc.dsw.locadora.dto.admin.DadosCadastroAdmin;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends Usuario {
  public Admin() {
    this.role = "ROLE_ADMIN";
  }

  public Admin(DadosCadastroAdmin dados) {
    super(dados.username(), dados.password(), dados.name(), dados.email());
    this.role = "ROLE_ADMIN";
  }

  public void atualizar(DadosAtualizacaoAdmin admin) {
    if (admin.username() != null) {
      this.setUsername(admin.username());
    }

    if (admin.email() != null) {
      this.setEmail(admin.email());
    }

    if (admin.password() != null) {
      this.setPassword(admin.password());
    }

    if (admin.name() != null) {
      this.setName(admin.name());
    }

  }
}
