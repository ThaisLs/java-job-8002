package br.com.trigg.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Vaga {
	private String recrutador;
	private LocalDate dtAberturaVaga;
	private List<Candidato> candidatos = new ArrayList<>();
	
}
