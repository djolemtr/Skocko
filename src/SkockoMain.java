import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class SkockoMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int pokusaj = 0;
		int naDobrojPoziciji = 0;
		int pogodjeni = 0;
		int partije = 1;
		int poeni = 0;

		LinkedList<Integer> unetiZnakovi = new LinkedList<Integer>();
		LinkedList<Integer> kombinacija = SkockoLogic.randomKombinacija();

		System.out.println("Znakovi se unose jedan ispod drugog, klikom na enter. Dozvoljeno je 7 pokusaja.");

		while (pokusaj < 7) {
			pokusaj += 1;

			System.out.println("Unesite znakove: ");

			for (int i = 0; i < 4; i++) {

				Znakovi znak;

				while (true) {
					String input = scan.nextLine().toUpperCase();

					switch (input) {
					case "PIK":
						znak = Znakovi.PIK;
						break;
					case "HERC":
						znak = Znakovi.HERC;
						break;
					case "KARO":
						znak = Znakovi.KARO;
						break;
					case "TREF":
						znak = Znakovi.TREF;
						break;
					case "SKOCKO":
						znak = Znakovi.SKOCKO;
						break;
					case "ZVEZDA":
						znak = Znakovi.ZVEZDA;
						break;

					default:
						System.out.println("Znak nije validan. Unesite znak ponovo:");

						continue;
					}

					break;

				}

				unetiZnakovi.add(SkockoLogic.brojZnaka(znak));

				naDobrojPoziciji += SkockoLogic.naDobrojPoziciji(i, SkockoLogic.brojZnaka(znak), kombinacija);

			}

			for (int a = 1; a < 7; a++) {
				if (unetiZnakovi.contains(a)) {
					pogodjeni += Collections.frequency(kombinacija, a);
				}
			}

			System.out.println();
			System.out.println("Na dobroj poziciji: " + naDobrojPoziciji);
			System.out.println("Pogodjenih : " + pogodjeni);
			System.out.println("Pokusaj: " + pokusaj);

			System.out.println();
			System.out.print("Uneti znakovi: ");
			for (int i : unetiZnakovi) {
				System.out.print(SkockoLogic.znakBroja(i) + " ");
			}

			System.out.println();

			// test blok

			// System.out.print("Tacna kombinacija: ");
			// for (int i : kombinacija) {
			// System.out.print(SkockoLogic.znakBroja(i) + " ");
			// }
			// System.out.println();

			// test blok

			if (naDobrojPoziciji == 4) {
				System.out.println();
				System.out.println("Tacna kombinacija!");

				if (pokusaj < 6) {
					poeni += 30;
				} else if (pokusaj == 6) {
					poeni += 20;
				}
				System.out.println();
				System.out.print("Nova igra? (da/ne) ");

				boolean novaIgra = false;

				while (true) {
					String input = scan.nextLine().toUpperCase();

					switch (input) {
					case "DA":
						novaIgra = true;

						break;
					case "NE":
						break;

					default:
						System.out.println("Odgovor nije validan. Unesite da ili ne.");

						continue;
					}

					break;

				}

				if (novaIgra) {
					partije++;
					pokusaj = 0;
					naDobrojPoziciji = 0;
					pogodjeni = 0;
					unetiZnakovi.clear();
					kombinacija = SkockoLogic.randomKombinacija();
				} else {
					System.out.println();
					System.out.println("Broj odigranih partija: " + partije);
					System.out.println("Broj poena: " + poeni);

					break;

				}

			}

			if (pokusaj == 7) {
				System.out.println();
				System.out.print("Nemate vise pokusaja. Tacna kombinacija je bila: ");
				for (int i : kombinacija) {
					System.out.print(SkockoLogic.znakBroja(i) + " ");
				}

				System.out.println();
				System.out.print("Nova igra? (da/ne) ");

				boolean novaIgra = false;

				while (true) {
					String input = scan.nextLine().toUpperCase();

					switch (input) {
					case "DA":
						novaIgra = true;

						break;
					case "NE":
						break;

					default:
						System.out.println("Odgovor nije validan. Unesite da ili ne.");

						continue;
					}

					break;

				}

				if (novaIgra) {
					partije++;
					pokusaj = 0;
					kombinacija = SkockoLogic.randomKombinacija();
				} else {
					System.out.println();
					System.out.println("Broj odigranih partija: " + partije);
					System.out.println("Broj poena: " + poeni);

					break;

				}

			}

			System.out.println();
			naDobrojPoziciji = 0;
			pogodjeni = 0;
			unetiZnakovi.clear();

		}

		scan.close();
	}

}
