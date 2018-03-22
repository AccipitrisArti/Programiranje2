
public class Collatz {

	public static void main(String[] args) {
		/*
		System.out.println(collLen(10));
		System.out.println(collMax(10));
		collZap(10);
		Razcep.razcep(10);
		System.out.println(Poudarjanje.poudariCrke("Zadnja novica"));
		System.out.println(Poudarjanje.poudariBesede("Zadnja *novi*ca"));
		Odvod.izpisOdvoda(new double[] {1}, 1);
		Ena.vseEna(5);
		double[][] m = MnozenjeMatrik.zmnozi(new double[][] {{1,2},{1,2}}, new double[][] {{1,2},{1,2}});
		for (double[] vrstica : m) {
			for (double element : vrstica) {
				System.out.print(element + " ");
			}
			System.out.print("\n");
		}
		*/
	}
	
	private static int nasledni(int n) {
		if (n%2 == 0) {
			return n/2;
		} else {
			return n*3+1;
		}
	}
	
	private static int collLen(int n) {
		int k = 1;
		while (n > 1) {
			n = nasledni(n);
			k++;
		}
		return k;
	}
	
	private static int collMax(int n) {
		int m = n;
		while (n > 1) {
			n = nasledni(n);
			if (n > m) {
				m = n;
			}
		}
		return m;
	}
	
	private static void collZap(int n) {
		while (n > 1) {
			System.out.println(n);
			n = nasledni(n);
		}
		System.out.println(1);
	}
}
