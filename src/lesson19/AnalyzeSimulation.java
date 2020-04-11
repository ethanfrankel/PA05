package lesson19;
public class AnalyzeSimulation{
    //runs will be the number of times it loops (one hundred). 
    public int runs=0;
    //public int increment=1; 
    //Assume a tick is one day
    public int totalnumOfDays=100000; 
    public int totalnumOfInfected=0; 
    public int totalpeakInfectedLevel=0;
    
    public AnalyzeSimulation(int runs){
        this.runs = runs;
        /*this.runs = 0;
        *
        * while (this.runs != runs) {
        *   this.runs+=increment;
        *   }
        */
    }
    public void setinfected(int infected){
        this.totalnumOfInfected=this.totalnumOfInfected+infected;
    }
    public void setdays(int days){
        tthis.totalnumOfDays=this.totalnumOfDays+days;
    }
    public void getaveragestats(){
        double avginfected=this.totalnumOfInfected/this.totalnumOfDays;
        System.out.println(avginfected);
    }

}
