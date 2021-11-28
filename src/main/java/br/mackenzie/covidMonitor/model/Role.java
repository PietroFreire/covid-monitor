package br.mackenzie.covidMonitor.model;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long idRole;
    protected String name;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }


}
