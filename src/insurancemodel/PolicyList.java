package insurancemodel;
import java.util.ArrayList;

/**
 * The PolicyList Class is used to represent a collection of Policy 
 * objects. It contains methods to add a policy to the collection, 
 * give the number of policies in the collection and a method to print
 * all of this information out.
* @author    ruw12gbu
 */
public class PolicyList 
{    
    ArrayList<Policy> policies;
    
    /**
     * Constructor for the PolicyList class. Creates a new ArrayList of type
     * Policy.
     */
    public PolicyList()
    {
        policies = new ArrayList<>();
    }
    
    /**
     * Method to return the number of policies in the ArrayList. 
     * @return  Uses the .size() method in the ArrayList class to return the
     *          number of policies 
     */
    public int numberOfPolicies()
    {
        return policies.size();
    }
    
    /**
     * Method to add a new policy, by calling the Policy constructor, to the 
     * policies ArrayList.
     * @param policy    Policy object that contains the information necessary to 
     *                  execute the constructor of the Policy class.
     */
    public void addPolicy(Policy policy)
    {
        this.policies.add(policy);
    }
    
    public Policy getPolicy(int index)
    {
        return this.policies.get(index);
    }
    
    /**
     * toString method that utilises a StringBuilder, to build a string that is
     * then returned and executed in the main.
     * @return      String containing the policy information
     */
    @Override
    public String toString()
    {
        //Variable that can be called to quickly create a newLine
        String newLine = "\n";
        
        //Creates and initalises a StringBuilder object
        StringBuilder builder = new StringBuilder();

        if (this.policies != null)
        {
            for(Policy policy : this.policies)
            {
                builder.append(policy.toString());
                builder.append(newLine);
            }
        }
        return builder.toString();
    }
}
