package insurancemodel;
import java.util.ArrayList;

/**
 * This class contains an ArrayList of type ClientDetails, that holds all the 
 * information related to the clients of the insurance company that was 
 * retrieved from the InputData class.
 * @author ruw12gbu
 */
public class ClientDetailsList 
{
    private final ArrayList<ClientDetails> clientList;
    
    /**
     * Creates an ArrayList that is housed in the variable clientList, that was 
     * initialised above, of type ClientDetails.
     */
    public ClientDetailsList()
    {
        this.clientList = new ArrayList<>();
    }
    
    /**
     * A method to determine whether or not a given person, identified by a 
     * surname and a postcode is a client of the Insurance Company.
     * If so, the client's ID should be returned.
     * @param lastName  the surname of the person to be searched for
     * @param code      the postcode of the address of the person to be searched 
     *                  for.
     * @return          the Client ID if the person has at least one policy 
     *                  with the company, null otherwise.
     */
    public String findClient(String lastName, String code)
    {
        String clientID = "";
        for(ClientDetails clientDetails : clientList)
        {
            if(clientDetails.getName().getSurname().equals(lastName))
            {
                if (clientDetails.getAddress().getPostcode().equals(code)) 
                {
                    clientID = clientDetails.getClientID();
                }
            }
        }
        return clientID;
    }
    
    /**
     * A method to get the client details corresponding to a given client ID
     * 
     * @param givenID   the client ID whose are required.
     * @return          the required ClientDetails if found, null otherwise
     */
    public ClientDetails getClientDetails(String givenID)
    {       
        for(ClientDetails clientDetails : clientList)
        {
            if(clientDetails.getClientID().equals(givenID))
            {
                return clientDetails;
            }
        }
        return null;
    }
    
    /**
     * A method to determine another client who has the same address as the 
     * client whose details are given.
     * 
     * @param cDetails  the client details whose address is to be searched for.
     * @return          the ClientDetails of a client with the same address if 
     *                  there is one, null otherwise.
     */
    public ClientDetails sameAddressCheck(ClientDetails cDetails)
    {
        for(ClientDetails clientDetails : clientList)
        {
            if(clientDetails.getAddress().compareTo(cDetails.getAddress()) == 0)
            {
                return clientDetails;
            }
        }
        return null;
    }
    
    /**
     * Method to add a client to the clientList ArrayList.
     * @param client    object of type ClientDetails that contains all the 
     *                  information that a client needs to have.
     */
    public void addClient(ClientDetails client)
    {
        clientList.add(client);
    }
    
    /**
     * Method to return the number of clients the company currently has
     * @return          uses ArrayLists's .size() method to return an integer 
     *                  that is the current number of clients in the ArrayList
     */
    public int getNumberOfClients()
    {
        return clientList.size();
    }
    
    /**
     * toString method that uses StringBuilder to create a string that can be 
     * returned and called in the main to output. Contains an if condition that 
     * checks that there is a client to output and a for loop to iterate over 
     * the entire ArrayList.
     * @return          returns a string that can be called for an output.
     */
    public String toString()
    {
        //Variable that can be called to quickly create a newLine
        String newLine = "\n";
        
        //Creates and initalises a StringBuilder object
        StringBuilder builder = new StringBuilder();
        int i = 0;
        
        if(this.clientList != null)
        {
            for(ClientDetails client : this.clientList)
            {
                builder.append(client.toString());
                builder.append(newLine);
                i ++;
            }
        }
        return builder.toString();
    }
}