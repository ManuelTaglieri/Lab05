package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Anagrammi {
	
	AnagrammaDAO corretto;
	
	public Anagrammi() {
		this.corretto = new AnagrammaDAO();
	}
	
	public Set<String> calcolaAnagrammi(String parola) {
		
		Set<String> anagrammi = new HashSet<>();
		
		permuta("", parola, 0, anagrammi);
		
		return anagrammi;
		
	}
	
	public void permuta(String parziale, String lettere, int livello, Set<String> anagrammi) {
		if (lettere.length()==0) {
			anagrammi.add(parziale);
		} else {
			for (int pos=0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
				
				permuta(nuovaParziale, nuovaLettere, livello+1, anagrammi);
			}
		}
	}
	
	public boolean isCorretto(String parola) {
		return this.corretto.isCorret(parola);
	}

}
