package com.covidmonitor.controller;
import com.covidmonitor.repository.SintomaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.covidmonitor.model.Sintoma;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class SintomaController {
    @Autowired
    private SintomaRepo sintomaRepo;

    @PostMapping("/api/sintomas")
    Sintoma createProfessor(@RequestBody Sintoma sintoma) {
        Sintoma createSintoma = sintomaRepo.save(sintoma);
        return createSintoma;
    }

    @GetMapping("/api/sintomas")
    Iterable<Sintoma> getSintomaes(@RequestParam Optional<Long> id) {

        return sintomaRepo.findAll();

    }

    @GetMapping("/api/sintomas/{id}")
    Optional<Sintoma> getSintoma(@PathVariable long id) {
        return sintomaRepo.findById(id);
    }

    @PutMapping("/api/sintomas/{id}")
    Optional<Sintoma> updateSintoma(@RequestBody Sintoma sintomaRequest, @PathVariable long id) {
        Optional<Sintoma> opt = sintomaRepo.findById(id);
        if (opt.isPresent()) {
            if (sintomaRequest.getId() == id) {
                sintomaRepo.save(sintomaRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do sintoma com id " + id);
    }

    @DeleteMapping(value = "/api/sintomas/{id}")
    void deleteSintoma(@PathVariable long id) {
        sintomaRepo.deleteById(id);
    }
	
}
