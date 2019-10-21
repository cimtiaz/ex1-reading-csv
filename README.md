# PiD - Exercise 1
- Write Java code with the following functionality:
- Read the CSV file line by line, and extract the type, name, and birth year from each line.
- Create a class "Animal" as well as several subclasses for the different types of animals represented in the text file. The subclasses must be able to store the information contained in each line of input.
- Create an interface "Swimmer" which should be implemented by all classes of animals that can swim.
- Create a collection "animals", using generics, which stores an instance of the right subclass of "Animal" for each line of the text file.
- A line of the text file is considered invalid if the year field contains a non-numeric character (a character which is not 0-9). For each invalid line read from the file a warning message should be reported. No animals should be added to the "animals" collection for invalid lines.
- Print the contents of the "animals" collection to the console, sorted alphabetically by name.
- Write a method that allows filtering a collection of animals using a custom filter. The method should return a collection of animals that satisfy the custom filter.
- Create another collection "swimmers" which contains only those animals from the "animals" collection whose class types implement the "Swimmer" interface.
- Create a new CSV file "swimmers.csv" with the contents of the "swimmers" collection, sorted chronologically by birth date. This new CSV file should have the same format as the original file "animals.csv".
- Write unit tests using JUnit which test the functionalities needed above. Structure your code in a way that enables unit tests.

