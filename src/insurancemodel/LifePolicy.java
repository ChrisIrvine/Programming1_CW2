package insurancemodel;

/**
 * This is a class to create and control all life insurance policies. 
 * It contains details of the age of policy holder, amount for which the life
 * is covered and the estimated health risk the holder possess, on a scale from
 * 0 (lowest) to 5 (highest).
 * @author ruw12gbu
 */
public class LifePolicy extends Policy
{
    private int ageOfHolder; //age of the policy holder
    //the amount that the life of the holder is insured for
    private int insuredAmount;
    private double healthRisk; //health risk posed to the holder
    private double lifePremium; //the premium for the Life Insurance Policy
    private final int AGE_BARRIER = 70;
    
    /**
     * Constructor for the LifePolicy class. Takes variables that are 
     * inherited from the Policy class and that are parsed in from the InputData 
     * class.
     * @param policyYear                inherited int variable from Policy.java  
     *                                  that is the year of issue for this 
     *                                  policy
     * @param policyNo                  inherited String variable from 
     *                                  Policy.java that is the unique number of
     *                                  this policy
     * @param newAgeOfHolder            the age of the policy holder for this 
     *                                  LifePolicy object
     * @param newInsuredAmount          the amount the life of the holder is 
     *                                  insured for, for this LifePolicy object.
     * @param newHealthRisk             the health risk posed to the holder of 
     *                                  this LifePolicy object.
     * @throws IllegalPolicyException   catches any policyNos or policyYears 
     *                                  that are out-width their boundaries and 
     *                                  prints an error message.
     */
    public LifePolicy (int policyYear, String policyNo, int newAgeOfHolder, 
            int newInsuredAmount, double newHealthRisk) 
            throws IllegalPolicyException
    {
        super(policyNo, policyYear);
        
        IllegalPolicyException polNumException = new IllegalPolicyException
            ("Life Policy Numbers must start with B");
        
        if (policyNo.startsWith("L") == false)
        {
            throw polNumException;
        }
        else
        {
        this.ageOfHolder = newAgeOfHolder;
        this.insuredAmount = newInsuredAmount;
        this.healthRisk = newHealthRisk;
        }
    }
    
    /**
     * Accessor method for retrieving the age of the policy holder.
     * @return          returns an int value with the age of the holder of this
     *                  LifePolicy object.
     */
    public int getAgeOfHolder()
    {
        return this.ageOfHolder;
    }
    
    /**
     * Accessor method for retrieving the amount the life is covered for.
     * @return          returns an int value with the amount the life of the 
     *                  holder of this LifePolicy object is insured for
     */
    public int getInsuredAmount()
    {
        return this.insuredAmount;
    }
    
    
    /**
     * Accessor method for retrieving the health risk posed to the policy holder
     * @return          returns a double value that is the health risk posed to 
     *                  the holder of this LifePolicyObject. This is on a scale 
     *                  of 0(lowest) to 5(highest)
     */
    public double getHealthRisk()
    {
        return this.healthRisk;
    }
    
    
    /**
     * Mutator method for changing the age of the policy holder.
     * @param newAgeOfHolder        the new age of this LifePolicy holder
     */
    public void setAgeOfHolder(int newAgeOfHolder)
    {
        this.ageOfHolder = newAgeOfHolder;
    }
    
    
    /**
     * Mutator method for changing the amount the life is insured for.
     * @param newInsuredAmount      the new amount the life of this LifePolicy's
     *                              holder is insured for.
     */
    public void setInsuredAmount(int newInsuredAmount)
    {
        this.insuredAmount = newInsuredAmount;
    }
    
    
    /**
     * Mutator method for changing the health risk posed to the policy holder.
     * @param newHealthRisk         the new double value for this LifePolicy's
     *                              holder health risk
     */
    public void setHealthRisk(double newHealthRisk)
    {
        this.healthRisk = newHealthRisk;
    }

    /**
     * Abstract method that is inherited from Policy to calculate the premiums
     * for Life Insurance policies.
     * @return      the calculated premium for a this LifePolicy object.
     */
    @Override
    public double getPremium() 
    {   
        lifePremium = (insuredAmount / 1000) * (1 + healthRisk);
        if (ageOfHolder > AGE_BARRIER)
        {
            lifePremium = lifePremium*(ageOfHolder / AGE_BARRIER);
        }
        return lifePremium;
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
        
        builder.append("Building Insurance Policy Number: ");
        builder.append(getPolicyNo());
        builder.append(newLine);
        builder.append("Year the Policy was created: ");
        builder.append(getPolicyYear());
        builder.append(newLine);
        builder.append("Age of Policy Holider: ");
        builder.append(getAgeOfHolder());
        builder.append(" years old");
        builder.append(newLine);
        builder.append("The amount that the life is insured for: £");
        builder.append(getInsuredAmount());
        builder.append(newLine);
        builder.append("Health risk to the policy holder: ");
        builder.append(getHealthRisk());
        builder.append(newLine);
        builder.append("Premium for this Policy is: £");
        builder.append(getPremium());
        builder.append(newLine);
        
        return builder.toString();
    }
}
