public class Message
{
    /**
     *  Basic variables needed for the class
     */
    enum MSG_STATUS {READ, UNREAD}

    private String message = "";
    private MSG_STATUS status;

    /**
     * Constructor for the class
     *
     * @param m The message to be stored
     */
    public Message(String m)
    {
        message = m;
        status = MSG_STATUS.UNREAD;
    }

    /**
     * Gets the message
     *
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the status of the message
     *
     * @return status
     */
    public MSG_STATUS getStatus() {
        return status;
    }

    /**
     * Sets the status of the message to READ.
     */
    public void messageRead()
    {
        this.status = MSG_STATUS.READ;
    }
}
