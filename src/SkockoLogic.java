
import java.util.LinkedList;
import java.util.Random;

public class SkockoLogic {

	public static int brojZnaka(Znakovi znak) {
		if (znak == Znakovi.PIK) {
			return 1;
		}
		if (znak == Znakovi.HERC) {
			return 2;
		}
		if (znak == Znakovi.KARO) {
			return 3;
		}
		if (znak == Znakovi.TREF) {
			return 4;
		}
		if (znak == Znakovi.SKOCKO) {
			return 5;
		}
		if (znak == Znakovi.ZVEZDA) {
			return 6;
		}

		return 0;
	}

	public static Znakovi znakBroja(int broj) {
		if (broj == 1) {
			return Znakovi.PIK;
		}
		if (broj == 2) {
			return Znakovi.HERC;
		}

		if (broj == 3) {
			return Znakovi.KARO;
		}
		if (broj == 4) {
			return Znakovi.TREF;
		}
		if (broj == 5) {
			return Znakovi.SKOCKO;
		}
		if (broj == 6) {
			return Znakovi.ZVEZDA;
		}

		return null;
	}

	public static int naDobrojPoziciji(int index, int broj, LinkedList<Integer> kombinacija) {

		if (kombinacija.get(index) == broj) {
			return 1;
		}

		return 0;
	}

	public static LinkedList<Integer> randomKombinacija() {
		Random r = new Random();
		LinkedList<Integer> k = new LinkedList<Integer>();

		for (int i = 0; i < 4; i++) {
			k.add(r.nextInt(6) + 1);
		}

		return k;
	}

}
