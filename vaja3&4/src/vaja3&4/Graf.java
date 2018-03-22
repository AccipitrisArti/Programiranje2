package vaja3;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Graf {
	
	protected Map<Object, Tocka> tocke;
	
	public Graf() {
		tocke = new TreeMap<Object, Tocka>();
	}
	
	public Tocka tocka(Object ime) {
		return tocke.get(ime);
	}
	
	public boolean povezava(Tocka v1, Tocka v2) {
		return v1.sosedi.contains(v2);
	}
	
	public void dodajTocko(Tocka v) {
		if (!tocke.containsKey(v.ime)) tocke.put(v.ime, v);
	}
	
	public void dodajPovezavo(Tocka v1, Tocka v2) {
		if (v1 != v2 && tocke.containsKey(v1.ime) && tocke.containsKey(v2.ime)) {
			v1.sosedi.add(v2);
			v2.sosedi.add(v1);
		}
	}
	
	public void odstraniPovezavo(Tocka v1, Tocka v2) {
		v1.sosedi.remove(v2);
		v2.sosedi.remove(v1);
	}
	
	public void odstraniTocko(Tocka v) {
		for (Tocka tocka : v.sosedi) {
			odstraniPovezavo(v, tocka);
		}
		tocke.remove(v.ime);
	}
	
	public static Graf prazen(int n) {
		Graf g = new Graf();
		for (int i=1; i<=n; i++) g.dodajTocko(new Tocka(i));
		return g;
	}
	
	public static Graf cikel(int n) {
		Graf g = prazen(n);
		for (int i=2; i<=n; i++) {
			g.dodajPovezavo(g.tocke.get(i), g.tocke.get(i-1));
		}
		g.dodajPovezavo(g.tocke.get(n), g.tocke.get(1));
		return g;
	}
	
	public static Graf poln(int n) {
		Graf g = prazen(n);
		for (int i=1; i<n; i++) {
			for (int j=i+1; j<=n; j++) {
				g.dodajPovezavo(g.tocka(i), g.tocka(j));
			}
		}
		return g;
	}
	
	public static Graf polnDvodelen(int n, int m) {
		Graf g = prazen(n+m);
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				g.dodajPovezavo(g.tocke.get(i), g.tocke.get(n+j));
			}
		}
		return g;
	}
	
	public boolean povezan() {
		if (this.tocke.keySet().size() == 0) return true;
		Graf preverba = this;
		Set<Object> odstrani = new TreeSet<Object>();
		odstrani.add(this.tocke.keySet().iterator().next());
		while (odstrani.size() != 0) {
			for (Object imeTocke : odstrani) {
				for (Object imeSoseda : preverba.tocka(imeTocke).sosedi) {
					odstrani.add(imeSoseda);
				}
				preverba.odstraniTocko(preverba.tocka(imeTocke));
			}
		}
		return preverba.tocke.keySet().size() == 0;		
	}
	
	public int steviloKomponent() {
		if (this.tocke.keySet().size() == 0) return 0;
		Graf preverba = this;
		int stevilo = 0;
		Set<Object> odstrani = new TreeSet<Object>();
		odstrani.add(preverba.tocke.keySet().iterator().next());
		while (preverba.tocke.keySet().size() != 0) {
			for (Object imeTocke : odstrani) {
				for (Object imeSoseda : preverba.tocka(imeTocke).sosedi) {
					odstrani.add(imeSoseda);
				}
				preverba.odstraniTocko(preverba.tocka(imeTocke));
			}
			if (odstrani.size() == 0 && preverba.tocke.keySet().size() != 0) {
				stevilo++;
				odstrani.add(preverba.tocke.keySet().iterator().next());
			}
		}
		stevilo++;
		return stevilo;		
	}
	
	public void izpis() {
		for (Object imeTocke : this.tocke.keySet()) {
			System.out.print(imeTocke + " ");
			String locilo = "- ";
			for (Object imeSoseda : this.tocke.get(imeTocke).sosedi) {
				System.out.print(locilo + imeSoseda);
				locilo = ", ";
			}
			System.out.print("\n");
		}
	}
	
	public void razporedi(int x, int y, int r) {
		int steviloTock = this.tocke.keySet().size();
		int i = 0;
		for (Object imeTocke : this.tocke.keySet()) {
			this.tocke.get(imeTocke).x = x + r * Math.sin(2 * i * Math.PI / steviloTock);
			this.tocke.get(imeTocke).y = y + r * Math.cos(2 * i * Math.PI / steviloTock);
			i++;	
		}
		
	}
	
}
