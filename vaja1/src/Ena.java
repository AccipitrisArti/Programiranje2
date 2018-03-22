
public class Ena {
	
	public static String[] vseEna(int n) {
		String[] cleni = new String[n];
		String novClen = "1";
		cleni[0] = novClen;
		for (int i=1; i<n; i++) {
			novClen = naslednji(novClen);
			cleni[i] = novClen;
		}
		return cleni;
	}
	
	private static String naslednji(String clen) {
		String nov = "";
		int stevilo = 0;
		char zadnji = clen.charAt(0);
		for (int i=0; i<clen.length(); i++) {
			if (clen.charAt(i) == zadnji) {
				stevilo++;
			} else {
				nov += "" + stevilo + zadnji;
				stevilo = 1;
			}
			zadnji = clen.charAt(i);
		}
		nov += "" + stevilo + zadnji;
		return nov;
	}
}
