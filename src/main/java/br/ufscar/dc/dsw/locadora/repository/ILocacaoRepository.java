package br.ufscar.dc.dsw.locadora.repository;

import br.ufscar.dc.dsw.locadora.domain.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocacaoRepository extends JpaRepository<Locacao, Long> {
}
