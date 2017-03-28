package insurancemodel;

/**
 * This is a class to create and control all content insurance policies.
 * It contains details of the insured value of the content and the risk of 
 * insuring the contents. 
 * @author ruw12gbu
 */
public class ContentPolicy extends Policy
{
    private double insuredValue; //Amount the contents are insured for
    private double insuranceRisk;//Number between 1 (high risk) and 0 (low risk)
    private final double CONTENT_FACTOR = 0.01;
    
    /**
     * Constructor for the ContentPolicy class. Takes variables that are 
     * inherited from the Policy class and that are parsed in from the InputData 
     * class.
     * @param policyYear                inherited int variable from Policy.java  
     *                                  that is the year of issue for this 
     *                                  policy
     * @param policyNo                  inherited String variable from 
     *                                  Policy.java that is the unique number of
     *                                  this policy
     * @param newInsuredValue           double variable that is the amount the
     *                                  contents are insured for
     * @param newInsuranceRisk          double variable that is the risk posed 
     *                                  to the company in accepting this policy.
     *                                  Value between 1 (high risk) and 0 (low 
     *                                  risk).
     * @throws IllegalPolicyException   Catches any policy number or years that 
     *                                  are out-width their bounds.
     */
    public ContentPolicy (int policyYear, String policyNo,
            double newInsuredValue, double newInsuranceRisk) 
            throws IllegalPolicyException
    {
        super(policyNo, policyYear); //inherting the values from Policy.java
        
        IllegalPolicyException polNumException = new IllegalPolicyException
                ("Content Policy Numbers must start with C");
        
        if (policyNo.startsWith("C") == false)
        {
            throw polNumException;
        }
        else
        {
        this.insuredValue = newInsuredValue;
        this.insuranceRisk = newInsuranceRisk;
        }
    }
    
    /**
     * Accessor method for retrieving the amount the contents are insured for.
     * @return      returns a double value that contains the value that the 
     *              contents are insured for, for this ContentPolicy object.
     */
    public double getInsuredValue()
    {
        return this.insuredValue;
    }
    
    /**
     * Accessor method for retrieving the risk of insurance for this policy.
     * @return      returns a double value that contains the insurance risk for 
     *              this ContentPolicy object
     */
    public double getInsuranceRisk()
    {
        return this.insuranceRisk;
    }
    
    /**
     * Mutator method for altering the value the contents are insured for.
     * @param newInsuredValue       The new value the contents are insured for
     *                              to replace the old value.
     */
    public void setInsuredValue(double newInsuredValue)
    {
        this.insuredValue = newInsuredValue;
    }
        
    /**
     * Mutator method for altering the estimated risk for this insurance policy.
     * @param newInsuranceRisk      The new insurance risk value to replace the
     *                              old insurance risk value
     */
    public void setInsuranceRisk(double newInsuranceRisk)
    {
        this.insuranceRisk = newInsuranceRisk;
    }
    
    /**
     * Abstract method that is inherited from Policy to calculate the premiums
     * for Content Insurance policies. 
     * @return      the calculated premium for a this ContentPolicy object.
     */
    @Override
    double getPremium() 
    {
        return this.insuredValue*CONTENT_FACTOR*(1+this.insuranceRisk);
    }
    
    /**
     * toString method that uses StringBuilder to create a string that can be 
     * returned and called in the main to output.
     * @return      object that can be called and used to output a string.
     */
    @Override
    public String toString()
    {
        //Variable that can be called to quickly create a newLine
        String newLine = "\n";
        
        //Creates and initalises a StringBuilder object
        StringBuilder builder = new StringBuilder();
        
        builder.append("Content Insurance Policy Number: ");
        builder.append(getPolicyNo()); //calls getPolicyNo() method
        builder.append(newLine);
        builder.append("Year the Policy was created: ");
        builder.append(getPolicyYear()); //calls getPolicyYear() method
        builder.append(newLine);
        builder.append("Risk of insuring the contents: ");
        builder.append(getInsuranceRisk()); //calls getInsuranceRisk() method
        builder.append(newLine);
        builder.append("Value contents are insured for: £");
        builder.append(getInsuredValue()); //calls getInsuredValue() method
        builder.append(newLine);
        builder.append("Premium for this policy: £");
        builder.append(getPremium()); //calls getPremium() abstract method
        builder.append(newLine);
        
        return builder.toString();
    }
}
