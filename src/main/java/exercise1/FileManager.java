package exercise1;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class to read CSV-style records of animals.
 *
 * @author Imtiaz Akhtar
 * @version 2019.10.21
 */
public class FileManager {
    // An ArrayList to hold the list of all animals
    private ArrayList<Animal> animals;
    // A HashMap of animal types
    private HashMap<String,String> animalTypes;
    // How many fields are expected.
    private final int NUMBER_OF_FIELDS = 3;
    // Index values for the fields in each record.
    private final int TYPE = 0,
            NAME = 1,
            BIRTHYEAR = 2;

    /**
     * Create a FileManager object.
     */
    public FileManager() {
        animals = null;
        animalTypes = new HashMap<>();
        fillAnimalTypes();
    }

    /**
     * A method to fill the animal types in animalType HashMap
     */
    public void fillAnimalTypes() {
        animalTypes.put("bengal cat","Cat");
        animalTypes.put("german shepherd","Dog");
        animalTypes.put("golden retriever","Dog");
        animalTypes.put("dolphin","Fish");
        animalTypes.put("duck","Duck");
        animalTypes.put("chicken","Bird");
        animalTypes.put("arabian horse","Horse");
        animalTypes.put("great white shark","Fish");
        animalTypes.put("parakeet","Bird");
        //animalTypes.put("","");
    }


    /**
     * Read sightings in CSV format from the given file.
     * Return an ArrayList of Sighting objects created from
     * the information in the file.
     *
     * @param filename The file to be read - should be in CSV format.
     * @return A list of Sightings.
     */
    public void readAnimalsCSV(String filename)
    {
        // Create a Sighting from a CSV input line.
        Function<String, Animal> createAnimal =
                record -> {
                    String[] parts = record.split(",");
                    if(parts.length == NUMBER_OF_FIELDS) {
                        try {
                            String type = parts[TYPE].trim();
                            String name = parts[NAME].trim();
                            String birthYear = parts[BIRTHYEAR].trim();

                            // An anonymous Animal object will be returned, however
                            // return type is String so, a String will return because
                            // of Animal.toString() method.
                            // >>> return new Animal(type, name, birthYear);

                            //UPDATING CODE FOR CREATING CLASSES BASED ON ANIMAL TYPE
                            switch(animalTypes.get(type)) {
                                case "Bird":
                                    return new Bird(type, name, birthYear);
                                case "Cat":
                                    return new Cat(type, name, birthYear);
                                case "Dog":
                                    return new Dog(type, name, birthYear);
                                case "Duck":
                                    return new Duck(type, name, birthYear);
                                case "Fish":
                                    return new Fish(type, name, birthYear);
                                case "Horse":
                                    return new Horse(type, name, birthYear);
                                default:
                                    return new Animal(type, name, birthYear);
                            }
                        }
                        catch(NumberFormatException e) {
                            System.out.println(">>>This record (" + record + ") has invalid data, it cannot be added to collection");
                            return null;
                        }
                    }
                    else {
                        System.out.println(">>>Animal records in CSV file has the wrong number of fields:");
                        System.out.println(record);
                        System.out.println(">>>Please check the CSV file and call the function again");
                        return null;
                    }
                };

        try {
            animals = Files.lines(Paths.get(filename))
                    .filter(record -> record.length() > 0 && record.charAt(0) != '#')
                    .map(createAnimal)
                    .filter(animal -> animal != null)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Unable to open " + filename);
        }
    }

    /**
     * Display the data in animals collection
     */
    public void printAnimalsList() {
        //Exit if this method is called with empty collection
        if (!isAnimalsHasData()) return;

        System.out.println("\n>>>Printing Animal data from animals collection");

        animals.stream().forEach(System.out::println);
        /*
        REPLACING THE LOOP WITH STREAM FUNCTION
        for(Animal record : animals) {
            System.out.println(record);
        }
         */
    }

    /**
     * Display the data in animals collection sorted by name
     */
    public void printAnimalsListSortByName() {
        //Exit if this method is called with empty collection
        if (!isAnimalsHasData()) return;

        System.out.println("\n>>>Printing Animal data sorted by name from animals collection");
        animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .forEach(System.out::println);
    }

    /**
     * To check if animals collection has any data or it is empty
     * @return true if animals collection has data, or return false, if it is empty.
     */
    public boolean isAnimalsHasData() {
        if (animals==null) {
            System.out.println("\n>>>There is no data in animals collection.");
            System.out.println(">>>Please first call readAnimalCSV() method to read data from CSV file.");
            return false;
        } else {
            return true;
        }
    }

}
