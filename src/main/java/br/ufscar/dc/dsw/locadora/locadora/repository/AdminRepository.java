package br.ufscar.dc.dsw.locadora.locadora.repository;

import br.ufscar.dc.dsw.locadora.locadora.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
