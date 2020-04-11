package lesson19;

import java.util.Random;
/**
 *  
 * @author tim
 *
 */

public class RunSimulation {
	// the maximum number of days the simulation will run
	private static int MAX_TICKS=1000;

	private Random random = new Random();

	public static void main(String[] args) {
		// first we get the simulation parameters
		// from the command line

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFrequentFliers = Integer.parseInt(args[5]);
		int numLoseImmunity = Integer.parseInt(args[6]);

		// next we create the population and the country
		Population population;

		//population = new Population(numPeople);
		//population = new AllStayAtHome(numPeople);
		//int numEssential = numPeople/10;
		//int numOther = numPeople/20;
		//int numStayHome = numPeople - numEssential - numOther;
		population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFliers, numLoseImmunity);
		population.createPeople();

		Country country = new Country(width,height);
		// and add a link to the population in the country
		country.population = population;
		// next we place the people into the country randomly
		population.placePeople(country);
		
		AnalyzeSimulation as = new AnalyzeSimulation(100); //run the simulation 100 times
		int iterations = 0;
		
		while(iterations <= 100) {
			System.out.println("Initial State of the Country");
			country.printCountry();

			System.out.println("\nTracking the Infection");
			for(int k=0;k<MAX_TICKS; k++) {
				country.simulateOneStep();
				country.printState(k);

				if (country.numInfected==0) {
					break;

				}
			}
			
			if(iterations == 100){
				System.out.println("Average statistics:");
				data.setinfected(country.getnuminfected());
				data.getaveragestats();
			}
			//print the statistics for each run 
			else{
				System.out.println("\nFinal State of the Country");
				country.printCountry();
				System.out.println(" ");
				country.printStats();
				//set  numOfDays, numOfInfected, peakInfectedLevel
			}
			
			iterations++;

		}

	}


}
