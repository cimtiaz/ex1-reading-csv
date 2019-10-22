package exercise1;

/**
 * A class representing Ducks
 * @author Imtiaz Akhtar
 * @version 2019.10.21
 */
public class Duck extends Bird implements Swimmer {
    /**
     * Constructor: Create an instance
     * @param type A String holding the type
     * @param name A String holding the name
     * @param birthYear A String holding the 4-digit year of birth
     */
    public Duck(String type, String name, String birthYear) {
        super(type, name, birthYear);
    }

    /**
     * A method that returns the swimming features
     * @return The swimming features as a String
     */
    public String swim() {
        return ("I can swim and dive in water, but I cannot live in water.");
    }
}