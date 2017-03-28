package insurancemodel;

/**
 * Class to handle exceptions.
 * @author ruw12gbu
 */
public class IllegalPolicyException extends Exception
{
    /**
     * Creates an IllegalPolicyException with a given message
     * @param message   The message that will be displayed when the exception
     *                  is triggered.
     */
    public IllegalPolicyException (String message)
    {
        super(message);
    }
}

