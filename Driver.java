import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    // Animal ArrayLists
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    // List of accepted Monkey species
    private static final String[] monkeySpecies = {"capuchin", "guenon", "macaque", "marmoset", "squirrel monkey", "tamarin"};

    public static void main(String[] args) {

        // Instance variables
        Scanner scnr = new Scanner(System.in);
        String input;

        // Initializes animal lists for testing
        initializeDogList();
        initializeMonkeyList();

        // Menu loop
        do {
            // Displays menu
            displayMenu();

            // Input validation
            while (!scnr.hasNext("[123456q]")) {
                System.out.println("That's not a valid option!");
                scnr.next();
            }
            input = scnr.next();
            
            // Switch determines action based on input
            switch (input) {
                case "1":
                    intakeNewDog(scnr);
                    break;
                case "2":
                    intakeNewMonkey(scnr);
                    break;
                case "3":
                    reserveAnimal(scnr);
                    break;
                case "4":
                    printAnimals("dogs");
                    break;
                case "5":
                    printAnimals("monkeys");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    return;
            }
        } while (input != "q"); // Loop exits on q

        scnr.close();
    }


    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Dave", "Capuchin", "male", "4", "12.1", "05-27-2019", "Mexico", "intake", false, "United States", "20cm", "55cm", "60cm");
        Monkey monkey2 = new Monkey("Gina", "Macaque", "female", "6", "15.2", "04-22-2020", "Russia", "Phase I", false, "United States", "15cm", "45cm", "42cm");
        Monkey monkey3 = new Monkey("Gerald", "Marmoset", "male", "2", "9.2", "12-02-2021", "United Kingdom", "in service", false, "Canada", "23cm", "75cm", "32cm");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }


    // Intakes new dog
    public static void intakeNewDog(Scanner scanner) {
        // Instance variables
        String input;

        // Prompt user for input and set data for all attributes
        // Name
        System.out.println("What is the dog's name?");
        scanner.nextLine();
        String name = scanner.nextLine();

        // Validate dog is not already in system
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Breed
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();

        // Gender
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();

        // Age
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();

        // Weight
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();

        // Acquisition Date
        System.out.println("What date was the dog acquired?");
        String acquisitionDate = scanner.nextLine();

        // Acquisition Country
        System.out.println("In what country was the dog acquired?");
        String acquisitionCountry = scanner.nextLine();

        // Training Status
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();

        // Reserved Status
        System.out.println("Is the dog reserved? (y/n)");
        // Input validation for reserved status
        while (!scanner.hasNext("[YNyn]")) {
            System.out.println("Please enter 'y' or 'n'");
            scanner.nextLine();
        }
        input = scanner.nextLine();
        
        boolean reserved = false;
        if (input.equalsIgnoreCase("y")) {
            reserved = true;
        }
        else if (input.equalsIgnoreCase("n")) {
            reserved = false;
        }

        // In-Service Country
        System.out.println("What is the dog's in-service country?");
        String inServiceCountry = scanner.nextLine();

        // Add newly instantiated Dog to ArrayList
        dogList.add(new Dog(name, breed, gender, age, 
            weight, acquisitionDate, acquisitionCountry, 
            trainingStatus, reserved, inServiceCountry));

        // Success message
        System.out.println("Dog added!");
    }


    // Intakes new monkey
    public static void intakeNewMonkey(Scanner scanner) {
        // Instance variables
        String input;

        // Prompt user for input and set data for all attributes
        // Name
        System.out.println("What is the monkey's name?");
        scanner.nextLine();
        String name = scanner.nextLine();

        // Validate monkey is not already in system
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Species
        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        // Validate Species
        while (!validMonkeySpecies(species)) {
            System.out.println("Not an accepted species!");
            species = scanner.nextLine();
        }

        // Gender
        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();

        // Age
        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();

        // Weight
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();

        // Acquisition Date
        System.out.println("What date was the monkey acquired?");
        String acquisitionDate = scanner.nextLine();

        // Acquisition Country
        System.out.println("In what country was the monkey acquired?");
        String acquisitionCountry = scanner.nextLine();

        // Training Status
        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();

        // Reserved Status
        System.out.println("Is the monkey reserved? (y/n)");
        // Input validation for reserved status
        while (!scanner.hasNext("[YNyn]")) {
            System.out.println("Please enter 'y' or 'n'");
            scanner.nextLine();
        }
        input = scanner.nextLine();
        
        boolean reserved = false;
        if (input.equalsIgnoreCase("y")) {
            reserved = true;
        }
        else if (input.equalsIgnoreCase("n")) {
            reserved = false;
        }

        // In-Service Country
        System.out.println("What is the monkey's in-service country?");
        String inServiceCountry = scanner.nextLine();

        // Tail Length
        System.out.println("What is the monkey's tail length?");
        String tailLength = scanner.nextLine();

        // Height
        System.out.println("What is the monkey's height?");
        String height = scanner.nextLine();

        // Body Length
        System.out.println("What is the monkey's body length?");
        String bodyLength = scanner.nextLine();

        // Add newly instantiated Monkey to ArrayList
        monkeyList.add(new Monkey(name, species, gender, age, 
            weight, acquisitionDate, acquisitionCountry, 
            trainingStatus, reserved, inServiceCountry, 
            tailLength, height, bodyLength));

        // Success message
        System.out.println("Monkey added!");
    }


    // Searches for animal to reserve by type and in service country
    public static void reserveAnimal(Scanner scanner) {

        // Instance variables
        boolean animalFound = false;

        // Prompt for animal type
        System.out.println("What type of animal?");
        scanner.nextLine();
        String type = scanner.nextLine().toLowerCase();

        // Input validation for animal type
        while ((!type.equalsIgnoreCase("dog")) && (!type.equalsIgnoreCase("monkey"))) {
            System.out.println("Not a valid animal type!");
            type = scanner.nextLine().toLowerCase();
        }

        // Prompt for in service country
        System.out.println("Which country for service?");
        String country = scanner.nextLine().toLowerCase();

        // Search for animal based on type and country
        switch (type) {
            case "dog":
                for (Dog dog : dogList) {
                    if ((dog.getInServiceLocation().toLowerCase().equals(country)) && (!dog.getReserved()) && (dog.getTrainingStatus().equals("in service"))) {
                        System.out.println("Dog " + dog.getName() + " found and reserved!");
                        dog.setReserved(true);
                        animalFound = true;
                        break;
                    }
                }
                break;
            case "monkey":
                for (Monkey monkey : monkeyList) {
                    if ((monkey.getInServiceLocation().toLowerCase().equals(country)) && (!monkey.getReserved()) && (monkey.getTrainingStatus().equals("in service"))) {
                        System.out.println("Monkey " + monkey.getName() + " found and reserved!");
                        monkey.setReserved(true);
                        animalFound = true;
                        break;
                    }
                }
                break;
        }

        // Print statement if no animal is found
        if (!animalFound) {
            System.out.println("No animals found.");
        }

    }


    // Prints animal info
    public static void printAnimals(String listType) {

        // Determines info to print based on menu selection
        switch (listType) {

            // Prints dog list
            case "dogs":
                System.out.println("Dogs:");
                System.out.println();

                for (Dog dog : dogList) {
                    printAnimalInfo(dog);
                }
                break;
            
            // Prints monkey list
            case "monkeys":
                System.out.println("Monkeys:");
                System.out.println();

                for (Monkey monkey : monkeyList) {
                    printAnimalInfo(monkey);
                }
                break;

            // Prints all animals that are in service and not reserved
            case "available":
                System.out.println("Showing available animals");
                System.out.println();

                // Prints available dogs
                System.out.println("Dogs:");
                System.out.println();
                for (Dog dog : dogList) {
                    if ((dog.getTrainingStatus().equals("in service")) && (!dog.getReserved())) {
                        printAnimalInfo(dog);
                    }
                }

                // Prints available monkeys
                System.out.println("Monkeys:");
                System.out.println();
                for (Monkey monkey : monkeyList) {
                    if ((monkey.getTrainingStatus().equals("in service")) && (!monkey.getReserved())) {
                        printAnimalInfo(monkey);
                    }
                }
                break;
        }
    }


    // Prints animal info
    public static void printAnimalInfo(RescueAnimal animal) {
        System.out.println(animal.getName());
        System.out.println("Training status: " + animal.getTrainingStatus());
        System.out.println("Acquired in: " + animal.getAcquisitionLocation());
        System.out.println("In-service country: " + animal.getInServiceLocation());
        System.out.println("Reserved: " + animal.getReserved());
        System.out.println();
    }


    // Checks if monkey species is acceptable
    static boolean validMonkeySpecies(String species){
        return Arrays.asList(monkeySpecies).contains(species.toLowerCase());
    }
}
