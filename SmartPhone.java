public class SmartPhone extends Landline implements Computer {

    /**
     *  Basic variables needed for the class
     */

    private String[] games = new String[5];
    private int numGames = 0;
    private State state;
    private int screenSize, RAM, processorSpeed;

    /**
     * Constructor for the class
     *
     * @param name
     *  Name of the smart phone owner
     *
     * @param number
     *  Number of the smart phone
     *
     * @param newStatus
     *  Status of the smart phone
     *
     * @param newScreenSize
     *  Screen size
     *
     * @param newRAM
     *  RAM
     *
     * @param newProcessorSpeed
     *  Speed of the processor
     */
    public SmartPhone(String name, long number, String newStatus, int newScreenSize, int newRAM, int newProcessorSpeed) {
        super(name, number);
        this.setState(newStatus);
        this.screenSize = newScreenSize;
        this.RAM = newRAM;
        this.processorSpeed = newProcessorSpeed;
    }

    /**
     * Gets screen size.
     *
     * @return screen size
     */
    @Override
    public int getScreenSize() {
        return this.screenSize;
    }

    /**
     * Gets RAM
     *
     * @return RAM
     */
    @Override
    public int getRAM() {
        return this.RAM;
    }

    /**
     * Returns Processor's speed
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
    public State getState() {
        return this.state;
    }

    /**
     * Sets the status of the smart phone
     *
     * @param to
     *      The status being set.
     */
    @Override
    public void setState(String to) {
        if (to.equals("on")) {
            this.state = State.ON;
        } else if (to.equals("ON")) {
            this.state = State.ON;
        } else if (to.equals("OFF")) {
            this.state = State.OFF;
        } else if (to.equals("off")) {
            this.state = State.OFF;
        } else {
            System.out.println("You added an incorrect state. Please try again as your methods might not work properly.");
        }
    }

    /**
     * Installs a game on the phone.
     *
     * @param gameName  Name of the game
     */
    public void installGame(String gameName) {
        if (this.state == State.ON) {
            if (!this.hasGame(gameName)) {
                if(numGames < 5) {
                    games[numGames] = gameName;

                    System.out.println("Installing " + gameName + " on " + this.getOwner() + "'s smart phone.");

                    numGames++;
                }

                else
                {
                    System.out.println("There are already 5 games in " + this.getOwner() + "'s phone. You cannot install anymore games.");
                }
            }
        }
        else {
            System.out.println("The phone is off. You cannot install a game until you turn on the phone");
        }
    }

    /**
     * Checks if a certain game exists on the phone.
     *
     * @param gameName  Name of the game
     *
     * @return  Returns true of game if exists and false if it does not.
     */
    @Override
    public boolean hasGame(String gameName) {
        if (this.state == State.ON) {
            for (int i = 0; i < numGames; i++) {
                if (games[i].equals(gameName)) {
                    return true;
                }
            }
            return false;
        }
        else
        {
            System.out.println("The phone is off. You cannot check if there is a certain game until you turn on the phone");
            return false;
        }
    }

    /**
     * Play the game.
     *
     * @param gameName Plays the game.
     */
    @Override
    public void playGame(String gameName) {
        if (this.state == State.ON) {
            if (this.hasGame(gameName)) {
                System.out.println(this.getOwner() + " is playing " + gameName + ".");
            } else {
                System.out.println("Cannot play " + gameName + " on "
                        + this.getOwner() + "'s phone. Please install it first.");
            }
        } else {
            System.out.println("The phone is off. You cannot play a game until you turn on the phone");
        }
    }

    /**
     * Returns the information about the smart phone
     *
     * @return The information
     */
    @Override
    public String toString()
    {
        return "\nThe owner is " + this.getOwner() + ", the number is " + this.number().getNumber() + ", the screen size is "
                + this.getScreenSize() + ", the " + "RAM is " + this.getRAM() + ", and the processor Speed is " + this.getProcessorSpeeed() + ".";
    }

}