package exercise1;

/**
 * A class representing Fish
 * @author Imtiaz Akhtar
 * @version 2019.10.21
 */
public class Fish extends Animal implements Swimmer {
    public Fish(String type, String name, String birthYear) {
        super(type, name, birthYear);
    }
}