package ReadingFromAndWritingToTextFiles;

// ****************************************************************************
// Warning.java
// @author DZAKIRA
//
// Reads student data (name, semester hours, quality points) from a
// text file, computes the GPA, then writes data to another file
// if the student is placed on academic warning.
// ****************************************************************************

import java.util.Scanner;
import java.io.*;
public class Warning{

    public static void main (String[] args){
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String name;
        String inputName = "D:\\APPL\\APPL_Week2\\src\\" + 
                "ReadingFromAndWritingToTextFiles\\students.dat";
        String outputName = "D:\\APPL\\APPL_Week2\\src\\" + 
                "ReadingFromAndWritingToTextFiles\\warning.dat";
        
        Scanner inFile = null;
        PrintWriter outFile = null;

        try{
            // Set up scanner to input file
            inFile = new Scanner(new File(inputName));
            // Set up the output file stream
            outFile = new PrintWriter(new FileWriter(outputName));
            // Print a header to the output file
            outFile.println ("\nStudents on Academic Warning\n");
            // Process the input file, one token at a time
            while (inFile.hasNext()){
                String[] input = inFile.nextLine().split(" ");
            // Get the credit hours and quality points and
                name = input[0];
                creditHrs = Integer.parseInt(input[1]);
                qualityPts = Double.parseDouble(input[2]);
                
            // determine if the student is on warning. If so,
            // write the student data to the output file.
                gpa = qualityPts/creditHrs;
                if((gpa < 1.5 && creditHrs < 30) || 
                    (gpa < 1.75 && creditHrs < 60) ||
                    (gpa < 2.0)){
                    
                    outFile.write(name + " "+ creditHrs + " " + gpa + "\n");
                }
            }
            // Close output file
             outFile.close();
        }catch (FileNotFoundException e){
            System.out.println ("The file " + inputName + " was not found.");
        }catch (IOException e){
            System.out.println ("Something goes wrong with the input/output stream");
        }catch (NumberFormatException e){
            System.out.println ("Format error in input file ");
            System.out.println("The Format should be : ");
            System.out.println("contain the student name (a single String" +
                                "with no spaces), the number of semester hours" + 
                                "earned (an integer), the total quality points" + 
                                "earned (a double).Every element separated by space");
        }
    }
}