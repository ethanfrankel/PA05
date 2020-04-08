package lesson19;

public class LoseImmunity extends Person {
	int lastInfected = 0;

	public LoseImmunity(int lastInfected) {
		// TODO Auto-generated constructor stub
		super();
		this.lastInfected = lastInfected;
	}

	@Override
	void tryToMove() {
		// TODO Auto-generated method stub
		tryToMoveRandomly();
	}
	
	void checkForInfection(){
		if (this.exposed && ! this.infected) {
				this.infected = true;
				this.infectionTime = this.age;
			}
			this.age++;
			if (this.infected && !this.recovered && (this.age - this.infectionTime > this.recoveryTime)) {
				this.recovered = true;
				this.infected = false;
				this.exposed = false;
				this.lastInfected = this.age;
			}
			if (this.recovered && (this.age - this.lastInfected > 3)) {
				this.recovered = false;
			}
		 }

}