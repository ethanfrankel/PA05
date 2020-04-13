package lesson19;

public class AnalyzeSimulation {
	int totalPeakInfectedLevel = 0;
	int totalNumAffected = 0;
	int totalNumOfDays = 0;
	int avgPeakInfectedLevel = 0;
	int avgNumAffected = 0;
	int avgNumOfDays = 0;

	public AnalyzeSimulation() {

	}

	public void addStats(int peakInfectedLevel, int numAffected, int numOfDays) {
		this.totalPeakInfectedLevel = this.totalPeakInfectedLevel + peakInfectedLevel;
		this.totalNumAffected = this.totalNumAffected + numAffected;
		this.totalNumOfDays = this.totalNumOfDays + numOfDays;
	}

	public void getAverageStats(int numSimulations) {
		this.avgPeakInfectedLevel = this.totalPeakInfectedLevel / numSimulations;
		this.avgNumAffected = this.totalNumAffected / numSimulations;
		this.avgNumOfDays = this.totalNumOfDays / numSimulations;
		System.out.println(" ");
		System.out.println("Average Statistics");
		System.out.println("Days: " + this.avgNumOfDays);
		System.out.println("Total Infections: " + this.avgNumAffected);
		System.out.println("Infected at Peak: " + this.avgPeakInfectedLevel);
	}

}
