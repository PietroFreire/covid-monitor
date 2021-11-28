package br.mackenzie.covidMonitor.repository;

import br.mackenzie.covidMonitor.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
    Role findByName(String name);

}
