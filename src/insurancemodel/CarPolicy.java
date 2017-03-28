package insurancemodel;

/**
 * This is class to create and control all vehicle insurance policies.
 * It contains details of the estimated value of the vehicle being insured,
 * the age of the driver, the number of years in which there has been no claims 
 * on the insurance and if the policy is fully comprehensive or not. 
 * @author ruw12gbu
 */
public class CarPolicy extends Policy
{
    private double carValue; //Value of the vehicle
    //No driver can be insured if they are younger than 17 or older than 99.
    private int driverAge; //Age of the driver who is being insured.
    private int noClaimYears; //Number of years no claim has been made
    private boolean comprehensive; //True if fully comprehensive, False if not.
    private double carPremium; //Variable to hold the premium
    
    /**
     * Constructor for the CarPolicy class. Takes variables that are 
     * inherited from the Policy class and that are parsed in from the InputData 
     * class.
     * @param policyYear                inherited int variable from Policy.java  
     *                                  that is the year of issue for this 
     *                                  policy
     * @param policyNo                  inherited String variable from 
     *                                  Policy.java that is the unique number of
     *                                  this policy
     * @param newCarValue               the current value that the vehicle is 
     *                                  valued at for this CarPolicy object
     * @param newDriverAge              the age of the driver for this
     *                                  CarPolicy object.
     * @param newNoClaimYears           the number of years there has been no 
     *                                  claims on this policy
     * @param newComprehensive          true if it is comprehensive, false if
     *                                  is not comprehensive for this 
     *                                  CarPolicy object.
     * @throws IllegalPolicyException   Catches if the policyNo or policyYear 
     *                                  are out-width their boundaries.
     */
    public CarPolicy (int policyYear, String policyNo, double newCarValue, 
            int newDriverAge, int newNoClaimYears, boolean newComprehensive) 
            throws IllegalPolicyException
    {
        super(policyNo, policyYear); //inherting the values from Policy.java
        
        IllegalPolicyException polNumException = new IllegalPolicyException
                ("Car Policy Numbers must start with B");
        
        if (policyNo.startsWith("V") == false)
        {
            throw polNumException;
        }
        else
        {
        this.carValue = newCarValue;
        this.driverAge = newDriverAge;
        this.noClaimYears = newNoClaimYears;
        this.comprehensive = newComprehensive;
        carPremium = 0;
        }
    }
    
    /**
     * Accessor method for retrieving the estimated value of the vehicle.
     * @return      the estimated value of the vehicle being insured for this
     *              CarPolicy object.
     */
    public double getCarValue()
    {
        return this.carValue;
    }
    
    /**
     * Accessor method for retrieving the age of the driver.
     * @return      the age of the driver of the vehicle on this CarPolicy 
     *              object.
     */
    public int getDriverAge()
    {
        return this.driverAge;
    }
    
    /**
     * Accessor method for retrieving the number of years no claim has been made
     * @return      the number of years that there has been no claim made on 
     *              this policy for this CarPolicy object.
     */
    public int getNoClaimYears()
    {
        return this.noClaimYears;
    }
    
    /**
     * Accessor method to determine if the policy if full comprehensive or not.
     * @return      returns true if it is comprehensive, false if it is not
     *              comprehensive - for this CarPolicy object. 
     */
    public boolean getComprehensive()
    {
        return this.comprehensive;
    }
    
    /**
     * Mutator method for changing the estimated value of the car for this
     * CarPolicy object.
     * @param newCarValue   double value for the new estimated value of the 
     *                      vehicle that is attached to CarPolicy object
     */
    public void setCarValue(double newCarValue)
    {
        this.carValue = newCarValue;
    }
    
    /**
     * Mutator method for changing the age of the driver that is assigned to 
     * this CarPolicy object.
     * @param newDriverAge  int value for the new age of the driver of the 
     *                      vehicle for this CarPolicy object.
     */
    public void setDriverAge(int newDriverAge)
    {
        this.driverAge = newDriverAge;
    }
    
    /**
     * Mutator method for changing the number of years no claim has been made.
     * @param newNoClaimYears   int value containing the number of years that 
     *                         there has been no claim on this CarPolicy object.
     */
    public void setNoClaimYears(int newNoClaimYears)
    {
        this.noClaimYears = newNoClaimYears;
    }
    
    /**
     * Mutator method for changing if the policy is comprehensive or not.
     * @param newComprehensive      true if comprehensive, false if not
     */
    public void setComprehensive(boolean newComprehensive)
    {
        this.comprehensive = newComprehensive;
    }

    /**
     * Abstract method that is inherited from Policy to calculate the premiums
     * for Car Insurance policies.
     * @return      the calculated premium for a this CarPolicy object.
     */
    @Override
    double getPremium() 
    {
        carPremium = Math.max(100, (carValue*0.10));
        
        if(comprehensive == true)
        {
            carPremium = carPremium*1.50;
        }
        
        if(driverAge < 17 || driverAge > 25)
        {
            carPremium = carPremium*1.50;
        }
        
        if(noClaimYears <= 5)
        {
            carPremium = carPremium*0.925;
        }
        
        return carPremium;
    }
    
    /**
     * toString method that uses StringBuilder to create a string that can be 
     * returned and called in the main to output.
     * @return      object that can be called and used to output a String
     */
    @Override
    public String toString()
    {
        //Variable that can be called to quickly create a newLine
        String newLine = "\n";
        
        //Creates and initalises a StringBuilder object
        StringBuilder builder = new StringBuilder();
        
        builder.append("Vehicle Insurance Policy No: ");
        builder.append(getPolicyNo());
        builder.append(newLine);
        builder.append("Year of Issue: ");
        builder.append(getPolicyYear());
        builder.append(newLine);
        builder.append("Value of Vehicle: £");
        builder.append(getCarValue());
        builder.append(newLine);
        builder.append("Age of Driver: ");
        builder.append(getDriverAge());
        builder.append(" years old");
        builder.append(newLine);
        builder.append("Years of no claims: ");
        builder.append(getNoClaimYears());
        builder.append(" years");
        builder.append(newLine);
        builder.append("Fully comprehensive: ");
        builder.append(getComprehensive());
        builder.append(newLine);
        builder.append("Premium for this Policy: £");
        builder.append(getPremium());
        builder.append(newLine);
        
        return builder.toString();
    }
}
