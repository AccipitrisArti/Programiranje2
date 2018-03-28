package vaja3do5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JPanel;

public class Platno extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	
	protected int sirina;
	protected int visina;
	protected Graf graf;
	protected Tocka aktivna;
	protected List<Tocka> oznacene;
	protected int polmer = 10;
	
	public Platno(int sirina, int visina) {
		this.sirina = sirina;
		this.visina = visina;
		this.aktivna = null;
		this.oznacene = new LinkedList<Tocka>();
		graf = null;
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
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
		super.paintComponent(g);
		for (Tocka tocka : graf.tocke.values()) {
			for (Tocka sosed : tocka.sosedi) {
				g.drawLine(round(tocka.x), round(tocka.y), round(sosed.x), round(sosed.y));
			}
		}
		for (Tocka tocka : graf.tocke.values()) {
			if (tocka == aktivna) {
				g.setColor(Color.BLUE);
			} else if (oznacene.contains(tocka)) {
				g.setColor(Color.YELLOW);
			} else {
				g.setColor(Color.RED);
			}
			g.fillOval(round(tocka.x)-polmer/2, round(tocka.y)-polmer/2, polmer, polmer);
			g.setColor(Color.BLACK);
			g.drawOval(round(tocka.x)-polmer/2, round(tocka.y)-polmer/2, polmer, polmer);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (Tocka tocka : graf.tocke.values()) {
			if (Math.pow(tocka.x - e.getX()+polmer/2, 2) + Math.pow(tocka.y - e.getY()+polmer/2, 2) <= Math.pow(polmer, 2)) {
				aktivna = tocka;
				aktivna.staraX = tocka.x;
				aktivna.staraY = tocka.y;
				repaint();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (aktivna.staraX == aktivna.x && aktivna.staraY == aktivna.y) {
			if (oznacene.contains(aktivna)) {
				oznacene.remove(aktivna);
			} else {
				oznacene.add(aktivna);
			}
		}
		aktivna = null;
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (aktivna != null) {
			aktivna.x = e.getX()-polmer/2;
			aktivna.y = e.getY()-polmer/2;
			repaint();
		} else {
			for (Tocka tocka : oznacene) {
				tocka.x = tocka.staraX + e.getX()-polmer/2;
				tocka.y = tocka.staraY + e.getY()-polmer/2;
				repaint();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
