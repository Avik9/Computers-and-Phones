import java.util.ArrayList;
import java.util.Collections;

public class Test
{
    /**
     * Main method that runs the entire project.
     */
    public static void main(String[] args)
    {
        // Arraylists that hold all the devices.
        ArrayList<Object> devices = new ArrayList<>();
        ArrayList<Object> temp = new ArrayList<>();
        ArrayList<Phone> phones = new ArrayList<>();
        ArrayList<Computer> computers = new ArrayList<>();

        // Test cases from the homework file
        Landline jack = new Landline("Jack", 6312028899L);
        phones.add(jack);
        Landline john = new Landline("John", 3028113434L);
        phones.add(john);
        OldLandline julie = new OldLandline("Julie", 9018772324L);
        phones.add(julie);

        SmartPhone paul = new SmartPhone("Paul", 2024449019, "off", 100, 1000, 100000000);
        phones.add(paul);
        jack.call(john);
        julie.call(john);
        john.end();
        julie.call(john);
        john.call(jack);
        julie.end();

        System.out.println("\n\n");

        // Random test cases to try calling
        Phone Liam = new Landline("Liam", 5164234624L);
        Phone Noah = new Landline("Noah", 5165132076L);

        Phone Ava = new OldLandline("Ava", 6312027140L);
        Phone Mia = new OldLandline("Mia", 5165132014L);

        Phone Isabella = new SmartPhone("Isabella", 3477073325L, "ON", 10, 1024, 10000);
        Phone Benjamin = new SmartPhone("Benjamin", 5163049925L, "OFF", 15, 2048, 20000);

        Liam.call(Noah);
        Ava.call(Mia);

        ((SmartPhone) Benjamin).setState("On"); // changing the state to an incorrect state
        ((SmartPhone) Benjamin).setState("ON"); // changing the state
        Isabella.call(Benjamin);

        Liam.end();
        Ava.end();
        Isabella.end();

        Noah.call(Ava);
        Ava.call(Noah);
        Mia.call(Isabella);
        Benjamin.call(Liam);

        Liam.end();
        Ava.end();
        Mia.end();
        Benjamin.end();
        Noah.end();

        Liam.call(Liam);
        Ava.call(Ava);
        Isabella.call(Isabella);

        ((SmartPhone) Benjamin).setState("OFF"); // changing the state again
        ((SmartPhone) Benjamin).installGame("fortnight");

        // Adding messages
        john.addMessages("Hi!");
        john.addMessages("My name is Liam");
        john.addMessages("I am 19 years old");

        paul.addMessages("Hi!");
        paul.addMessages("My name is Liam");
        paul.addMessages("I am 19 years old");

        System.out.println("\n\n");

        // Printing out Jack's READ Messages
        System.out.println("Printing Jack's READ Messages: ");
        jack.readMessages(Message.MSG_STATUS.READ);
        System.out.println("\nDone printing Jack's READ Messages.");

        System.out.println("\n\n");

        // Printing out John's READ Messages
        System.out.println("Printing John's READ Messages: ");
        john.readMessages(Message.MSG_STATUS.READ);
        System.out.println("\nDone printing John's READ Messages.");

        System.out.println("\n\n");

        // Printing out John's UNREAD Messages
        System.out.println("Printing John's UNREAD Messages: ");
        john.readMessages(Message.MSG_STATUS.UNREAD);
        System.out.println("\nDone printing John's UNREAD Messages.");

        System.out.println("\n\n");

        // Printing out Jack's all Messages
        System.out.println("Printing Jack's all Messages: ");
        jack.readMessages();
        System.out.println("\nDone printing Jack's all Messages.");

        System.out.println("\n\n");

        // Printing John's UNREAD Messages
        System.out.println("Printing John's UNREAD Messages: ");
        john.readMessages(Message.MSG_STATUS.UNREAD);
        System.out.println("\nDone printing John's UNREAD Messages.");

        System.out.println("\n\n");

        //Printing John's READ Messages
        System.out.println("Printing John's READ Messages: ");
        john.readMessages(Message.MSG_STATUS.READ);
        System.out.println("\nDone printing John's READ Messages.");

        paul.setState("OFF");

        paul.readMessages(); // Printing all messages when the state is off.

        paul.setState("ON");

        System.out.println("\n\n");

        // Printing Paul's all Messages
        System.out.println("Printing Paul's all Messages: ");
        paul.readMessages();
        System.out.println("\nDone printing Paul's all Messages.");

        System.out.println("\n\n");

        // Adding games to the phone
        paul.setState("ON");
        paul.installGame("angry birds");
        paul.installGame("Fortnight");
        paul.installGame("COD");
        paul.installGame("WWE");
        paul.installGame("Midtown Madness");
        paul.installGame("GTA"); // Adding a 6th game when the phone can only hold 5
        paul.playGame("minecraft");
        paul.playGame("fortnite");

        System.out.println("\n\n");

        // Creating a laptop object
        Computer a = new Laptop("OFF", 27, 30000, 10000, "Lenevo", "Brad");
        a.installGame("PUBG");
        a.playGame("PUBG");

        a.setState("ON");
        a.installGame("Barbie");
        a.installGame("Fortnight");
        a.installGame("COD");
        a.installGame("WWE");
        a.installGame("Midtown Madness");
        a.installGame("GTA");
        a.installGame("GTA San Andreas");
        a.playGame("PUBG");

        System.out.println("\n\n");

        // Randomly creates 30 Landlines, OldLandLines, and SmartPhones and adds them to the devices ArrayList.

        for(int i = 1; i <= 10; i++) // More than 10000 but less than 40000
        {
            phones.add(new Landline("Landline" + (int) (Math.random() * i * 100), (long) ((Math.random() * 8999999999L) + 1000000000L)));
            phones.add(new OldLandline("OldLandline" + (int) (Math.random() * i * 100), (long) ((Math.random() * 8999999999L) + 1000000000L)));
            phones.add(new SmartPhone("SmartPhone" + (int) (Math.random() * i * 100), (long) ((Math.random() * 8999999999L) + 1000000000L), "on",
                    (int) (50 * (Math.random() * i)), (int) (1000 * (Math.random() * i)), (int) (100 * (Math.random() * i))));
            computers.add(new Laptop("ON", (int) (50 * (Math.random() * i)), (int) (1000 * (Math.random() * i)),
                    (int) (100 * (Math.random() * i)), "Dell" + (int) (Math.random() * i * 100), "Laptop" + (int) (Math.random() * i * 100)));
        }

        devices.addAll(phones);
        devices.addAll(computers);

        //Prints the devices Arraylist as it was created.
        System.out.println("The original list created is: ");

        System.out.println(devices.toString().replace("[", "").replace("]", ""));

        //Sorts the list by phone numbers in increasing order.
        System.out.println("\n\n\nThis list is sorted by Phone Numbers in increasing order:");

        Collections.sort(phones, new Orderings.PhoneNumberComparator());

        devices = new ArrayList<>();

        devices.addAll(phones);
        devices.addAll(computers);

        System.out.println(devices.toString().replace("[", "").replace("]", ""));

        //Sorts the list by owner names in alphabetical order.
        System.out.println("\n\n\nThis list is sorted by Owner Names in alphabetical order:");

        Collections.sort(devices, new Orderings.OwnerNamesComparator());

        System.out.println(devices.toString().replace("[", "").replace("]", ""));

        //Sorts the list by RAM in increasing order.
        System.out.println("\n\n\nThis list is sorted by RAM in increasing order:");

        computers = new ArrayList<>();
        temp = new ArrayList<>();

        for(int i = 0; i < devices.size(); i++)
        {
            if(devices.get(i) instanceof Computer)
            {
                computers.add((Computer) devices.get(i));
                devices.remove(i);
                i--;
            }
        }

        Collections.sort(computers, new Orderings.RAMComparator());

        temp.addAll(computers);
        temp.addAll(devices);

        devices = temp;

        System.out.println(devices.toString().replace("[", "").replace("]", ""));

        temp = new ArrayList<>();

        // Sorts the list by screen size in an increasing order
        System.out.println("\n\n\nThis list is sorted by Screen Size in increasing order:");

        computers = new ArrayList<>();
        temp = new ArrayList<>();

        for(int i = 0; i < devices.size(); i++)
        {
            if(devices.get(i) instanceof Computer)
            {
                computers.add((Computer) devices.get(i));
                devices.remove(i);
                i--;
            }
        }

        Collections.sort(computers, new Orderings.ComputerScreenSizeComparator());

        temp.addAll(computers);
        temp.addAll(devices);
        devices = temp;

        temp = new ArrayList<>();
        phones = new ArrayList<>();
        computers = new ArrayList<>();

        System.out.println(devices.toString().replace("[", "").replace("]", ""));

        // This list is sorted by brand names in alphabetical order
        System.out.println("\n\n\nThis list is sorted by Brand Names in alphabetical order. " +
                "\nSince smartphones do not have a brand, it sorts Smart Phones by owner names:");

        for(int i = 0; i < devices.size(); i++)
        {
            if(devices.get(i) instanceof Computer)
            {
                computers.add((Computer) devices.get(i));
                devices.remove(i);
                i--;
            }
        }

        Collections.sort(computers, new Orderings.BrandNameComparator());

        temp.addAll(computers);
        temp.addAll(devices);
        devices = temp;

        temp = new ArrayList<>();
        phones = new ArrayList<>();
        computers = new ArrayList<>();

        System.out.println(devices.toString().replace("[", "").replace("]", ""));

        julie.call(jack);
        john.call(julie);
    }
}