package com.covidmonitor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.covidmonitor.model.EstadoSaude;
import com.covidmonitor.model.Funcionario;
import com.covidmonitor.model.Membro;
import com.covidmonitor.repository.EstadoSaudeRepo;
import com.covidmonitor.repository.MembroRepo;
import com.covidmonitor.repository.SintomaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.covidmonitor.model.Sintoma;

@RestController
public class EstadoSaudeController {
    @Autowired
    protected EstadoSaudeRepo estadoSaudeRepo;
    
    @Autowired
    protected MembroRepo membroRepo;
    
    @Autowired
    protected SintomaRepo sintomaRepo;

//    @GetMapping("/api/estadoSaude")
//    public List<EstadoSaude> getEstadosSaude(){
//        List<EstadoSaude> estados = new ArrayList<>();
//        estadoSaudeRepo.findAll().forEach(estados::add);
//        return estados;
//    }
//
//    @GetMapping("/api/estadoSaude/{id}")
//    public EstadoSaude getEstadoSaude(@PathVariable long id) {
//        Optional<EstadoSaude> retorno = estadoSaudeRepo.findById(id);
//        EstadoSaude estado = null;
//        if(retorno.isPresent()) {
//            estado = retorno.get();
//        }
//        return estado;
//    }

    @GetMapping("/api/estadoSaude/")
    Iterable<EstadoSaude> getEstadoSaude(@RequestParam Optional<Long> id) {

        return estadoSaudeRepo.findAll();

    }

    @GetMapping("/api/estadoSaude/{id}")
    Optional<EstadoSaude> getEstadoSaude(@PathVariable long id) {
        return estadoSaudeRepo.findById(id);
    }

    @PostMapping("/api/estadoSaude")
    public String createEstadoSaude(@RequestBody EstadoSaude estado) {   
        
        Optional<Membro> optionUsuario = membroRepo.findById(estado.getIdUsuario());
        if (!optionUsuario.isPresent()) {
            return (
               "{ \"success\": false, \"estado_saude_id\": 0 }" 
            );
        }
        
        List<Sintoma> sintomas = new ArrayList<>();
        for (Object s : estado.sintomas) {
            if(s instanceof Integer){                
                Integer a = new Integer((int) s);
                Optional<Sintoma> optionSintoma = sintomaRepo.findById(a.longValue());
                if (optionUsuario.isPresent()) {
                    sintomas.add(optionSintoma.get());
                }
            }
        }
       
       estado.setSintomas(sintomas);
       estado.setUsuario(optionUsuario.get());
       estadoSaudeRepo.save(estado);
       return (
        "{ \"success\": true, \"estado_saude_id\": "+ estado.getId() + " }"
       );
    }	
    
    @GetMapping("/api/estadoSaude/membro/{id}")
    public List<EstadoSaude> getEstadoSaudeUsuario(
                @PathVariable long id, 
                @RequestParam("start") Optional<String> start,
                @RequestParam("end") Optional<String> end
    ) throws ParseException {
        Optional<List<EstadoSaude>> retorno;        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        if(!start.isPresent()){
            retorno = estadoSaudeRepo.findByIdUsuario(id);
        } else if(start.isPresent() && !end.isPresent()){
            Date dateStart = formatter.parse(start.get());
            retorno = estadoSaudeRepo.findByIdUsuarioAndInitialDate(id, dateStart);
        } else {
            Date dateStart = formatter.parse(start.get());
            Date dateEnd = formatter.parse(end.get());
            retorno = estadoSaudeRepo.findByIdUsuarioAndInitiallEndDate(id, dateStart, dateEnd);
        }
        List<EstadoSaude> estado = null;
        if(retorno.isPresent()) {
            estado = retorno.get();
        }
        return estado;
    }
}
