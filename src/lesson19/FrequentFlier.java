package lesson19;

public class FrequentFlier extends Person {

	public FrequentFlier() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	void tryToMove() {
		// TODO Auto-generated method stub
		//tryToMoveRandomly();

		int i = random.nextInt(this.country.places.length);
	    int j = random.nextInt(this.country.places[i].length);
	    while (this.country.places[i][j] != null) {
	      // loop to make sure it is an open space ...
	      i = random.nextInt(this.country.places.length);
	      j = random.nextInt(this.country.places[i].length);
	    }
	    if (isOK(i, j,this.country)) {
	       this.moveTo(i, j);
	    }
	   
	}

}
