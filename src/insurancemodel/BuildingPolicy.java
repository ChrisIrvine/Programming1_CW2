package insurancemodel;

/**
 * This is a class to create and control all building insurance policies.
 * It contains details of the estimated cost of rebuilding, risk of insuring
 * the building and premium of the insurance policy.
 * @author ruw12gbu
 */
public class BuildingPolicy extends Policy
{
    private double rebuildCost;//The estimated cost of rebuild
    private double insuranceRisk;//Number between 1 (high risk) and 0 (low risk)
    private final double BUILDING_CONSTANT = 0.001;
    
    /**
     * Constructor for the BuildingPolicy class. Takes variables that are 
     * inherited from the Policy class and that are parsed in from the InputData 
     * class.
     * @param policyYear                inherited int variable from Policy.java  
     *                                  that is the year of issue for this 
     *                                  policy
     * @param policyNo                  inherited String variable from 
     *                                  Policy.java that is the unique number of
     *                                  this policy 
     * @param newRebuildCost            the estimated cost of rebuilding the 
     *                                  building if it were to collapse
     * @param newInsuranceRisk          the risk (1 being the highest, 0 being 
     *                                  the lowest) that the insurance 
     *                                  company is taking on with this 
     *                                  BuildingPolicy
     * @throws IllegalPolicyException   catches any policyNos and policyYears 
     *                                  that are out-width their boundaries
     */
    public BuildingPolicy(int policyYear, String policyNo, 
            double newRebuildCost, double newInsuranceRisk) 
            throws IllegalPolicyException
    {
        super(policyNo, policyYear); //Inherits the variables from Policy.java
        
        IllegalPolicyException polNumException = new IllegalPolicyException
                ("Building Policy Numbers must start with B");
        
        if (policyNo.startsWith("B") == false)
        {
            throw polNumException;
        }
        else
        {
           this.rebuildCost = newRebuildCost;
           this.insuranceRisk = newInsuranceRisk;
        }
        
    }

    /**
     * Accessor method for retrieving the estimated cost of rebuilding
     * @return      a double value that is the estimated cost of rebuilding for 
     *              this BuildingPolicy object.
     */
    public double getRebuildCost()
    {
        return this.rebuildCost;
    }
    
    /**
     * Accessor method for retrieving the risk of insurance attached to this
     * policy.
     * @return      a double value that is the estimated risk attached to the
     *              company taking on this BuildingPolicy object. 
     *              (1 high - 0 low)
     */
    public double getInsuranceRisk()
    {
        return this.insuranceRisk;
    }

    /**
     * Mutator method for changing the estimated cost of rebuilding
     * @param newRebuildCost    the new estimated cost of rebuilding for this 
     *                          BuildingPolicy object.
     */
    public void setRebuildCost(double newRebuildCost)
    {
        this.rebuildCost = newRebuildCost;
    }

    /**
     * Mutator method for changing the risk of insurance attached to this policy
     * @param newInsuranceRisk     the new estimated risk for this 
     *                             BuildingPolicy object.
     */
    public void setInsuranceRisk(double newInsuranceRisk)
    {
        this.insuranceRisk = newInsuranceRisk;
    }
    
    /**
     * Abstract method that is inherited from Policy to calculate the premiums
     * for Life Insurance policies.
     * @return      the calculated premium for a this LifePolicy object.
     */
    @Override
    public double getPremium() 
    {
         return this.rebuildCost*BUILDING_CONSTANT*(1+this.insuranceRisk);
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
        builder.append("Risk of Insuring the Building: ");
        builder.append(getInsuranceRisk());
        builder.append(newLine);
        builder.append("Cost of Rebuilding the Property: £");
        builder.append(getRebuildCost());
        builder.append(newLine);
        builder.append("Premium for this policy: £");
        builder.append(getPremium());
        builder.append(newLine);
        
        return builder.toString();
    }
}
