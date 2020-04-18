import java.util.LinkedList;
import java.util.Scanner;

public class OldLandline implements Phone
{
    /**
     *  Basic variables needed for the class
     */
    private LinkedList<Message> messages = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);
    private PhoneNumber number;
    private String owner;
    private boolean isOnCall;
    Phone onPhoneWith;

    /**
     * Constructor for the class.
     *
     * @param newOwner
     *      Name of the owner of the phone.
     *
     * @param phoneNumber
     *      Number of the phone.
     */
    public OldLandline(String newOwner, long phoneNumber)
    {

        try {
            if (phoneNumber > 999999999L && phoneNumber <= 9999999999L) {
                number = new PhoneNumber(phoneNumber);
                owner = newOwner;
                isOnCall = false;

            } else {
                throw new IllegalArgumentException("The number you entered for " + newOwner + " is invalid!");
            }
        }
        catch(IllegalArgumentException i)
        {
            System.out.println("The number you entered for " + newOwner + " is invalid!");

            System.exit(1);
        }
    }

    /**
     * This phone calls another phone.
     *
     * @param phone Phone being called
     */
    public void call(Phone phone)
    {
        if(this == phone)
        {
            System.out.println("You cannot call yourself! Try calling someone else than " + this.getOwner());
            return;
        }

        if(phone instanceof SmartPhone)
        {
            if(((SmartPhone) phone).getState() == Computer.State.OFF)
            {
                System.out.println("You cannot call since the phone is off. Please try again later!");
                System.exit(0);
            }
        }

        if(this instanceof SmartPhone)
        {
            if(Computer.State.OFF == ((SmartPhone) this).getState())
            {
                System.out.println("You cannot call since the phone is off. Please try again later!");
                System.exit(0);
            }
        }

        if(this.isBusy())
        {
            System.out.println(this.getOwner() + " cannot make a phone call, " + this.getOwner() + " is already on a call.");
            return;
        }

        else if(phone.isBusy())
        {
            System.out.println(this.getOwner() + " is unable to call " + phone.getOwner() + ". Line is currently busy.");

            if(phone instanceof Landline)
            {
                System.out.println("Would you like to leave a message? [y/n]:");
                char ans = (sc.nextLine().toUpperCase().charAt(0));

                if(ans == 'Y')
                {
                    ((Landline) phone).getMessages().addLast(new Message(sc.nextLine()));

                    System.out.println(this.getOwner() + " left a message for " + phone.getOwner() + ".");
                }

                else if(ans != 'N')
                {
                    System.out.println("You chose an incorrect option!");
                }
            }
        }

        else
        {
            phone.receive(this);
            this.onPhoneWith = phone;
            this.isOnCall = true;
        }
    }

    /**
     * Ends the phone call.
     */
    public void end()
    {
            this.isOnCall = false;
            ((OldLandline) onPhoneWith).setOnCall(false);
            this.receiveEndSignal(onPhoneWith);
    }

    /**
     * Receives the phone call.
     *
     * @param from receives from this phone.
     */
    public void receive(Phone from)
    {
        this.isOnCall = true;
        this.onPhoneWith = from;

        System.out.println(this.getOwner() + " is on the phone with " + from.getOwner() + ".");
    }

    /**
     * Checks if the phone is busy.
     *
     * @return true of busy and false if not busy
     */
    public boolean isBusy()
    {
        return isOnCall;
    }

    /**
     * Receives the signal that the phone has ended.
     *
     * @param from Received signal from this phone.
     */
    public void receiveEndSignal(Phone from)
    {
        System.out.println(this.getOwner() + " has ended the call to " + from.getOwner() + ".");
    }

    /**
     * Gets the owner of the phone.
     *
     * @return name of the owner
     */
    public String getOwner()
    {
        return this.owner;
    }

    /**
     * Gets the phone number.
     *
     * @return phone number
     */
    public PhoneNumber number()
    {
        return number;
    }

    /**
     * Gets the messages in the voicemail.
     *
     * @return The messages.
     */
    public LinkedList<Message> getMessages()
    {
        return messages;
    }

    /**
     * Sets the phone on call.
     *
     * @param onCall True of phone is on call.
     */
    public void setOnCall(boolean onCall)
    {
        isOnCall = onCall;
    }

    /**
     * Returns the information about the phone
     *
     * @return The information
     */
    public String toString()
    {
        return "\nThe owner is " + this.getOwner() + " and the number is " + this.number().getNumber();
    }
}