import java.util.*;

/*
The main class creates a main menu and sends a string into other class where other functions are stored.
*/

public class Main {
    public static void main (String[] args)
    {
        Boolean play = true; // Boolean used to keep user in while loop to ensure play
        Scanner scnr = new Scanner(System.in); // imports scanner object
        Boolean inputError = false; // this boolean is used for the while loop that checks that the user has not inputted valid input
        int option = 0; // initializes the variable for main menu input
        int[] stats; // integer array that holds that stats for each pokemon object

        System.out.print("Welcome to your new Pokedex!\nHow many Pokemon are in your region:"); // Asks user to input how many pokemon are in area
        int numPokemon = scnr.nextInt(); // variable stores the number of pokemon
        System.out.println("\nYour new Pokedex can hold " + numPokemon + " Pokemon. Let's start using it!"); // updates the user how many pokemon that the pokedex can store

        Pokedex pokeDex = new Pokedex(numPokemon); // creates pokedex object

        while (play) // While loop that keeps bringing use back to the menu once an option is chosen
        {

            while (!inputError) // this while loop ensures that the user has given correct menu input
            {
                System.out.print("\n1. List Pokemon \n2. Add Pokemon \n3. Check Pokemon Stats \n4. Evolve Pokemon \n5. Sort Pokemon \n6. Exit (Exits the program)\n\nWhat would you like to do?");;
                if (scnr.hasNextInt()) // Checks that the user inputted an integer
                {
                    option = scnr.nextInt(); // Stores the integer that the user chose into option
                    if (option >= 1 && option <= 6) // Ensures that the user chose an integer between 1 to 6
                    {
                        inputError = true; // Gets user out of while loop. User has put in correct input

                    }
                    else // User put an integer that is not between numbers 1- 6
                    {
                        System.out.println("\nThis is not a valid choice. Try again.\n"); // Alerts the user of error

                    }

                }
                else // If the user has not inputted an integer
                {
                    scnr.next(); // Clears the scanner
                    System.out.println("\nThis is not a valid choice. Try again."); // Alerts the user of error


                }
            }

            int acceptedOption = option; // new int that will go into the switch once all the tests have been completed

            switch (acceptedOption) // switch statement takes the menu input of user
            {
                case 1: // this case for listing all the pokemon already in pokedex
                    for (String i : pokeDex.listPokemon()) // for each loop prints out each pokemon string within string array pokemon
                    {
                        if (i != null) // checks that spot in array is takem
                            System.out.println(i); // prints out list to user
                        else // if there are no pokemon entered into pokedex
                            break;
                    }
                    inputError = false; // must be false so that user goes into menu while loop
                    break; //breaks out of switch

                case 2: // this case is for adding pokemon to the pokedex
                    System.out.print("\nPlease enter the Pokemon's Species:"); // prompts user to enter poke name
                    String species = scnr.next(); // stores name into species
                    pokeDex.addPokemon(species); // adds pokemon into pokeDex
                    inputError = false; // ensures that user goes back into while loop
                    break; // exits switch

                case 3:
                    System.out.print("\n Please enter the Pokemon of interest:"); // prompts user to enter pokemon name
                    species = scnr.next(); // stores species name that the user is interested about
                    stats = pokeDex.checkStats(species); // gets the statistics for the chosen pokemon
                    if (stats[0] != 0 && stats[1] != 0 && stats[2] != 0) // checks that the stats of the pokemona are not equal to 0
                    {
                        System.out.println("\n The stats for " + pokeDex.corName(species) + " are:"); // prints each stat of the chosen pokemon
                        System.out.println("Attack: " + stats[0]);
                        System.out.println("Defense: " + stats[1]);
                        System.out.println("Speed: " + stats[2]);
                    }
                    else
                        System.out.println("Missing"); // if the user inputted pokemon that is not there

                    inputError = false; // user goes back into menu loop
                    break;

                case 4: // this case is for evolving pokemon
                    System.out.print("Please enter the Pokemon of interest:"); // prompts user
                    species = pokeDex.corName(scnr.next()); // passes inputted name into corName method in Pokedex class
                    if(pokeDex.evolvePokemon(species)) // if the name matches
                        System.out.println(species + " has evolved!"); // notifies user that they have evolved
                    else
                        System.out.println("Missing"); // if pokemon is not in array
                    inputError = false; // ensures user goes back into menu loop
                    break;

                case 5:
                    pokeDex.sortPokedex(); // Sorts all the pokemon objects by names. Names are printed through this method
                    inputError = false;
                    break;
                case 6: // this case kills program
                    return; // exits out of program


            }
        }
    }
}
