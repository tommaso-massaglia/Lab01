package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private LinkedList<String> lista = new LinkedList<String>();
	//private ArrayList<String> lista = new ArrayList<String>();
		
	public Parole() {
	}
	
	public void addParola(String p) {
		if (lista.contains(p.toLowerCase())!=true)
			lista.add(p.toLowerCase());
	}
	
	public List<String> getElenco() {
		Collections.sort(lista);
		return lista;
	}
	
	public void reset() {
		lista.clear();
	}
	
	public void removeParola(String darimuovere) {
		lista.remove(darimuovere);
	}

}
