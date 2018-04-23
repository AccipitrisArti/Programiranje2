package risanjeGrafov;

public class Test {

	public static void main(String[] args) {
		Okno okno = new Okno(500, 500);
		okno.pack();
		okno.setVisible(true);
		Graf g = Graf.poln(8);
		g.razporedi(250, 250, 100);
		okno.platno.narisi(g);
	}

}
