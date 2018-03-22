package vaja3;

import javax.swing.JFrame;

public class Okno extends JFrame {
	
	protected Platno platno;
	
	public Okno(int sirina, int visina) {
		super();
		setTitle("Graf");
		platno = new Platno(sirina, visina);
		add(platno);
	}
}
