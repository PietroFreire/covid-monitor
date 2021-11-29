package com.covidmonitor.repository;

import org.springframework.data.repository.CrudRepository;
import com.covidmonitor.model.Sintoma;

public interface SintomaRepo extends CrudRepository<Sintoma, Long>{
    
}
