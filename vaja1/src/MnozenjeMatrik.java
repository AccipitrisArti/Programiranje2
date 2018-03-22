
public class MnozenjeMatrik {
	
	public static double[][] zmnozi(double[][] a, double[][] b) {
		if (a[0].length != b.length) return null;
		double[][] produkt = new double[a.length][b[0].length];
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<b[0].length; j++) {
				for (int k=0; k<b.length; k++) {
					produkt[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return produkt;
	}
}
