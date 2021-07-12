package br.com.trigg.controller;

import java.text.ParseException;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.trigg.dto.Vaga;
import br.com.trigg.service.ISelectionSort;

@RestController
public class VagaController {	
	private Vaga vaga;
	@Inject
	private ISelectionSort sort;
	
	@RequestMapping(method = RequestMethod.POST, value="candidatos")
    public ResponseEntity<String> postCandidatos(@RequestBody Vaga vaga) throws ParseException {
		if(vaga == null) {
    		return new ResponseEntity<>("Request vazio, por favor verificar",HttpStatus.NOT_FOUND);    		
    	}
	   this.sort.converter(vaga);
       this.vaga = vaga;
       return new ResponseEntity<>("Candidatos recebidos!",HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.GET, value="candidatos")
    public ResponseEntity<?> getCandidatos(){
    	if(this.vaga == null) {
    		return new ResponseEntity<>("Candidatos não encontrados. O recebimento deles é necessário",HttpStatus.NOT_FOUND);    		
    	}
        return new ResponseEntity<Vaga>(this.vaga, HttpStatus.OK);
    }

}
