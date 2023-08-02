package br.ufscar.dc.dsw.locadora.locadora.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends Usuario {
    public Admin() {
        this.role = "ROLE_ADMIN";
        this.setEnabled(true);
    }

    public void atualizar(Admin admin) {
        if(admin.getEmail() != null) {
            this.setEmail(admin.getEmail());
        }

        if(admin.getPassword() != null) {
            this.setPassword(admin.getPassword());
        }

        if(admin.getName() != null) {
            this.setName(admin.getName());
        }

    }
}
