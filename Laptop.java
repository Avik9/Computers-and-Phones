import java.util.ArrayList;

public class Laptop implements Computer
{

    /**
     *  Basic variables needed for the class
     */
    private State state;
    private String brandName, hostname;
    private ArrayList<String> games = new ArrayList<>();
    private int numGames = 0;
    private int screenSize, RAM, processorSpeed;

    /**
     * Constructor for the class
     *
     * @param newStatus
     *  Status of the laptop
     *
     * @param newScreenSize
     *  Screen size
     *
     * @param newRAM
     *  RAM
     *
     * @param newProcessorSpeed
     *  Speed of the processor
     *
     * @param newBrandName
     *  Name of the brand of the laptop
     *
     * @param ownerName
     *  Name of the owner of the laptop
     */
    public Laptop(String newStatus, int newScreenSize, int newRAM, int newProcessorSpeed, String newBrandName, String ownerName)
    {
        this.setState(newStatus);
        this.screenSize = newScreenSize;
        this.RAM = newRAM;
        this.processorSpeed = newProcessorSpeed;
        this.brandName = newBrandName;
        this.hostname = ownerName + "'s " + brandName + " " + "laptop";
    }

    /**
     * Gets screen size.
     *
     * @return screen size
     */
    @Override
    public int getScreenSize()
    {
        return this.screenSize;
    }

    /**
     * Gets RAM.
     *
     * @return RAM
     */
    @Override
    public int getRAM() {
        return this.RAM;
    }

    /**
     * Gets Processor Speed.
     *
     * @return Processor Speed
     */
    @Override
    public int getProcessorSpeeed() {
        return this.processorSpeed;
    }

    /**
     * Returns the current state
     *
     * @return Current State
     */
    @Override
    public State getState()
    {
        return this.state;
    }

    public String getBrandName()
    {
        return this.hostname.substring(this.hostname.indexOf(" ") + 1, this.hostname.lastIndexOf(" "));
    }

    public String getOwner()
    {
        return this.hostname.substring(0, this.hostname.indexOf("'"));
    }

    public String getHostName() {
        return hostname;
    }

    /**
     * Sets the status of the laptop
     *
     * @param to
     *      The status being set.
     */
    public void setState(String to)
    {
        if(to.equals("on"))
        {
            this.state = Laptop.State.ON;
        }

        else if (to.equals("ON"))
        {
            this.state = Laptop.State.ON;
        }

        else if (to.equals("OFF"))
        {
            this.state = Laptop.State.OFF;
        }

        else if (to.equals("off"))
        {
            this.state = Laptop.State.OFF;
        }

        else
        {
            System.out.println("You added an incorrect state. Please try again as your methods might not work properly.");
        }
    }

    /**
     * Installs a game on the laptop.
     *
     * @param gameName  Name of the game
     */
    public void installGame(String gameName)
    {
        if (this.state == State.ON) {
            if (!this.hasGame(gameName)) {
                games.add(gameName);

                System.out.println("Installing " + gameName + " on " + this.getHostName());

                numGames++;
            }
        }
        else
        {
            System.out.println("The laptop is off. You cannot install a game until you turn on the laptop.");
        }
    }

    /**
     * Checks if a certain game exists on the laptop.
     *
     * @param gameName  Name of the game
     *
     * @return  Returns true of game if exists and false if it does not.
     */
    public boolean hasGame(String gameName)
    {
        if (this.state == State.ON) {
            for (int i = 0; i < numGames; i++) {
                if (games.get(i).equals(gameName)) {
                    return true;
                }
            }
        }
        else
        {
            System.out.println("The phone is off. You cannot check if there is a certain game until you turn on the phone");
        }

        return false;
    }

    /**
     * Play the game.
     *
     * @param gameName Plays the game.
     */
    public void playGame(String gameName)
    {
        if(this.state == State.ON) {
            if (this.hasGame(gameName)) {
                System.out.println(this.getOwner() + " is playing " + gameName + ".");
            } else {
                System.out.println("Cannot play " + gameName + " on "
                        + this.getOwner() + "'s phone. Please install it first.");
            }
        }

        else
        {
            System.out.println("The laptop is off. You cannot play any game until you turn on the phone");
        }
    }

    /**
     * Returns the information about the laptop.
     *
     * @return The information
     */
    public String toString()
    {
        return "\nThe owner is " + this.getOwner() + ", the brand name is " + this.getBrandName() + ", the screen size is "
                + this.getScreenSize() + ", the RAM is " + this.getRAM() + ", and the Processor Speed is "
                + this.getProcessorSpeeed();
    }
}
