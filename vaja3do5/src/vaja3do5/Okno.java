package vaja3do5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
					while (vhod.ready()) {
						String vrstica = vhod.readLine().trim(); // preberi vrstico brez praznih znakov na zaèetku in na koncu
						if (vrstica.equals("")) continue; // preskoci prazne vrstice
						if (vrstica.startsWith("# vertices")) {
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
						}
						StringTokenizer st = new StringTokenizer(vrstica, " .,!?:;"); // odstrani nastete znake
						while (st.hasMoreTokens()) {
							System.out.println(st.nextToken());
							// tu bere datoteko po besedah
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
				// try {
					// ...
				// }
				// catch (IOException exc) {
					// ...
				// }
			}
		} else if (e.getSource() == izhod) {
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		repaint();
	}
}
