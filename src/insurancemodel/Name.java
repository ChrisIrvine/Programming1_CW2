/*
 * This class houses details of the policy holders.
 */
package insurancemodel;

/**
 *
 * @author christopherirvine
 */
public class Name 
{
    public String title;
    public String initials;
    public String surname;
    
    public Name(String newTitle, String newInitials, String newSurname)
    {
        this.title = newTitle;
        this.initials = newInitials;
        this.surname = newSurname;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getInitialis()
    {
        return initials;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    
    public void setInitials(String newInitials)
    {
        initials = newInitials;
    }
    
    public void setSurname(String newSurname)
    {
        surname = newSurname;
    }
    
    public String toString()
    {
        String newLine = "\n";
        char space = ' ';
        StringBuilder builder = new StringBuilder();
        
        builder.append("Policy Holder:  ");
        builder.append(this.title);
        builder.append(space);
        builder.append(this.initials);
        builder.append(space);
        builder.append(this.surname);
        
        return builder.toString();
    }
}
