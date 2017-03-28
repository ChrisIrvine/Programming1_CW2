package insurancemodel;

import java.io.*;
import java.util.Scanner;

/**
 * The purpose of this class is to read in and manipulate the text
 * file using the Scanner class. From there it separates out the values
 * to a point in which the variables can be assigned to their proper
 * place within the program.
 * @author  ruw12gbu
 */
public class InputData {

    /**
     * 
     * @param inputFile                 object of type File that contains the 
     *                                  file-path for the text file, containing 
     *                                  the information required to run this 
     *                                  program.
     * @return                          storeArray - an array with all the 
     *                                  dissected information 
     * @throws IOException              Catches errors whilst locating, reading
     *                                  and opening the file.
     * @throws IllegalPolicyException   Catches errors regarding the policyNo 
     *                                  variables and the policyYears, checking
     *                                  that they are in the correct format/
     *                                  within the bounds of the program.
     */
    public static ClientDetailsList readFile(File inputFile) throws IOException,
            IllegalPolicyException 
    {     
        Scanner inputScan = null;
        
        //Try/Catch to catch errors with reading/locating the file
        try
        {
            inputScan = new Scanner(inputFile);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        //Create a new StringBuilder object
        StringBuilder dataBuilder = new StringBuilder();

        //Create a new ClientDetailsList object
        ClientDetailsList storeList = new ClientDetailsList();

        //Create a new String Array
        String[] strArray = null;

        //While loop to keep the Scanner object reading the next line
        while (inputScan.hasNext()) 
        {
            dataBuilder.append(inputScan.nextLine());
        }

        //Split the file into individual lines
        strArray = dataBuilder.toString().split("#"); 

        //for loop to iterate over the text file, that is held in the strArray
        for (String iterator : strArray) 
        {
            //Split the lines into columns
            String[] line = iterator.split("/");
            
            String clientID = line[0]; //assign the clientID
            String nameTitle = line[1]; //assign the title
            String nameInitials = line[2]; //assign the initials
            String nameSurname = line[3]; //assign the surname
            String addressStreet = line[4]; //assign the street
            String addressTown = line[5]; //assign the town or city
            String addressPostcode = line[6]; //assign the postcode
            int policyYear = 0; //initialise the policyYear variable
            //initialise the currCol variable, used to navigate
            int currCol = 0;
            
            //Create a PolicyList object, polListArray
            PolicyList polListArray = new PolicyList();
            
            //assign the name variables in a new Name object
            Name name = new Name(nameTitle, nameInitials, nameSurname);
            //assign the address variables in a new Address object
            Address address = new Address(addressStreet, addressTown, 
                    addressPostcode);
            
            //assign the current column to 7, for the switch statement
            currCol = 7; 

            /*
             * Switch statement to designate which policies are which, based of
             * the policyNo. If the first character in the policyNo is a 'C' it
             * is ContentPolicy, if it is a 'L' is a LifePolicy, if it 'V' it is  
             * a CarPolicy and if its a 'B' it is a BuildingPolicy.
             *
             * The currCol, as mentioned before is used to navigate the lines 
             * and columns of the text file. Before each switch statement the 
             * currCol is always set to 7. That way the switch statement can 
             * navigate through the columns to pull specific pieces of 
             * information by adding numbers to the currCol value. After a 
             * policy is designated and its values sorted then the currCol is
             * increased by the number of values that policy had attached to it.
             */
            switch (line[currCol + 1].charAt(0)) 
            {
                case 'C':
                    int policyYearCon = Integer.parseInt(line[currCol]);
                    String policyNoCon = line[currCol + 1];
                    double insuredValueCon = 
                            Double.parseDouble(line[currCol + 2]);
                    double riskCon = Double.parseDouble(line[currCol + 3]);
                    ContentPolicy contentPolicy = new ContentPolicy
                    (policyYearCon, policyNoCon, insuredValueCon, riskCon);
                    polListArray.addPolicy(contentPolicy);
                    currCol += 4;
                    break;
                case 'L':
                    int policyYearLife = Integer.parseInt(line[currCol]);
                    String policyNoLife = line[currCol + 1];
                    int insuredAmount = Integer.parseInt(line[currCol + 2]);
                    int ageOfHolder = Integer.parseInt(line[currCol + 3]);
                    double riskLife = Double.parseDouble(line[currCol + 4]);
                    LifePolicy lifePolicy = new LifePolicy(policyYearLife, 
                            policyNoLife, ageOfHolder, insuredAmount, riskLife);
                    polListArray.addPolicy(lifePolicy);
                    currCol += 5;
                    break;
                case 'B':
                    int policyYearBuild = Integer.parseInt(line[currCol]);
                    String policyNoBuild = line[currCol + 1];
                    double rebuildCost = Double.parseDouble(line[currCol + 2]);
                    double riskBuild = Double.parseDouble(line[currCol + 3]);
                    BuildingPolicy buildingPolicy = new BuildingPolicy
                    (policyYearBuild, policyNoBuild, rebuildCost, riskBuild);
                    polListArray.addPolicy(buildingPolicy);
                    currCol += 4;
                    break;
                case 'V':
                    int policyYearCar = Integer.parseInt(line[currCol]);
                    String policyNoCar = line[currCol + 1];
                    double carValue = Double.parseDouble(line[currCol + 2]);
                    int driverAge = Integer.parseInt(line[currCol + 3]);
                    int noClaimYears = Integer.parseInt(line[currCol + 4]);
                    boolean comprehensive = 
                            Boolean.parseBoolean(line[currCol + 5]);
                    CarPolicy carPolicy = new CarPolicy(policyYearCar, 
                            policyNoCar, carValue, driverAge, noClaimYears, 
                            comprehensive);
                    polListArray.addPolicy(carPolicy);
                    currCol += 6;
                    break;
            }
            storeList.addClient(new ClientDetails(clientID, name,
                    address, polListArray));
        }
        return storeList;
    }
}
