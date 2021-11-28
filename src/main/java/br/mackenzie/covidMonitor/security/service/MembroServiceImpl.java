package br.mackenzie.covidMonitor.security.service;

import br.mackenzie.covidMonitor.model.Membro;
import br.mackenzie.covidMonitor.model.Role;
import br.mackenzie.covidMonitor.repository.MembroRepo;
import br.mackenzie.covidMonitor.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor
@Transactional @Slf4j
public class MembroServiceImpl implements MembroService{
    private final MembroRepo membroRepo;
    private final RoleRepo roleRepo;

    @Override
    public Membro saveMembro(Membro membro) {
        return membroRepo.save(membro);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToMembro(String username, String roleName) {
        Membro membro = membroRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        membro.getRoles().add(role);
    }

    @Override
    public Membro getMembro(String username) {
        return membroRepo.findByUsername(username);
    }

    @Override
    public List<Membro> getUsers() {
        return (List<Membro>) membroRepo.findAll();
    }
}
