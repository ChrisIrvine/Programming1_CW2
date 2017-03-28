package insurancemodel;
import java.io.File;
import java.io.IOException;

/**
 * Main class for the InsuranceCoDemo program. This runs the program and uses 
 * the classes to manipulate the text file in order to receive the desired 
 * output.
 * @author ruw12gbu
 */
public class InsuranceCoDemo 
{
    //Create ClientDetailList object
    private static ClientDetailsList clients;
    //String variable used to test the findClient method
    private final static String CLIENT_SURNAME = "Abbott";
    //String variable used to test the findClient method
    private final static String CLIENT_POSTCODE = "HU1 1UR";
    //String variable used to test sameAddressCheck method
    private final static String TRUE_CLIENT_ID = "IC-x00042W";
    //String variable used to test sameAddressCheck method 
    private final static String FALSE_CLIENT_ID = "IC-x00010P";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        try
        {
            //parse the text file, using the filepath, into the InputData class
            clients = InputData.readFile(new File("ClientDetailsInput.txt"));
        }
        catch(IOException e)
        {
            System.out.println(e); //Catch IOExceptions
        }
        catch(IllegalPolicyException e)
        {
            System.out.println(e.getMessage()); //Catch IllegalPolicyException
        }
        
        System.out.println(clients.toString());
        
        /* 
         * Testing for the findClient method in the ClientDetailsList class. The
         * expected outcome for this is that the full clientID for Mr P Abbot, 
         * which is 'IC-x00025V'.
         */
        System.out.println("The ClientID for Mr P Abbot at HU1 1UR is: " + 
                clients.findClient(CLIENT_SURNAME, CLIENT_POSTCODE));
        System.out.println("\n"); //Created a new line for formatting resasons
        
        /*
         * Testing for the sameAddressCheck in the ClietnDetailsList class. The
         * expected outcome for this is that the first case will return null as 
         * this is a new client('jimmy'); created for the purpose of this test, 
         * with a new address, whereas the second case will return the full 
         * client details of the alreadyt existing client; using a second new
         * client ('billy') that purposely shares and address with Ms NAP 
         * Wallis. 
         */
        System.out.println("Testing the sameAddressCheck method: ");
        addressCheck(clients);
        
        /* 
         * Testing for the getClientDetails method in the ClientDetailsList 
         * class, using a true and false clientID. The expected outcome for this
         * test is that the TRUE_CLIENT_ID event will properly return a client, 
         * but the FALSE_CLIENT_ID event will return a null value. 
         */
        System.out.println("Find client details for a given clientID: " +
                clients.getClientDetails(TRUE_CLIENT_ID) + 
                clients.getClientDetails(FALSE_CLIENT_ID));
        
        /*
         * Testing of numberOfClients method in the ClientDetailsList class,
         * the testing is done by taking the ClientDetailList ArrayList
         * (clients) and running the getNumberOfClients() method, located in 
         * the ClientDetailsList class itself. When working it should return the
         * total number of clients, in this case it would be 14.
         */
        int clientNumber = 0;
        clientNumber = clients.getNumberOfClients();
        System.out.println(clientNumber);
        
        /*
         * Testing of numberOfPolicies method in the PolicyList class, by 
         * selecting a single client, re-using the TRUE_CLIENT_ID variable from
         * testing the getClientDetails method, and calling the 
         * numberOfPolicies() method. When working it should return the total
         * number of policies belonging to Ms LQ Bethea, which is one.
         */
        int numberOfPolicies = 0;
        numberOfPolicies = clients.getClientDetails(TRUE_CLIENT_ID)
                .getPolicies().numberOfPolicies();
        System.out.println(numberOfPolicies);
        
        /*
         * Testing of a set method. As they all operate on a similar manner, I
         * will only test a single set method from one of the policy methods. 
         * So to test this fully, I will print out the client details of Ms LQ
         * Bethea (from TRUE_CLIENT_ID) and attempt to change her client 
         * details. When this works the details should be completely different.
         */
        System.out.println("Before changing: " + 
                clients.getClientDetails(TRUE_CLIENT_ID));
        
        clients.getClientDetails(TRUE_CLIENT_ID).getName().setTitle("Mr");
        clients.getClientDetails(TRUE_CLIENT_ID).getName().setInitials("AD");
        clients.getClientDetails(TRUE_CLIENT_ID).getName().setSurname("CeeDee");
        clients.getClientDetails(TRUE_CLIENT_ID).getAddress().
                setStreet("666, Thunderstruck Avenue");
        clients.getClientDetails(TRUE_CLIENT_ID).getAddress().
                setTown("Black Ice");
        clients.getClientDetails(TRUE_CLIENT_ID).getAddress().
                setPostcode("W1K 1QZ");

        System.out.println("After changing: " + 
                clients.getClientDetails(TRUE_CLIENT_ID));
        
    }
    
    /**
     * Method to test the sameAddressCheck method in the ClientDetailsList.
     * @param clients   the ArrayList of type ClientDetails that holds all the 
     *                  raw information.
     */
    public static void addressCheck(ClientDetailsList clients)
    {
        //Adds a new client that will not trigger the sameAddressCheck method
        ClientDetails jimmy = new ClientDetails("IC-x00045P", 
                new Name("Mr", "BIG", "Jimmy"), 
                new Address("209, The Royal Mile", "Edinburgh", "EH1 1SG"), 
                new PolicyList());
        //Adds a new client that will trigger the sameAddressCheck method
        ClientDetails billy = new ClientDetails("IC-x00054Q", 
                new Name("Mr", "WEE", "Billy"), 
                new Address("244, Grubb Lane", "Durham", "DU4 4ZX"), 
                new PolicyList());
        
        //Prints out the result of the sameAddressCheck methods
        System.out.println(clients.sameAddressCheck(jimmy));
        System.out.println(clients.sameAddressCheck(billy));
    }
}

/*
This is what should be printed out during a successful test run, using the data
provided as well as some additional clients to test some of the methods, as 
detailed above. The acccessor methods are all tested in the StringBuilder 
methods detailed in the majority of the classes. The mutator methods use the 
same logic and code as are in the constructors. I have tested the more 
complicated methods in the program in the main and these can be found at the 
bottom of you output, that can be seen below.

run:
Client ID: IC-x00042W
Policy Holder:  Ms LQ Bethea
Street: 205, Willis Road
Town or City: Bolton
Postcode: BO5 1DQ
Content Insurance Policy Number: C02000007
Year the Policy was created: 2007
Risk of insuring the contents: 0.5
Value contents are insured for: £10000.0
Premium for this policy: £150.0



Client ID: IC-x00033D
Policy Holder:  Mr R Bowie
Street: 119, Thatcher Way
Town or City: Glasgow
Postcode: GL9 5SX
Building Insurance Policy Number: L09000016
Year the Policy was created: 2008
Age of Policy Holider: 45 years old
The amount that the life is insured for: £50000
Health risk to the policy holder: 2.0
Premium for this Policy is: £150.0



Client ID: IC-x00013A
Policy Holder:  MS GRV Blackwell
Street: 209, Drunk Road
Town or City: Hawick
Postcode: HK8 1MY
Building Insurance Policy Number: B09000009
Year the Policy was created: 2013
Risk of Insuring the Building: 0.1
Cost of Rebuilding the Property: £225000.0
The Premium for this insurance policy is: £247.50000000000003



Client ID: IC-x00018O
Policy Holder:  Ms NAP Wallis
Street: 244, Grubb Lane
Town or City: Durham
Postcode: DU4 4ZX
Vehicle Insurance Policy No: V04000003
Year of Issue: 2007
Value of Vehicle: £6000.0
Age of Driver: 37 years old
Years of no claims: 6 years
Fully comprehensive: false
Premium for this Policy: £900.0



Client ID: IC-x00037N
Policy Holder:  Miss DOD Burke
Street: 272, Ambrose Lane
Town or City: Cambridge
Postcode: CB2 2XD
Building Insurance Policy Number: B23000006
Year the Policy was created: 2012
Risk of Insuring the Building: 0.4
Cost of Rebuilding the Property: £110000.0
The Premium for this insurance policy is: £154.0



Client ID: IC-x00039A
Policy Holder:  Dr X Salter
Street: 285, Bannister Road
Town or City: Sea Palling
Postcode: SP2 6GW
Vehicle Insurance Policy No: V02000002
Year of Issue: 2007
Value of Vehicle: £8500.0
Age of Driver: 24 years old
Years of no claims: 3 years
Fully comprehensive: false
Premium for this Policy: £786.25



Client ID: IC-x00011I
Policy Holder:  MR R Reece
Street: 104, Bannister Lane
Town or City: Cromer
Postcode: CR0 6LD
Building Insurance Policy Number: B78000012
Year the Policy was created: 2013
Risk of Insuring the Building: 0.4
Cost of Rebuilding the Property: £110000.0
The Premium for this insurance policy is: £154.0



Client ID: IC-x00025V
Policy Holder:  Mr P Abbott
Street: 163, Drunk Lane
Town or City: Hunstanton
Postcode: HU1 1UR
Building Insurance Policy Number: B08000029
Year the Policy was created: 2010
Risk of Insuring the Building: 0.2
Cost of Rebuilding the Property: £125000.0
The Premium for this insurance policy is: £150.0



Client ID: IC-x00008L
Policy Holder:  Dr P Runyon
Street: 150, Tick Tock Way
Town or City: Swindon
Postcode: SW8 4OJ
Building Insurance Policy Number: L08000005
Year the Policy was created: 2009
Age of Policy Holider: 60 years old
The amount that the life is insured for: £150000
Health risk to the policy holder: 2.0
Premium for this Policy is: £450.0



Client ID: IC-x00028F
Policy Holder:  MR X Watt
Street: 267, Malton Road
Town or City: Cambridge
Postcode: CB4 1PQ
Building Insurance Policy Number: L19100016
Year the Policy was created: 2012
Age of Policy Holider: 65 years old
The amount that the life is insured for: £17500
Health risk to the policy holder: 3.0
Premium for this Policy is: £68.0



Client ID: IC-x00031X
Policy Holder:  Mr S Lorenz
Street: 276, Tick Tock Way
Town or City: London
Postcode: LN9 7ID
Vehicle Insurance Policy No: V41000023
Year of Issue: 2009
Value of Vehicle: £4500.0
Age of Driver: 32 years old
Years of no claims: 7 years
Fully comprehensive: false
Premium for this Policy: £675.0



Client ID: IC-x00020C
Policy Holder:  Mr LNV Mcmillan
Street: 44, Drunk Street
Town or City: London
Postcode: LN6 1RG
Vehicle Insurance Policy No: V09000019
Year of Issue: 2004
Value of Vehicle: £2600.0
Age of Driver: 24 years old
Years of no claims: 2 years
Fully comprehensive: false
Premium for this Policy: £240.5



Client ID: IC-x00015H
Policy Holder:  Mr TQZ Dubose
Street: 244, Grubb Lane
Town or City: Durham
Postcode: DU4 4ZX
Building Insurance Policy Number: L07000026
Year the Policy was created: 2003
Age of Policy Holider: 43 years old
The amount that the life is insured for: £100000
Health risk to the policy holder: 2.8
Premium for this Policy is: £380.0



Client ID: IC-x00030U
Policy Holder:  MR U Jimenez
Street: 162, Malton Lane
Town or City: Berlin
Postcode: BE7 6PK
Vehicle Insurance Policy No: V19100030
Year of Issue: 2005
Value of Vehicle: £3500.0
Age of Driver: 37 years old
Years of no claims: 1 years
Fully comprehensive: false
Premium for this Policy: £485.625




The ClientID for Mr P Abbot at HU1 1UR is: IC-x00025V


Testing the sameAddressCheck method: 
null
Client ID: IC-x00018O
Policy Holder:  Ms NAP Wallis
Street: 244, Grubb Lane
Town or City: Durham
Postcode: DU4 4ZX
Vehicle Insurance Policy No: V04000003
Year of Issue: 2007
Value of Vehicle: £6000.0
Age of Driver: 37 years old
Years of no claims: 6 years
Fully comprehensive: false
Premium for this Policy: £900.0



Find client details for a given clientID: Client ID: IC-x00042W
Policy Holder:  Ms LQ Bethea
Street: 205, Willis Road
Town or City: Bolton
Postcode: BO5 1DQ
Content Insurance Policy Number: C02000007
Year the Policy was created: 2007
Risk of insuring the contents: 0.5
Value contents are insured for: £10000.0
Premium for this policy: £150.0


null
14
1
Before changing: Client ID: IC-x00042W
Policy Holder:  Ms LQ Bethea
Street: 205, Willis Road
Town or City: Bolton
Postcode: BO5 1DQ
Content Insurance Policy Number: C02000007
Year the Policy was created: 2007
Risk of insuring the contents: 0.5
Value contents are insured for: £10000.0
Premium for this policy: £150.0



After changing: Client ID: IC-x00042W
Policy Holder:  Mr AD CeeDee
Street: 666, Thunderstruck Avenue
Town or City: Black Ice
Postcode: W1K 1QZ
Content Insurance Policy Number: C02000007
Year the Policy was created: 2007
Risk of insuring the contents: 0.5
Value contents are insured for: £10000.0
Premium for this policy: £150.0



BUILD SUCCESSFUL (total time: 0 seconds)
*/