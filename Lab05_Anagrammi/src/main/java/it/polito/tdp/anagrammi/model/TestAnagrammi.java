package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestAnagrammi {

	public static void main(String[] args) {
		
		Anagrammi anagrammi = new Anagrammi();
		
		Set<String> risultato = anagrammi.calcolaAnagrammi("via");
		
		System.out.println(risultato.toString());

	}

}
