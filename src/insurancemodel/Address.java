package insurancemodel;

/**
 * Class to handle and manage the addresses of the Policy Holders. This includes
 * the street, town/city and postcode components of the address. Accessor and 
 * Mutator methods for each of the fields. 
 * @author ruw12gbu
 */
public class Address implements Comparable<Address> 
{
    private String street; //Street where the client lives
    private String town; //Town where the client lives
    private String postcode; //Postcode of the clients residence
    
    /**
     * Constructor the the Address class. Takes variables that are parsed in 
     * from the InputData.java class.
     * @param newStreet     String containing the street where the client lives
     * @param newTown       String containing the town or city where the client
     *                      lives
     * @param newPostcode   String containing the postcode of where the client
     *                      lives
     */
    public Address(String newStreet, String newTown, String newPostcode)
    {
        this.street = newStreet;
        this.town = newTown;
        this.postcode = newPostcode;
    }
    
    /**
     * Mutator method for changing the street of where the client lives.
     * @param newStreet     the new street of the where the client lives.
     */
    public void setStreet(String newStreet)
    {
        this.street = newStreet;
    }
    
    /**
     * Mutator method for changing the town or city of where the client lives.
     * @param newTown     the new town or city of the where the client lives.
     */
    public void setTown(String newTown)
    {
        this.town = newTown;
    }
    
    /**
     * Mutator method for changing the postcode of where the client lives.
     * @param newPostcode     the new postcode of the where the client lives.
     */
    public void setPostcode(String newPostcode)
    {
        this.postcode = newPostcode;
    }
    
    /**
     * Accessor method for retrieving the street where the client lives.
     * @return      a string containing the street where the client lives
     */
    public String getStreet()
    {
        return this.street;
    }
    
    /**
     * Accessor method for retrieving the town or city where the client lives.
     * @return      a string containing the town or city where the client lives
     */
    public String getTown()
    {
        return this.town;
    }
    
    /**
     * Accessor method for retrieving the postcode where the client lives.
     * @return      a string containing the postcode where the client lives
     */
    public String getPostcode()
    {
        return this.postcode;
    }
    
    /**
     * Comparable Interface to check to see if any clients share the same 
     * address
     * @param toCheck       the address of the client to check
     * @return              either a 1 or 0. 1 if true, 0 is false.
     */
    @Override
    public int compareTo(Address toCheck)
    {
        if(this.postcode.equals(toCheck.postcode))
        {
            if(this.street.equals(toCheck.street))
            {
                return this.getTown().compareTo(toCheck.getTown());
            }
            else
            {
                return this.getStreet().compareTo(toCheck.getStreet());
            }           
        }
        else
        {
            return this.getPostcode().compareTo(toCheck.getPostcode());
        }
    }
    
    /**
     * toString method that uses StringBuilder to create a string that can be 
     * returned and called in the main to output.
     * @return      object that can be called and used to output a String
     */
    public String toString()
    {
        //Variable that can be called to quickly create a newLine
        String newLine = "\n";
        
        //Creates and initalises a StringBuilder object
        StringBuilder builder = new StringBuilder();
        
        builder.append("Street: ");
        builder.append(getStreet());
        builder.append(newLine);
        builder.append("Town or City: ");
        builder.append(getTown());
        builder.append(newLine);
        builder.append("Postcode: ");
        builder.append(getPostcode());
        builder.append(newLine);
        
        return builder.toString();
    }
}
