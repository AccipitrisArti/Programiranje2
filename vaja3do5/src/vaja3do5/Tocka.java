package vaja3do5;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Tocka {

	protected Object ime;
	protected Set<Tocka> sosedi;
	protected double x;
	protected double y;
	protected double staraX;
	protected double staraY;
	protected boolean aktivnost;
	protected boolean oznacena;
	protected int polmer;
	
	public Tocka(Object imeTocke) {
		ime = imeTocke;
		sosedi = new HashSet<Tocka>();
		x = 0;
		y = 0;
		staraX = 0;
		staraY = 0;
		aktivnost = false;
		oznacena = false;
		polmer = 10;
	}
	
	public int stopnja() {
		return sosedi.size();
	}
	
}
