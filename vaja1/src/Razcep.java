
public class Razcep {
	public static void razcep(int n) {
		System.out.print(n);
		String znak = " = ";
		for (int i=2; n > 1; i++) {
			int potenca = 0;
			while (n%i == 0) {
				n = n/i;
				potenca++;
			}
			if (potenca == 1) {
				System.out.print(znak + i);
				znak = " * ";
			} else if (potenca > 1) {
				System.out.print(znak + i + "^" + potenca);
				znak = " * ";
			}
		}
	}
}
