package vaja3do5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Okno extends JFrame implements ActionListener {
	
	protected Platno platno;
	private JMenuItem prazen = new JMenuItem("Prazen");
	private JMenuItem poln = new JMenuItem("Poln");
	private JMenuItem polnDvodelen = new JMenuItem("Poln dvodelen");
	private JMenuItem cikel = new JMenuItem("Cikel");
	private JMenuItem tocke = new JMenuItem("Toèke");
	private JMenuItem povezave = new JMenuItem("Povezave");
	private JMenuItem imp = new JMenuItem("Uvozi graf");
	private JMenuItem exp = new JMenuItem("Izvozi graf");
	private JMenuItem izhod = new JMenuItem("Izhod");
	
	public Okno(int sirina, int visina) {
		super();
		setTitle("Graf");
		platno = new Platno(sirina, visina);
		add(platno);
		platno.setFocusable(true);
		
		JMenuBar mb = new JMenuBar();
		JMenu izberiGraf = new JMenu("Dodaj standarden graf");
		
		prazen.addActionListener(this);
		izberiGraf.add(prazen);
		poln.addActionListener(this);
		izberiGraf.add(poln);
		polnDvodelen.addActionListener(this);
		izberiGraf.add(polnDvodelen);
		cikel.addActionListener(this);
		izberiGraf.add(cikel);
		
		izberiGraf.addSeparator();
		mb.add(izberiGraf);
		
		JMenu barve = new JMenu("Nastavi barve");
		
		tocke.addActionListener(this);
		barve.add(tocke);
		povezave.addActionListener(this);
		barve.add(povezave);
		
		barve.addSeparator();
		mb.add(barve);
		
		JMenu ie = new JMenu("Uvoz/izvoz");
		
		imp.addActionListener(this);
		ie.add(imp);
		exp.addActionListener(this);
		ie.add(exp);
		
		ie.addSeparator();
		mb.add(ie);
		
		izhod.addActionListener(this);
		mb.add(izhod);
		
		setJMenuBar(mb);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == prazen) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk: ");
			Graf g = Graf.prazen(Integer.parseInt(n));
			g.razporedi(250, 250, 100);
			platno.narisi(g);
		} else if (e.getSource() == poln) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk: ");
			Graf g = Graf.poln(Integer.parseInt(n));
			g.razporedi(250, 250, 100);
			platno.narisi(g);
		} else if (e.getSource() == polnDvodelen) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk v prvem delu: ");
			String m = JOptionPane.showInputDialog("Vnesi število toèk v drugem delu: ");
			Graf g = Graf.polnDvodelen(Integer.parseInt(n), Integer.parseInt(m));
			g.razporedi(250, 250, 100);
			platno.narisi(g);
		} else if (e.getSource() == cikel) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk: ");
			Graf g = Graf.cikel(Integer.parseInt(n));
			g.razporedi(250, 250, 100);
			platno.narisi(g);
		} else if (e.getSource() == tocke) {
			Color c = JColorChooser.showDialog(this,  "Izberi barvo toèke: ",  platno.barva);
			platno.barva = c;
		} else if (e.getSource() == povezave) {
			Color c = JColorChooser.showDialog(this,  "Izberi barvo povezave: ",  platno.barvaPovezave);
			platno.barvaPovezave = c;
		} else if (e.getSource() == imp) {
			JFileChooser fc = new JFileChooser();
			int option = fc.showOpenDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String ime = fc.getSelectedFile().getPath();
				try {
					boolean blokTock = true;
					BufferedReader vhod = new BufferedReader(new FileReader(ime)); // odpri za branje
					platno.graf = new Graf();
					while (vhod.ready()) {
						// za zgradbo datoteke .net poglej opis v primeru [exp]
						String vrstica = vhod.readLine().trim(); // preberi vrstico brez praznih znakov na zaèetku in na koncu
						if (vrstica.equals("")) continue; // preskoci prazne vrstice
						if (vrstica.startsWith("# vertices")) {
							blokTock = true;
							continue;
						} else if (vrstica.startsWith("# edges")) {
							blokTock = false;
							continue;
						}
						
						StringTokenizer st = new StringTokenizer(vrstica, " "); // odstrani nastete znake
						if (blokTock) {
							Tocka v = new Tocka(st.nextToken());
							platno.graf.dodajTocko(v);
							v.x = Integer.parseInt(st.nextToken());
							v.y = Integer.parseInt(st.nextToken());
						} else {
							Tocka v = platno.graf.tocke.get(st.nextToken());
							while (st.hasMoreTokens()) {
								platno.graf.dodajPovezavo(v, platno.graf.tocke.get(st.nextToken()));
							}
						}
					}
					vhod.close();
				}
				catch (IOException exc) {
					
				}
			}
		} else if (e.getSource() == exp) {
			JFileChooser fc = new JFileChooser();
			int option = fc.showSaveDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String ime = fc.getSelectedFile().getPath();
				try {
					boolean blokTock = true; // opisujemo tocke ali povezave
					PrintWriter izhod = new PrintWriter(new FileWriter(ime)); // odpri za pisanje
						/*
						 * datoteka formata .net je oblike
						 * # vertices (st. tock)
						 * 1 x1 y1
						 * 2 x2 y2
						 * ...
						 * # edges
						 * 1 2 4
						 * 2 1
						 * 3 5 8
						 * ...
						 */
					izhod.println("# vertices " + platno.graf.tocke.size());
					for (Tocka tocka : platno.graf.tocke.values()) {
						izhod.println(tocka.ime + " " + Platno.round(tocka.x) + " " + Platno.round(tocka.y));
					}
					izhod.println("# edges");
					for (Tocka tocka : platno.graf.tocke.values()) {
						izhod.print(tocka.ime + "");
						for (Tocka sosed : tocka.sosedi) {
							izhod.print(" " + sosed.ime);
						}
						izhod.print("\n");
					}
					izhod.close();
				}
				catch (IOException exc) {
					
				}
			}
		} else if (e.getSource() == izhod) {
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		repaint();
	}
}
