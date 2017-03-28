package insurancemodel;

/**
 * This is an abstract class containing two fields, policyNo and policyYear.
 * This class assigns policyNo's and years to all policies, allowing for easy
 * management of the insurance policies the company controls.
 * @author ruw12gbu
 */
public abstract class Policy {

    /*
     * Proected variables so that the BuildingPolicy, ContentPolicy, LifePolicy 
     * and CarPolicy classes can inherit these variables.
     */
    protected String policyNo; //Policy Number for this policy
    protected int policyYear; //Year of Issue for this policy

    /**
     * Constructor for Policy objects, that also checks and catches an policies 
     * with illegal policy numbers or years of issue.
     * @param newPolicyNo               the policy number for this given policy
     * @param newPolicyYear             the year of issue for this given policy
     * @throws IllegalPolicyException   catches any policies that have illegal 
     *                                  policy numbers or have years of issue 
     *                                  outside the boundaries of the project.
     *                                  This will return an error message when
     *                                  triggered.
     */
    public Policy(String newPolicyNo, int newPolicyYear)
            throws IllegalPolicyException 
    {
        this.policyNo = newPolicyNo; //assign the 
        this.policyYear = newPolicyYear;
        
        if (policyNo.charAt(0)=='B'|| policyNo.charAt(0) == 'C' || 
                policyNo.charAt(0) == 'L' || policyNo.charAt(0) == 'V')
        {
            //empty if statement
        }
        else
        {
            throw new IllegalPolicyException("Policy numbers must start with + "
                    + "B, C, L or V.");
        }
        
        if (policyYear >= 1990 && policyYear <= 2013) 
        {
            this.policyYear = policyYear; //if the year is okay, it assigns
        } 
        else 
        {
            throw new IllegalPolicyException("Invalid Year of Issue : " + 
                    policyYear + " is not in the range 1990 - 2013");
        }

    }
    
    /**
     * Accessor method to return the value of a particular policyNo
     * @return      the policy number for this Policy object as a String
     */
    public String getPolicyNo() 
    {
        return this.policyNo;
    }
    
    /**
     * Accessor method to return the value of a particular policyYear
     * @return      the policy year of this Policy object as an integer
     */
    public int getPolicyYear() 
    {
        return this.policyYear;
    }
    
    /**
     * Abstract method for BuildingPolicy, ContentPolicy, CarPolicy 
     * and LifePolicy to use.
     * @return  the premium that is calculated in the BuildingPolicy,
     *          ContentPolicy,CarPolicy or LifePolicy.
     */
    abstract double getPremium();

    //String builder to print out the policyNo and policyYear variables.
    
    /**
     * toString method that uses StringBuilder to create a String that can be
     * returned in the main and used in the output.
     * @return      returns a string that can be called for an output
     */
    public String toString() 
    {
        //Variable that can be called to quickly create a newLine
        String newLine = "\n";
        
        //Creates and initalises a StringBuilder object
        StringBuilder builder = new StringBuilder();

        builder.append("Policy Number: ");
        builder.append(getPolicyNo()); //calls getPolicyNo() method
        builder.append(newLine);
        builder.append("Policy Year: ");
        builder.append(getPolicyYear()); //calls getPolicyYear() method
        builder.append(newLine);

        return builder.toString();
    }
}
