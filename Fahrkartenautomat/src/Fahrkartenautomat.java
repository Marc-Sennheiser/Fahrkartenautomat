import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);
		double zwischensumme = 0;
		double zuZahlenderBetrag = 0;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		double preisEinerBestellung;
		
		int ticket;
		int ticketArt;
		System.out.println("Fahrkartenbestellvorgang:");
		System.out.println("=========================");
		System.out.println();
		//1
		do{
		System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
		
		System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
		System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
		System.out.println("Tageskarte AB [8,80 EUR] (3)");
		System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)");
		System.out.println("Bezahlen (9)");
		
		boolean istrichtig;
		do { System.out.print("Ihre Wahl:");
			ticketArt = tastatur.nextInt();
			 if (ticketArt == 9.0) {
				 zuZahlenderBetrag = 0;
	                break;
	                }
		istrichtig = ticketArt >= 1 && ticketArt <= 4;
		zuZahlenderBetrag = 1;
		if(istrichtig) {
		switch(ticketArt) {
		case 1: zuZahlenderBetrag = 2.00;
			break;
		case 2: zuZahlenderBetrag = 3.00;
			break;
		case 3: zuZahlenderBetrag = 8.80;
			break;
		case 4: zuZahlenderBetrag = 9.40;
			break;
			
		default:
			break;
		}
		}
		else { System.out.println(">>falsche Eingabe<<");
		}
		}while(!istrichtig);
		
		boolean istGueltig;
		
		do {
		    System.out.print("Anzahl der Tickets: ");
		    ticket = tastatur.nextInt();

		    istGueltig = ticket >= 1 && ticket <= 10;
		    if (istGueltig) {
		        System.out.println("Anzahl der Tickets: " + ticket );
		    } else {
		        System.out.println(">> Wählen sie bitte eine Anzahl von 1 bis 10 Tickets aus <<");
		    }
		} while (!istGueltig);
		preisEinerBestellung = zuZahlenderBetrag * (double) ticket;
		zwischensumme = zwischensumme + preisEinerBestellung;

	
	System.out.println("Zwischensumme:" + zwischensumme + " Euro");
		} while (ticketArt != 9);
	
		
		// 2
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0 ;
		while (eingezahlterGesamtbetrag < zwischensumme) {
			nochZuZahlen = zwischensumme - eingezahlterGesamtbetrag;
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
		rueckgabebetrag = eingezahlterGesamtbetrag - zwischensumme;
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

//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


