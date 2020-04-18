import java.util.*;

/**
 * Class of orderings that orders the objects based on selected properties.
 */
public class Orderings {

    /**
     * Orders all laptops alphabetically by their brand name.
     */
    static class BrandNameComparator implements Comparator {
        public int compare(Object a, Object b) {
            if (a instanceof Laptop && b instanceof Laptop) {

                String brandName1 = ((Laptop) a).getBrandName();
                String brandName2 = ((Laptop) b).getBrandName();
                return brandName1.compareTo(brandName2);
            }
            else if (a instanceof Laptop && b instanceof Computer)
            {
                return -1;
            }
            else if(a instanceof Computer && b instanceof Laptop)
            {
                return 1;
            }
            else if(a instanceof Phone && b instanceof Phone)
            {
                String ownerName1 = ((Phone) a).getOwner();
                String ownerName2 = ((Phone) b).getOwner();
                return ownerName1.compareTo(ownerName2);
            }
            else
            {
                return 0;
            }
        }
    }

    /**
     * Orders all phones by their phone number.
     */
    static class PhoneNumberComparator implements Comparator
    {
        public int compare(Object a, Object b)
        {
            if(a instanceof Phone && b instanceof Phone) {
                long number1 = ((Phone) a).number().getNumber();
                long number2 = ((Phone) b).number().getNumber();

                if (number1 < number2) {
                    return -1;
                }

                if (number1 > number2) {
                    return 1;
                }
            }
                return 0;
        }
    }

    /**
     * Orders all phones and laptops by their RAM.
     */
    static class RAMComparator implements Comparator {
        public int compare(Object a, Object b) {
            if (a instanceof Computer && b instanceof Computer) {
                int RAM1 = ((Computer) a).getRAM();
                int RAM2 = ((Computer) b).getRAM();

                if (RAM1 < RAM2) {
                    return -1;
                }

                if (RAM1 > RAM2) {
                    return 1;
                }
            }
            return 0;
        }
    }

    /**
     * Orders all computers by their screen size.
     */
    static class ComputerScreenSizeComparator implements Comparator {
        public int compare(Object a, Object b) {
            if (a instanceof Computer && b instanceof Computer) {
                int screen1 = ((Computer) a).getScreenSize();
                int screen2 = ((Computer) b).getScreenSize();


                if (screen1 < screen2) {
                    return -1;
                }

                if (screen1 > screen2) {
                    return 1;
                }
            }
            return 0;
        }
    }

    /**
     * Orders all phones and laptops by the names of their owner.
     */
    static class OwnerNamesComparator implements Comparator {
        public int compare(Object a, Object b) {
            String name1 = "";
            String name2 = "";

            if(a instanceof Phone && b instanceof Phone)
            {
                name1 = ((Phone) a).getOwner();
                name2 = ((Phone) b).getOwner();

                return name1.compareTo(name2);
            }
            else
            {
                return 0;
            }

        }
    }
}


