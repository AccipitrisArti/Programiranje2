package risanjeGrafov;

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
	private JMenuItem tocke = new JMenuItem("Barva toèke");
	private JMenuItem aktivne = new JMenuItem("Barva aktivne toèke");
	private JMenuItem oznacene = new JMenuItem("Barva oznacene toèke");
	private JMenuItem povezave = new JMenuItem("Barva povezave");
	private JMenuItem obrobe = new JMenuItem("Barva obrobe");
	private JMenuItem okno = new JMenuItem("Barva okna");
	private JMenuItem polmer = new JMenuItem("Polmer oznaèenih toèk");
	private JMenuItem imp = new JMenuItem("Uvozi iz .net");
	private JMenuItem exp = new JMenuItem("Izvozi v .net");
	private JMenuItem tex = new JMenuItem("Izvozi v .tex");
	private JMenuItem izhod = new JMenuItem("Izhod");
	/* moznosti nadaljevanja dela:
	 * da si v datoteki zapomni tudi polmere tock
	 * izvozi graf v tex datoteko (z moznostmi za barve ...)
	 * spreminjanje imen tock, moznost izpisa imen v oknu, moznost izpisa lastnosti tocke v oknu
	 * moznost nakljucnega in ciklicnega razporejanja ali v dve vrstici pri dvodelnem grafu
	 * pomoc (ukazi na tipkovnici)
	 */
	
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
		
		JMenu izgled = new JMenu("Izgled");
		
		tocke.addActionListener(this);
		izgled.add(tocke);
		povezave.addActionListener(this);
		izgled.add(povezave);
		obrobe.addActionListener(this);
		izgled.add(obrobe);
		aktivne.addActionListener(this);
		izgled.add(aktivne);
		oznacene.addActionListener(this);
		izgled.add(oznacene);
		izgled.addSeparator();
		polmer.addActionListener(this);
		izgled.add(polmer);
		
		mb.add(izgled);
		
		JMenu ie = new JMenu("Uvoz/izvoz");
		
		imp.addActionListener(this);
		ie.add(imp);
		exp.addActionListener(this);
		ie.add(exp);
		tex.addActionListener(this);
		ie.add(tex);
		
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
		} else if (e.getSource() == aktivne) {
			Color c = JColorChooser.showDialog(this,  "Izberi barvo aktivne toèke: ",  platno.barvaAktivne);
			platno.barvaAktivne = c;
		} else if (e.getSource() == oznacene) {
			Color c = JColorChooser.showDialog(this,  "Izberi barvo oznacene toèke: ",  platno.barvaOznacene);
			platno.barvaOznacene = c;
		} else if (e.getSource() == obrobe) {
			Color c = JColorChooser.showDialog(this,  "Izberi barvo obrobe: ",  platno.barvaObrobe);
			platno.barvaObrobe = c;
		} else if (e.getSource() == okno) {
			Color c = JColorChooser.showDialog(this,  "Izberi barvo okna: ",  platno.barvaOkna);
			platno.barvaOkna = c;
		} else if (e.getSource() == povezave) {
			Color c = JColorChooser.showDialog(this,  "Izberi barvo povezave: ",  platno.barvaPovezave);
			platno.barvaPovezave = c;
		} else if (e.getSource() == polmer) {
			String n = JOptionPane.showInputDialog("Vnesi število za polmer: ");
			for (Tocka v : platno.graf.tocke.values()) {
				if (v.oznacena) v.polmer = Integer.parseInt(n);
			}
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
		} else if (e.getSource() == tex) {
			JFileChooser fc = new JFileChooser();
			int option = fc.showSaveDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String ime = fc.getSelectedFile().getPath();
				try {  // https://www.sharelatex.com/learn/TikZ_package, https://www.sharelatex.com/blog/2013/08/27/tikz-series-pt1.html
					PrintWriter izhod = new PrintWriter(new FileWriter(ime)); // odpri za pisanje
					izhod.println("\\documentclass{article}\n\\usepackage{tikz}\n\\begin{document}");
					izhod.println("% https://www.sharelatex.com/learn/TikZ_package\n% https://www.sharelatex.com/blog/2013/08/27/tikz-series-pt1.html\n\\begin{tikzpicture}[scale=.05,auto=left]");
					for (Tocka tocka : platno.graf.tocke.values()) {
						for (Tocka sosed : tocka.sosedi) {
							izhod.println("\\draw[gray, thick] ("+tocka.x+","+tocka.y+") -- ("+sosed.x+","+sosed.y+");");
						}
					}
					for (Tocka tocka : platno.graf.tocke.values()) {
						izhod.println("\\filldraw[color=red, fill=red!20, very thick] ("+(tocka.x)+","+(tocka.y)+") circle ((120pt) node[anchor=center] {"+tocka.ime+"};");
					}
					izhod.println("\\end{tikzpicture}\n\n\\end{document}");
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
