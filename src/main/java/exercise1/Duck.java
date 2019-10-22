package exercise1;

/**
 * A class representing Ducks
 * @author Imtiaz Akhtar
 * @version 2019.10.21
 */
public class Duck extends Animal implements Swimmer {
    public Duck(String type, String name, String birthYear) {
        super(type, name, birthYear);
    }
}