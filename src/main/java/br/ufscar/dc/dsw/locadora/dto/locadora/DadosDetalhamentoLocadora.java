package br.ufscar.dc.dsw.locadora.dto.locadora;

import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.domain.Locadora;

import java.util.List;

public record DadosDetalhamentoLocadora(
    Long id, String username, String name, String email,
    String cnpj, String city, List<Locacao> locacoes) {
  public DadosDetalhamentoLocadora(Locadora locadora) {
    this(locadora.getId(), locadora.getUsername(), locadora.getName(), locadora.getEmail(),
        locadora.getCnpj(), locadora.getCity(), locadora.getLocacoes());
  }

}
