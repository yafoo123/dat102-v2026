package dat102.f04.lenketbag;

public class LenketBag<T> implements BagADT<T> {

	/*
	 * Vi kunne like godt hatt Node i en egen fil Node.java slik vi gjorde
	 * i forrige time/eksempel, og slik dere er vant med, men siden den kun
	 * brukes internt i LenketBag trenger den ikke være public. Den kan være
	 * en private klasse inni LenketBag (en såkalt inner class).
	 * 
	 * Bortsett fra plasseringen, er den en helt vanlig klasse.
	 */
	private class Node {
		
		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}

	/************************************************************/

	private Node forste;
	private int antall;
	
	public LenketBag() {
		forste = null;
		antall = 0;
	}
	
	/************************************************************/

	@Override
	public int getNumberOfEntries() {
		return antall; 
	}

	@Override
	public boolean isEmpty() {
		return antall == 0;
	}

	@Override
	public boolean add(T newEntry) {
		//TODO - Legger inn først i listen siden det er enklest
        Node ny = new Node (newEntry);
        ny.neste = forste;
        forste = ny;
        antall++;
		return true;
	}

	@Override
	public T remove() {
		//TODO - Vi må først sjekke om tom siden det da ikke er noe å fjerne
		//TODO - Fjerner den første siden det er enklest

        if (antall == 0){
            return null;
        }

        T temp = forste.data;
        forste = forste.neste;
        antall--;
		return temp;
	}

	@Override
	public boolean remove(T anEntry) {
		//TODO - Forslag til fremgangsmåte:
		// 1) Finn referanse til den som skal fjernes, null hvis ikke funnet.
		//   Lage en privat hjelpemetode Node finnNode(T entry) for dette?
        Node p = finnNode(anEntry);

		// 2) Hvis ikke funnet, så return false.
        if(p == null){
            return false;
        }

		// 3) Triks: Fjerning kan gjøres ved å overskrive data med data fra
		//   første node, og deretter fjerne første node.
		p.data = forste.data;
        forste = forste.neste;
		return false;
	}
	
	/* Private hjelpemetode til bruk i f.eks. remove(T e);
	 * Returnerer referanse til node hvis funnet, ellers null.
	 */
	private Node finnNode(T entry) {
		Node p = forste;
        while(p != null){
            if(p.data.equals(entry)){
                return p;
            }
            else{
                p = p.neste;
            }
        }
        return null;
	}

	@Override
	public void clear() {
		//TODO - Forslag til fremgangsmåte:
		// Her kan vi bruke remove() som hjelpemetode og gå i en løkke.
		// Evt. bare nullstille medlemsvariabler.
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		//TODO - Litt tilsvarende søkemetoden finnNode(T entry)
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		//TODO
		// Her kan vi bruke getFrequencyOf(T anEntry) som hjelpemetode?
		// Eller kanskje enda enklere, søkemetoden finnNode(T entry)
		return false;
	}

	@Override
	public T[] toArray() {
		// Starter med å lage tabellen elementene skal settes inn i.
		// Hva hvis tom? Lage en tabell med plass til 0 elementer?
		@SuppressWarnings("unchecked")
		T[] resultat = (T[]) new Object[antall];

		//TODO Deretter er det å kopiere over elementene.

		return resultat;
	}
	
	/*
	 * Legger til en metode for traversering og utskrift.
	 * Ikke en del av BagADT-kontrakten.
	 */
	public void skrivUt() {
		Node denne = forste;
		while(denne != null) {
			System.out.println(denne.data);
			denne = denne.neste;
		}
	}

}
