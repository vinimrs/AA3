package br.ufscar.dc.dsw.locadora.locadora.repository;

import br.ufscar.dc.dsw.locadora.locadora.domain.Cliente;
import br.ufscar.dc.dsw.locadora.locadora.domain.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
