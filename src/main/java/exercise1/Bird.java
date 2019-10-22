package exercise1;

/**
 * A class representing Birds
 * @author Imtiaz Akhtar
 * @version 2019.10.21
 */
public class Bird extends Animal {
    /**
     * Constructor: Create an instance
     * @param type A String holding the type
     * @param name A String holding the name
     * @param birthYear A String holding the 4-digit year of birth
     */
    public Bird(String type, String name, String birthYear) {
        super(type, name, birthYear);
    }
}