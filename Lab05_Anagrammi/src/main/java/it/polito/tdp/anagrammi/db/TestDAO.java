package it.polito.tdp.anagrammi.db;

public class TestDAO {

	public static void main(String[] args) {
		
		AnagrammaDAO prova = new AnagrammaDAO();
		
		System.out.println(prova.isCorret("ciao"));
		System.out.println(prova.isCorret("hey"));

	}

}
