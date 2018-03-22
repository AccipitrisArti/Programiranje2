import java.io.*;
import java.util.*;

public class FrekvenceBesed {
	
	public static Map<String, Integer> slovar(String imeVhod) throws IOException {
		Map<String, Integer> slovarBesed = new HashMap<String, Integer>();
		Set<String> vseBesede = new HashSet<String>();
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod)); // odpri za branje
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim(); // preberi vrstico brez praznih znakov na zaèetku in na koncu
			if (vrstica.equals("")) continue; // preskoci prazne vrstice
			StringTokenizer st = new StringTokenizer(vrstica, " .,!?:;"); // odstrani nastete znake
			while (st.hasMoreTokens()) {
				String beseda = st.nextToken();
				if (!vseBesede.contains(beseda)) {
					vseBesede.add(beseda);
					slovarBesed.put(beseda, 1);
				} else {
					slovarBesed.put(beseda, slovarBesed.get(beseda)+1);
				}
			}
		}
		vhod.close();
		return slovarBesed;
	}
	
	public static String[] padajoceFrekvence(Map<String, Integer> besede) throws IOException {
		String[] seznamBesed = new String[besede.size()];
		int k = 0;
		for (String beseda : besede.keySet()) {
			seznamBesed[k] = beseda;
			k++;
		}
		for (int i=0; i<seznamBesed.length; i++) {
			String max = seznamBesed[i];
			for (int j=i+1; j<seznamBesed.length; j++) {
				if (besede.get(seznamBesed[j])>besede.get(max)) {
					seznamBesed[i] = seznamBesed[j];
					seznamBesed[j] = max;
					max = seznamBesed[i];
				}
			}
		}
		return seznamBesed;
	}
	
	public static Map<String, Integer> slovarBrez(String imeVhod, Set<String> ignoriraj) throws IOException {
		Map<String, Integer> slovarBesed = slovar(imeVhod);
		for (String beseda : ignoriraj) {
			slovarBesed.remove(beseda);
		}
		return slovarBesed;
	}
	
	public static void izpisiZaporedno(Map<String,Integer> besedilo, String[] besede) {
		for (String beseda : besede) {
			System.out.println(beseda + ": " + besedilo.get(beseda));
		}
	}
}
