package insurancemodel;

/**
 * This class represents the details of each individual client; involving data 
 * relevant to a particular client only.
 * @author ruw12gbu
 */
public class ClientDetails 
{
    public String clientID; //unique ID to the client
    public Name name; //Name object with details of title, initials and surname 
    /*
     * Address object with details of the street, town or city and the postcode 
     * of the client
     */
    public Address address; 
    //PolicyList object that creates a new ArrayList for this clients policies
    public PolicyList policies;
    
    /**
     * Constructor for the ClientDetails.java class. Parses in all the data that
     * is needed to create a full ClientDetail object.
     * @param newClientID   the unique ID of that client
     * @param newName       the title, initials and surname of that client
     * @param newAddress    this street, town or city and postcode of the client
     * @param newPolicies   this details of the policies that the client holds
     */
    public ClientDetails (String newClientID, Name newName, Address newAddress,
            PolicyList newPolicies)
    {
        clientID = newClientID;
        name = newName;
        address = newAddress;
        policies = newPolicies;
    }
    
    /**
     * Accessor method to return the unique ID of this ClientDetail object
     * @return      string containing the clientID
     */
    public String getClientID()
    {
        
        return this.clientID;
    }
    
    /**
     * Accessor method to return the title, initials and surname of this 
     * ClientDetails object. 
     * @return      Name object containing the title, initials and surname
     */
    public Name getName()
    {
        return this.name;
    }
    
    /**
     * Accessor method to return the street, town or city and postcode of this
     * ClientDetails object.
     * @return      Address object containing the street, town or city and 
     *              postcode of the ClientDetails object.
     */
    public Address getAddress()
    {
        return this.address;
    }
    
    /**
     * Accessor method to return the details of all the policies that this
     * ClientDetails object holds.
     * @return      PolicyList object containing the  details of all the 
     *              policies that this ClientDetails object holds.
     */
    public PolicyList getPolicies()
    {
        return this.policies;
    }
    
    /**
     * Accessor method to return the full details of this ClientDetails object
     * @return      returns a string containing all the details of this 
     *              ClientDetails object.
     */
    public String getClientDetails()
    {
        return this.clientID + this.name + this.address + this.policies;
    }
    
    /**
     * Mutator method to change the clientID of this ClientDetails object.
     * @param newClientID   String containing the  new clientID for this 
     *                      ClientDetails object.
     */
    public void setClientID(String newClientID)
    {
        this.clientID = newClientID;
    }
    
    /**
     * Mutator method to change the name details (title, initials and surname) 
     * for this ClientDetails object.
     * @param newName       object of type Name with the new title, initials and 
     *                      surname for this ClientDetails object.
     */
    public void setName(Name newName)
    {
       this.name = newName;
    }
    
    /**
     * Mutator method to change the policies that this ClientDetails object 
     * holds.
     * @param newPolicies   object of type PolicyList that contains all the 
     *                      details of the new policies for this ClientDetails
     *                      object.
     */
    public void setPolicies(PolicyList newPolicies)
    {
        this.policies = newPolicies;
    }
    
    /**
     * Mutator method to change the address details (street, town or city and 
     * postcode) for this ClientDetails object.
     * @param newAddress    object of type Address with the new street, town or 
     *                      city and postcode for this ClientDetails object.
     */
    public void setAddress(Address newAddress)
    {
        this.address = newAddress;
    }
    
    /**
     * toString method that uses StringBuilder to create a string that can be 
     * returned and called in the main to output. 
     * @return              object that can be called and used to output a 
     *                      string.
     */
    public String toString()
    {
        //Variable that can be called to quickly create a newLine
        String newLine = "\n";
        
        //Creates and initalises a StringBuilder object
        StringBuilder builder = new StringBuilder();
        
        builder.append("Client ID: ");
        builder.append(getClientID());
        builder.append(newLine);
        builder.append(getName());
        builder.append(newLine);
        builder.append(getAddress());
        builder.append(getPolicies());
        builder.append(newLine);
        
        return builder.toString();
    }
}
