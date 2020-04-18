import java.lang.Long;

public class PhoneNumber
{
    /**
     *  Basic variables needed for the class
     */
    private long number;

    /**
     * Constructor for the class
     *
     * @param newNumber Phone number
     */
    public PhoneNumber(Long newNumber)
    {
        number = newNumber;
    }

    /**
     * Gets the number of the object.
     *
     * @return number.
     */
    public long getNumber()
    {
        return number;
    }
}