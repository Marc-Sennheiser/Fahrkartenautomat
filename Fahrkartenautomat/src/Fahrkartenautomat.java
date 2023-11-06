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
		
		
		if (zuZahlenderBetrag >= 1.00 && zuZahlenderBetrag <= 10.00) {
			System.out.println("Der Ticketpreis beträgt nun: " + zuZahlenderBetrag + " Euro");
		} else {
		    System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt");
		    zuZahlenderBetrag = 1;    
		}
		
		System.out.print("Anzahl der kaufenden Tickets:");
		ticket = tastatur.nextInt(); 
		if (ticket >= 1 && ticket <= 10) {
			System.out.println("Die Ticketanzahl beträgt nun: " + ticket + " Tickets");
		}
		else {
			System.out.println("Fehlerhafte Eingabe - Ticketanzahl wird auf 1 gesetzt");
			ticket = 1;
		}
		
		zuZahlenderBetrag *= ticket;
		
		
		// 2
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0 ;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
		 
			boolean gueltigeEingabe = false;
			while (!gueltigeEingabe) {
			System.out.print("Eingabe (mind. 5 Cent, höchstens 50 Euro z.B. 0,05 oder 50): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			if (eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.10 || eingeworfeneMuenze == 0.2 || eingeworfeneMuenze == 0.5 || eingeworfeneMuenze == 1 || eingeworfeneMuenze == 2 || eingeworfeneMuenze == 5 || eingeworfeneMuenze == 10 ||eingeworfeneMuenze == 20 || eingeworfeneMuenze == 50) {
			gueltigeEingabe = true;
				
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
			} else {
			System.out.println("Ungültige Eingabe! Bitte geben Sie einen gültigen Betrag ein: 0,1  0,2  0,5  1  2  5  10  20  50");
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

			 while (rueckgabebetrag >= 20.0) { // 20-Euro-Schein
					System.out.println("20 Euro Schein");
					rueckgabebetrag = rueckgabebetrag - 20.0;
					rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			 }
			 while (rueckgabebetrag >= 10.0) { // 10-Euro-Schein
					System.out.println("10 Euro Schein");
					rueckgabebetrag = rueckgabebetrag - 10.0;
					rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			 }
			 while (rueckgabebetrag >= 5.0) { // 5-Euro-Schein
					System.out.println("5 Euro Schein");
					rueckgabebetrag = rueckgabebetrag - 5.0;
					rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			 }		
			 while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro Münze");
				rueckgabebetrag = rueckgabebetrag - 2.0;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro Münze");
				rueckgabebetrag = rueckgabebetrag - 1.0;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent Münze");
				rueckgabebetrag = rueckgabebetrag - 0.5;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent Münze");
				rueckgabebetrag = rueckgabebetrag - 0.2;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent Münze");
				rueckgabebetrag = rueckgabebetrag - 0.1;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;

			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent Münze");
				rueckgabebetrag = rueckgabebetrag - 0.05;
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}

//Token
//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