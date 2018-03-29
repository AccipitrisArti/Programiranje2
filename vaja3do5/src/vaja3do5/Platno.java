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
	protected int starX;
	protected int starY;
	protected Color barva = Color.RED;
	protected Color barvaAktivne = Color.BLUE;
	protected Color barvaOznacene = Color.YELLOW;
	protected Color barvaPovezave = Color.BLACK;
	protected Color barvaObrobe = Color.BLACK;
	protected int zapSt = 0;
	
	public Platno(int sirina, int visina) {
		this.sirina = sirina;
		this.visina = visina;
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
				g.setColor(barvaPovezave);
				g.drawLine(round(tocka.x), round(tocka.y), round(sosed.x), round(sosed.y));
			}
		}
		for (Tocka tocka : graf.tocke.values()) {
			if (tocka.aktivnost) {
				g.setColor(barvaAktivne);
			} else if (tocka.oznacena) {
				g.setColor(barvaOznacene);
			} else {
				g.setColor(barva);
			}
			g.fillOval(round(tocka.x)-tocka.polmer/2, round(tocka.y)-tocka.polmer/2,
					tocka.polmer, tocka.polmer);
			g.setColor(barvaObrobe);
			g.drawOval(round(tocka.x)-tocka.polmer/2, round(tocka.y)-tocka.polmer/2,
					tocka.polmer, tocka.polmer);
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
			if (Math.pow(tocka.x - e.getX()+tocka.polmer/2, 2) +
					Math.pow(tocka.y - e.getY() + tocka.polmer/2, 2) <=
					Math.pow(tocka.polmer, 2)) {
				tocka.aktivnost = true;
				tocka.staraX = tocka.x;
				tocka.staraY = tocka.y;
				repaint();
			}
		}
		starX = e.getX();
		starY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		boolean aktivna = false;
		
		for (Tocka tocka : graf.tocke.values()) {
			if (tocka.aktivnost) {
				if (tocka.staraX == tocka.x && tocka.staraY == tocka.y) {
					tocka.oznacena = !tocka.oznacena;
				}
			tocka.aktivnost = false;
			aktivna = true;
			}
		}
		if (!aktivna) {
			zapSt++;
			Tocka nova = new Tocka("nova"+zapSt);
			nova.x = e.getX();
			nova.y = e.getY();
			graf.dodajTocko(nova);
			for (Tocka v : graf.tocke.values()) {
				graf.dodajPovezavo(nova, v);
			}
		}
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		boolean aktivna = false;
		
		for (Tocka tocka : graf.tocke.values()) {
			if (tocka.aktivnost) {
				tocka.x = e.getX()-tocka.polmer/2;
				tocka.y = e.getY()-tocka.polmer/2;
				repaint();
				aktivna = true;
			}
		}
		if (!aktivna) {
			for (Tocka tocka : graf.tocke.values()) {
				if (tocka.oznacena) {
					tocka.x = tocka.staraX - starX + e.getX()-tocka.polmer/2;
					tocka.y = tocka.staraY - starY + e.getY()-tocka.polmer/2;
					repaint();
				}
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
		/* Ob pritisku stori:
		 * ce A oznaci vse,
		 * ce E odznaci vse,
		 * ce R dodaj vse povezave med oznacenimi,
		 * ce S zbrisi vse povezave med oznacenimi,
		 * ce D zbrici vse oznacene.
		 */
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
