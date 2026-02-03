package dat102.f06.diverse;

import java.util.Arrays;

public class MaksITabell {
	
	public static void main(String[] args) {
		
		int[] tabell = {-4, 5, 12, 0, 3, 7, -2, 3};
		
		System.out.println("Den største verdien i tabellen " 
				+ Arrays.toString(tabell) + " er " + maksTab1(tabell));
		System.out.println("Den største verdien i tabellen " 
				+ Arrays.toString(tabell) + " er " + maksTab2(tabell));
		System.out.println("Den største verdien i tabellen " 
				+ Arrays.toString(tabell) + " er " + maksTab3(tabell));
	}

    /* En iterativ løsning */
	static int maksTab1(int[] tab) {
		int maks = tab[0];
		for (int i=1; i<tab.length; i++) {
			if (tab[i] > maks) {	// Kunne brukt Math.max() her i stedet
				maks = tab[i];		// ..
			}						// ..
		}
		return maks;
	}

    /* "Skallmetode" for den rekursive løsningen */
	static int maksTab2(int[] tab) {
		return maksTab2(tab, 0, tab.length-1);
	}
    /* En rekursiv løsning */
	static int maksTab2(int[] tab, int start, int slutt) {
		
		if (start == slutt) { //basistilfelle
			return tab[start];
		}
		int midten = (start + slutt) / 2;
		int maksVenstre = maksTab2(tab, start, midten);
		int maksHoyre = maksTab2(tab, midten + 1, slutt);

		return maksVenstre >= maksHoyre ? maksVenstre : maksHoyre;
	}

    /* "Skallmetode" for den mer kompakte rekursive løsningen */
	static int maksTab3(int[] tab) {
		return maksTab3(tab, 0, tab.length-1);
	}
    /* Den rekursive løsningen skrevet på en mer kompakt måte */
	static int maksTab3(int[] tab, int v, int h) {
		return (v == h) //basistilfelle
				? tab[v]
				: Math.max(maksTab3(tab, v, (v+h)/2), maksTab3(tab, (v+h)/2+1, h));
	}
}
