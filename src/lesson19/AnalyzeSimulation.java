package lesson19;
public class AnalyzeSimulation{
    //runs will be the number of times it loops (one hundred). 
    public int runs=0;
    //Assume a tick is one day
    public int totalnumOfDays=100000; 
    public int totalnumOfInfected=0; 
    public int totalpeakInfectedLevel=0;
    
    public AnalyzeSimulation(int runs){
        runs=this.runs;
    }
    public void setinfected(int infected){
        totalnumOfInfected=this.totalnumOfInfected+infected;
    }
    public void setdays(int days){
        totalnumOfDays=this.totalnumOfDays+days;
    }
    public void getaveragestats(){
        double avginfected=this.totalnumOfInfected/this.totalnumOfDays;
        System.out.println(avginfected);
    }

}
