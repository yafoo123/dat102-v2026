package dat102.f06.diverse;

public class Fakultet {

	public static void main(String[] args) {
		System.out.println("5! = " + fakultet1(5));
		System.out.println("5! = " + fakultet2(5));
		System.out.println("5! = " + fakultet3(5));
	}

    /* En iterativ løsning */
	static int fakultet1(int n) {
		int svar = 1;
		for (int i=1; i<=n; i++) {
			svar *= i;
		}
		return svar;
	}

    /* En rekursiv løsning */
	static int fakultet2(int n) {
		if (n <= 1) { // basistilfelle
			return 1;
		} else {
			return n * fakultet2(n - 1);
		}
	}

    /* Den samme rekursive løsningen med bruk av ?: i stedet for if-else */
	static int fakultet3(int n) {
		return (n <= 1)	? 1	: n * fakultet2(n - 1);
	}
	
}
