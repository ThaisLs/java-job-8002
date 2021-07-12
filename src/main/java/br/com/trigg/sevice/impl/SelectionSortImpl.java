package br.com.trigg.sevice.impl;

import org.springframework.stereotype.Service;

import br.com.trigg.dto.Candidato;
import br.com.trigg.dto.Vaga;
import br.com.trigg.service.ISelectionSort;

@Service
public class SelectionSortImpl implements ISelectionSort {

	@Override
	public void converter(Vaga vaga) {
		for(int pos = 0; pos < vaga.getCandidatos().size(); pos ++) {
    		int maisNovo = pos;
    		
    		for(int idx = maisNovo ; idx < vaga.getCandidatos().size(); idx ++) {
    		    if (vaga.getCandidatos().get(idx).getData_nascimento().getYear() < vaga.getCandidatos().get(maisNovo).getData_nascimento().getYear() ) {
    		    	maisNovo = idx;
      	       }
        	}
    		
    		if (maisNovo != pos) {
		      Candidato candidato = vaga.getCandidatos().get(pos);
    	      vaga.getCandidatos().set(pos, vaga.getCandidatos().get(maisNovo));
    	      vaga.getCandidatos().set(maisNovo,candidato);
    	    }
    	}
	}

}
