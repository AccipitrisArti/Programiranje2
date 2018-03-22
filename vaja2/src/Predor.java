import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Predor {
	
	public static int prehitraVozila(String imeVhod, String imeIzhod) throws IOException {
		int stevilo = 0;
		
		DecimalFormatSymbols symbol = new DecimalFormatSymbols();
		symbol.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", symbol);
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod)); // odpri za branje
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod)); // odpri za pisanje
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim(); // preberi vrstico brez praznih znakov na zaèetku in na koncu
			if (vrstica.equals("")) continue; // preskoci prazne vrstice
			String[] besede = vrstica.split(" +"); // razrezi na presledkih, ignoriraj veè presledkov
			int t = Integer.parseInt(besede[1]);
			int s = Integer.parseInt(besede[0]);
			double povpV = 622/(t-s)*3600/1000;
			
			if (povpV > 80) {
				stevilo++;
				izhod.println(besede[2]+" "+df.format(povpV)); // napisi vrstico
			}
		}
		vhod.close();
		izhod.close();
		return stevilo;
	}
}
