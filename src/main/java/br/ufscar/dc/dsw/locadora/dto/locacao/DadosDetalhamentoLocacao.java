package br.ufscar.dc.dsw.locadora.dto.locacao;

import br.ufscar.dc.dsw.locadora.domain.Locacao;
import br.ufscar.dc.dsw.locadora.dto.cliente.DadosPublicosCliente;
import br.ufscar.dc.dsw.locadora.dto.locadora.DadosListagemPublicaLocadora;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosDetalhamentoLocacao(
    Long id, LocalTime hour, LocalDate date, DadosListagemPublicaLocadora rentalCompany,
    DadosPublicosCliente client) {
  public DadosDetalhamentoLocacao(Locacao locacao) {
    this(locacao.getId(), locacao.getHour(), locacao.getDate(),
        new DadosListagemPublicaLocadora(locacao.getRentalCompany()), new DadosPublicosCliente(locacao.getClient()));
  }

}
