
public class Odvod {
	
	public static void izpisOdvoda(double[] p, int n) {
		double[] odv = odvod(p, n);
		System.out.print("{");
		for (int i=0; i<odv.length; i++) {
			if (i == 0) {
				System.out.print(odv[i]);
			} else {
			System.out.print(", "+odv[i]);
			}
		}
		System.out.print("}");
	}
	
	private static double[] odvod(double[] p, int n) {
		final int LEN = p.length;
		if (LEN < n) {
			return new double[0];
		}
		if (n == 0) {
			return p;
		}
		double[] nova = new double[LEN - n];
		for (int i=0; i<nova.length; i++) {
			nova[i] = p[n+i];
			for (int j=1; j<=n; j++) {
				nova[i] = nova[i] * (j+i);
			}
		}
		return nova;
	}
}
