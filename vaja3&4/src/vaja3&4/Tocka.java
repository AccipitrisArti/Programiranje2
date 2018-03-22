package vaja3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Tocka {

	protected Object ime;
	protected Set<Tocka> sosedi;
	protected double x;
	protected double y;
	
	public Tocka(Object imeTocke) {
		ime = imeTocke;
		sosedi = new HashSet<Tocka>();
		x = 0;
		y = 0;
	}
	
	public int stopnja() {
		return sosedi.size();
	}
	
}
