import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		int ticket;

		// 1
		System.out.print("Zu zahlender Betrag (Euro): ");
		zuZahlenderBetrag = tastatur.nextDouble();
		System.out.print("Anzahl der kaufenden Tickets:");
		ticket = tastatur.nextInt(); 
		zuZahlenderBetrag *= ticket;
		
		// 2
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0 ;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
		 
			boolean gueltigeEingabe = false;
			while (!gueltigeEingabe) {
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro z.B. 0,05 oder 2): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			if (eingeworfeneMuenze >= 0.05 && eingeworfeneMuenze <= 2.00) {
			gueltigeEingabe = true;
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
			} else {
			System.out.println("Ungültige Eingabe! Bitte geben Sie einen Betrag zwischen 0,05 und 2,00 Euro ein.");
		}
	 }
	}
		
		// 3
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
		
		// 4
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			 System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
			 System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}

//Token
//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