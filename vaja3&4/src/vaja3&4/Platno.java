package vaja3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.TreeMap;

import javax.swing.JPanel;

public class Platno extends JPanel {
	
	protected int sirina;
	protected int visina;
	protected Graf graf;
	
	public Platno(int sirina, int visina) {
		this.sirina = sirina;
		this.visina = visina;
		graf = null;
		this.setBackground(Color.white);
	}
	
	public void narisi(Graf g) {
		graf = g;
		repaint();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina);
	}
	
	public static int round(double x) {
		return (int)(x+0.5);
	}
	
	public void paintComponent(Graphics g) {
		if (graf == null) return;
		for (Tocka tocka : graf.tocke.values()) {
			for (Tocka sosed : tocka.sosedi) {
				g.drawLine(round(tocka.x), round(tocka.y), round(sosed.x), round(sosed.y));
			}
		}
		for (Tocka tocka : graf.tocke.values()) {
			g.setColor(Color.RED);
			g.fillOval(round(tocka.x)-5, round(tocka.y)-5, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(round(tocka.x)-5, round(tocka.y)-5, 10, 10);
		}
	}
}
