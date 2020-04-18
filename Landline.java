public class Landline extends OldLandline {

    /**
     *  Basic variables needed for the class
     */
    public Landline(String newOwner, long phoneNumber) {
        super(newOwner, phoneNumber);
    }

    /**
     * Helper method that checks if the device is on or off.
     *
     * @return boolean that tells if the device is on by return true or off by returning false.
     */
    public boolean canCheck() {
        if (this instanceof SmartPhone) {
            if (((SmartPhone) this).getState() == Computer.State.ON) {
                return true;
            }
            else
            {
                System.out.println("The phone is currently off. You cannot access the messages.");
                return false;

            }
        } else if (this instanceof Landline) {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Reads all the message in the voice mail.
     */
    public void readMessages() {
        if(this.canCheck()) {
            if (super.getMessages().size() > 0) {
                Message cursor;

                for (int i = 0; i < super.getMessages().size(); i++) {

                    cursor = super.getMessages().get(i);

                    System.out.println(cursor.getMessage());
                    cursor.messageRead();
                }
            } else {
                System.out.println("There are no messages to read.");
            }
        }
    }

    /**
     * Reads only the messages of a certain status.
     *
     * @param stat Stauts of the messages to be read.
     */
    public void readMessages(Message.MSG_STATUS stat)
    {
        if(this.canCheck()) {
            if (super.getMessages().size() > 0) {
                Message cursor;

                for (int i = 0; i < super.getMessages().size(); i++) {

                    cursor = super.getMessages().get(i);

                    if (cursor.getStatus() == stat) {
                        System.out.println(cursor.getMessage());
                        cursor.messageRead();
                    }
                }
            } else {
                System.out.println("There are no messages to read.");
            }
        }
    }

    /**
     * Adds a message to the voice mail.
     *
     * @param m Message to be added.
     */
    public void addMessages(String m)
    {
        this.getMessages().add(new Message(m));
    }

    /**
     * Returns the information about the phone from the super class.
     *
     * @return The information
     */
    public String toString()
    {
        return super.toString();
    }

}