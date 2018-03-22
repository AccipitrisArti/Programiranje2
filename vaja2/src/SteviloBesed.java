import java.io.*;
import java.util.Map;

public class SteviloBesed {

	public static void main(String[] args) throws IOException {
		// System.out.println(stetje("src\\hisa.txt", "src\\hiska.txt"));
		// System.out.println(Predor.prehitraVozila("src\\podatki.txt", "src\\prehitra_vozila.txt"));
		// System.out.println(FrekvenceBesed.slovar("src\\hisa.txt"));
		Map<String,Integer> ign = FrekvenceBesed.slovar("src\\SloStopWords.txt");
		Map<String,Integer> slovar = FrekvenceBesed.slovarBrez("src\\hisa.txt", ign.keySet());
		String[] padajocSeznam = FrekvenceBesed.padajoceFrekvence(slovar);
		FrekvenceBesed.izpisiZaporedno(slovar, padajocSeznam);
	}
	
	private static int stetje(String imeVhod, String imeIzhod) throws IOException {
		int stevilo = 0;
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod)); // odpri za branje
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod)); // odpri za pisanje
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim(); // preberi vrstico brez praznih znakov na zaèetku in na koncu
			if (vrstica.equals("")) continue; // preskoci prazne vrstice
			String[] besede = vrstica.split(" +"); // razrezi na presledkih, ignoriraj veè presledkov
			for (String beseda : besede) {
				stevilo++;
				izhod.println(beseda); // napisi vrstico
			}
		}
		vhod.close();
		izhod.close();
		return stevilo;
	}
}
