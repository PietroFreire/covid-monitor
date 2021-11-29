package com.covidmonitor.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.covidmonitor.model.Membro;

public interface MembroRepo extends CrudRepository<Membro, Long>{
	
    @Query("select u from Membro u where u.username = ?1 AND u.senha = ?2")
    Optional<Membro> logar(int matricula, String senha);
    
    @Query("select u from Membro u where u.username = ?1")
    Optional<Membro> findByUsername(int matricula);
}
