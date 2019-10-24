package exercise1;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * A base class to hold the animal data and methods
 *
 * @author Imtiaz Akhtar
 * @version 2019.10.21
 */

public class Animal {
    //Type of animal
    private String type;
    //Name of animal
    private String name;
    //Four digit birth year of animal in format of YYYY
    private String birthYear;

    /**
     * Constructor: Create an instance of Animal class
     * @param type A String holding the type of animal
     * @param name A String holding the name of animal
     * @param birthYear A String holding the 4-digit year of birth
     */
    public Animal(String type, String name, String birthYear) {
        this.type = type;
        this.name = name;
        this.birthYear = setBirthYear(birthYear)?birthYear:"0000";
    }

    /**
     * Return the type of animal
     * @return The animal type as a String
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of animal in field variable
     * @param type The type of animal
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Return the name of animal
     * @return The animal name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of animal in field variable
     * @param name The name of animal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the birth year of animal
     * @return The animal birth year as a String
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * Set the birth year of animal in field variable
     * @param birthYear A four-digit string holding the birth year of animal
     * @return boolean, "true" if the field variable for birth date is set with valid year, otherwise "false"
     */
    public boolean setBirthYear(String birthYear) {
        //validate the birthYear is valid 4-digit year
        if(birthYear.length()!=4) return false;
        //validate the birthYear is not negative or future year
        int intBirthYear = Integer.parseInt(birthYear);
        if(intBirthYear<0 || intBirthYear>Calendar.getInstance().get(Calendar.YEAR)) return false;

        //assign the birthYear if it is valid
        this.birthYear = birthYear;
        return true;
    }

    /**
     * Override the toString method to return the object fields as comma separated string
     * @return The object fields as comma separated string
     */
    @Override
    public String toString() {
        return (type + "," + name + "," + birthYear);
    }

    /**
     * This method returns an introduction of the animal
     * @return String containing the short introduction of the animal
     */
    public String speak(){
        return ("My name is " + name +", I am a " + type + " and I was born in " + birthYear + ".");
    }

}
