package lesson19;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numOthers;
  int numFrequentFliers;
  int numLoseImmunity;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numOthers, int numFrequentFliers, int numLoseImmunity){
    super(numShelterInPlace + numEssential + numOthers + numFrequentFliers + numLoseImmunity);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numOthers = numOthers;
    this.numFrequentFliers = numFrequentFliers;
    this.numLoseImmunity = numLoseImmunity;
  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    for(int i=0; i<this.numOthers; i++){
      this.addPerson(new Skeptic());
    }
    for(int i=0; i<this.numFrequentFliers; i++){
      this.addPerson(new FrequentFlier());
    }
    for(int i=0; i<this.numLoseImmunity; i++){
      this.addPerson(new LoseImmunity(0));
    }
  }
}
