import java.util.*;
import java.io.*;
public class DataProject{
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("collegeAthleticsFinancing.csv");
        schoolTuitionComparedToAthletics(f);
        conferenceRelationToSupport(f);
        schoolEndowmentsComparedToAthletics(f);
    }

    
    //determining if the tuition of a school has a relation to the amount of money the school puts into their athletics in 2014
    public static void schoolTuitionComparedToAthletics(File dataset) throws FileNotFoundException{
        Scanner sc = new Scanner(dataset);

        //grab first line of file as header and split into strings
            //put in an arraylist
        String[] header = sc.nextLine().split(",");
        ArrayList<String> headerList = new ArrayList<>(Arrays.asList(header));

        //initalize an AL of doubles storing the instate-tuition of each school
        ArrayList<Double> instateTuition = new ArrayList<>();
        //initalize an AL of doubles storing the Athletics Financing of each school 
            //would be direct institution support + government support + indrect admin support
        ArrayList<Double> totalSupport = new ArrayList<>();

        //find index of instate tuition in header
        int instateT = headerList.indexOf("instate_tuition");
        //find index of direct institutional support in header
        int totalInstitutionalSupport = headerList.indexOf("inflation_adjusted_direct_institutional_support");
        //find index of government support in header
        int totalGovSupport = headerList.indexOf("inflation_adjusted_direct_state_govt_support");
        //find index of indirect admin support
        int indirectAdminSupport = headerList.indexOf("inflation_adjusted_indirect_facil_admin_support");
        //find index of year 
        int year = headerList.indexOf("year");

        //go through each line of the file (while there is still a line remaining)
        while(sc.hasNextLine()){
            //split up the line (which is a string) in an AL of strings
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            //chech if current line is for the year 2014
            if(line.get(year).equals("2014")){
                //if true - add tuition of the each school to specific index of AL instateTuition and add total support to second AL
                instateTuition.add(Double.parseDouble(line.get(instateT)));
                totalSupport.add(Double.parseDouble(line.get(totalInstitutionalSupport)) + Double.parseDouble(line.get(totalGovSupport)) + Double.parseDouble(line.get(indirectAdminSupport)));
            }
        }
        //call method to calculate the correlation coefficient - print out result
        System.out.println(calcCorrelationCoeff(instateTuition, totalSupport));
    }

    //determining if conferences will have higher average supports if the schools that are a part of them have higher rankings/more well-known in 2014
    public static void conferenceRelationToSupport(File dataset) throws FileNotFoundException {
         Scanner sc = new Scanner(dataset);

        //grab first line of file as header and split into strings
            //put in an arraylist
        String[] header = sc.nextLine().split(",");
        ArrayList<String> headerList = new ArrayList<>(Arrays.asList(header));

        //initalize an AL of AL of doubles storing the Athletics Financing of each school for each conference
            //would be direct institution support + government support + indirect admin support
        ArrayList<ArrayList<Double>> totalSupport = new ArrayList<>();
        //initalize an AL of conference corresponding to the AL of AL of financing
        ArrayList<String> conferences = new ArrayList<>(Arrays.asList("Southeastern Conference", "Pacific-12 Conference", "American Athletic Conference", "Atlantic Coast Conference", "Big Ten Conference", "Big 12 Conference", "America East Conference", "Atlantic 10 Conference", "Atlantic Sun Conference", "Big Sky Conference", "Big South Conference", "Big West Conference", "Colonial Athletic Association", "Conference USA", "Horizon League", "Independent", "Mid-American Conference", "Mid-Eastern Athletic Conference", "Missouri Valley Conference", "Mountain West Conference", "Northeast Conference", "Ohio Valley Conference", "Southern Conference", "Southland Conference", "Southwestern Athletic Conference", "Sun Belt Conference", "The Summit League", "Western Athletic Conference"));
        //create empty AL within totalSupport AL to be filled later
        for(int i=0; i<conferences.size(); i++){
            totalSupport.add(new ArrayList<Double>());
        }
       
        //find index of conference in header 
        int conferenceIndex = headerList.indexOf("conference");
        //find index of direct institutional support in header
        int totalInstitutionalSupport = headerList.indexOf("inflation_adjusted_direct_institutional_support");
        //find index of government support in header
        int totalGovSupport = headerList.indexOf("inflation_adjusted_direct_state_govt_support");
        //find index of indirect admin support
        int indirectAdminSupport = headerList.indexOf("inflation_adjusted_indirect_facil_admin_support");
        //find index of year 
        int year = headerList.indexOf("year");

        //go through each line of the file (while there is still a line remaining)
        while(sc.hasNextLine()){
            //split up the line (which is a string) in an AL of strings
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            //check if current line is for the year 2014 and if so, add total support to AL, whose index corresponds to the conference it is a part of
            if(line.get(year).equals("2014")){
                 totalSupport.get(conferences.indexOf(line.get(conferenceIndex))).add(Double.parseDouble(line.get(totalInstitutionalSupport)) + Double.parseDouble(line.get(totalGovSupport)) + Double.parseDouble(line.get(indirectAdminSupport)));
            }
        }
        
        //create AL to hold averages
        ArrayList<Double> averages = new ArrayList<>();
        //loop to loop through AL of AL just created to find the total support average of each conference
        for(int i=0; i<conferences.size(); i++){
            double total = 0;
            for(int j=0; j<totalSupport.get(i).size(); j++){
                total += totalSupport.get(i).get(j);
            }
            averages.add(total);
        }

        //print out conferences
        System.out.println("Confereces: ");
        System.out.println(conferences);
        //print out average support for each conference
        System.out.println("Support Averages: ");
        System.out.println(averages);

    }

    //determining if the endownment of a school has a relation to the amount of money the school puts into their athletics in 2014
    public static void schoolEndowmentsComparedToAthletics(File dataset) throws FileNotFoundException{
        Scanner sc = new Scanner(dataset);

        //grab first line of file as header and split into strings
            //put in an arraylist
        String[] header = sc.nextLine().split(",");
        ArrayList<String> headerList = new ArrayList<>(Arrays.asList(header));

        //initalize an AL of doubles storing the endowments of each school
        ArrayList<Double> endowment = new ArrayList<>();
        //initalize an AL of doubles storing the Athletics Financing of each school 
            //would be direct institution support + government support + indirect admin support
        ArrayList<Double> totalSupport = new ArrayList<>();

        //find index of endowment in header
        int schoolEndow = headerList.indexOf("inflation_adjusted_endowments");
        //find index of direct institutional support in header
        int totalInstitutionalSupport = headerList.indexOf("inflation_adjusted_direct_institutional_support");
        //find index of government support in header
        int totalGovSupport = headerList.indexOf("inflation_adjusted_direct_state_govt_support");
        //find index of indirect admin support
        int indirectAdminSupport = headerList.indexOf("inflation_adjusted_indirect_facil_admin_support");
        //find index of year 
        int year = headerList.indexOf("year");

        //go through each line of the file (while there is still a line remaining)
        while(sc.hasNextLine()){
            //split up the line (which is a string) into an AL of strings
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            //check if current line is for the year 2014 and if so, add endowment of school at current line to AL and add totalSupport of school to second AL
            if(line.get(year).equals("2014")){
                endowment.add(Double.parseDouble(line.get(schoolEndow)));
                totalSupport.add(Double.parseDouble(line.get(totalInstitutionalSupport)) + Double.parseDouble(line.get(totalGovSupport)) + Double.parseDouble(line.get(indirectAdminSupport)));
            }
        }

        //calculate the correlation coefficient and print out result
        System.out.println(calcCorrelationCoeff(endowment, totalSupport));
    }

    //function to calculate the correlation coefficient between two given arraylists
    public static double calcCorrelationCoeff(ArrayList<Double> x, ArrayList<Double> y){
        //calculate mean of x
        double meanX = mean(x);
        //calculate mean of y
        double meanY = mean(y);

        //create counter arraylist to hold values of difference in x * difference in y
        ArrayList<Double> counter = new ArrayList<>();
        for(int i=0; i<x.size(); i++){
            counter.add((x.get(i)-meanX)*(y.get(i)-meanY));
        }

        //sum the counter arraylist to find the value of the numerator
        double totalNumerator = 0;
        for(int i=0; i<counter.size(); i++){
            totalNumerator += counter.get(i);
        }

        //create arraylists to find and store the error values between the Xs and error values between the Ys
        ArrayList<Double> errorSquaresX = new ArrayList<>();
        ArrayList<Double> errorSquaresY = new ArrayList<>();

        //loop to find find the difference between each x-vaule and the meanX and square it - and same for y
        for(int i=0; i<x.size(); i++){
            errorSquaresX.add(Math.pow((x.get(i)-meanX),2));
            errorSquaresY.add(Math.pow((y.get(i)-meanY),2));
        }

        //initalize variables to hold the total values in arraylist of errors in Xs and errors in Ys
        double totalX = 0;
        double totalY = 0;
        //loop to add up all the values from each arraylist
        for(int i=0; i<errorSquaresX.size(); i++){
            totalX += errorSquaresX.get(i);
            totalY += errorSquaresY.get(i);
        }

        //create variable to hold value of denominator 
            //square root of totalX multiplied by totalY
        double denominator = Math.sqrt(totalX*totalY);
        
        //return numerator/denominator
        return totalNumerator/denominator;
    }

    //function to calculate the mean of an arraylist
    public static double mean(ArrayList<Double> list){
        //initalize variable to hold total of all values in AL
        double total = 0;
        //loop to add up all total values
        for(int i=0; i<list.size(); i++){
            total += list.get(i);
        }
        //return total of all values/ # elements in the list
        return total/list.size(); 
    }
}
