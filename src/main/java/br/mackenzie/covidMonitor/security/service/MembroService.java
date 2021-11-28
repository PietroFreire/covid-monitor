package br.mackenzie.covidMonitor.security.service;

import br.mackenzie.covidMonitor.model.Membro;
import br.mackenzie.covidMonitor.model.Role;

public interface MembroService {

    Membro saveMembro(Membro membro);
    Role saveRole(Role role);
    void addRoleToMembro(String username, String roleName);
    Membro getMembro(String username);
    Iterable<Membro> getUsers();

}
