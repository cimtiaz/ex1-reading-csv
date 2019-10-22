package exercise1;

/**
 * A class representing Fish
 * @author Imtiaz Akhtar
 * @version 2019.10.21
 */
public class Fish extends Animal implements Swimmer {
    /**
     * Constructor: Create an instance
     * @param type A String holding the type
     * @param name A String holding the name
     * @param birthYear A String holding the 4-digit year of birth
     */
    public Fish(String type, String name, String birthYear) {
        super(type, name, birthYear);
    }

    /**
     * A method that returns the swimming features
     * @return The swimming features as a String
     */
    public String swim() {
        return ("I can swim and live in water, but I cannot breath and live for long time in air.");
    }
}