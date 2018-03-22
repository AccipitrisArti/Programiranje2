
public class Poudarjanje {
	public static String poudariCrke(String niz) {
		niz = niz.toUpperCase();
		String poudarjen = "" + niz.charAt(0);
		for (int i=1; i<niz.length(); i++) {
			poudarjen = poudarjen + " " + niz.charAt(i);
 		}
		return poudarjen;
	}
	
	public static String poudariBesede(String niz) {
		boolean poudari = false;
		String poudarjen = "";
		for (int i=0; i<niz.length(); i++) {
			if (niz.charAt(i) == '*') {
				poudari = !poudari;
			} else if (poudarjen.length() == 0) {
				if (poudari) {
					poudarjen = "" + niz.toUpperCase().charAt(i);
				} else {
					poudarjen = "" + niz.charAt(i);
				}
			} else if (poudari) {
				poudarjen = poudarjen + " " + niz.toUpperCase().charAt(i);
			} else {
				poudarjen = poudarjen + " " + niz.charAt(i);
			}			
 		}
		return poudarjen;
	}
}
