import java.util.*;

/*
This class is used for all the sorting and sorting of pokemon into the pokedex
 */

public class Pokedex {

    private Pokemon[] pokes; // array of pokemon objects
    private String[] pokemon; // array of pokemon string names
    private int[] stats = new int[3]; // int array that will hold the stats of the chosen pokemon
    private int position; // int used for sorting the array in order
    private Pokemon[] ordered; // array with pokemon in order
    private String corName; // String name that will be used to recognize pokemon names ignoring case

    public Pokedex (int numPoke) // initializes the size of the different arrays needed for different methods
    {
        pokemon = new String[numPoke]; // contains strings of pokemon names
        pokes = new Pokemon[numPoke]; // contains pokemon objects
        ordered = new Pokemon[numPoke]; // used to sort through pokemon

    }

    public String[] listPokemon() // as name implies this pokemon lists the pokemon
    {

        for (int i = 0; i < pokemon.length && pokes[i] != null; i++ ) // continues as long for the length of pokemon string array & there are still objects in poke array
        {
            if (pokes[i] != null) // checks that there is a pokemon that occupies spot
            {

                pokemon[i] = (i + 1) + ". " + pokes[i].getSpecies(); // Updates string with number within string array. Sends the strings back with number
            }
        }
        return pokemon; // returns string array

    }
    public boolean addPokemon (String species) // This method adds the pokemon into the pokemon object array
    {
        for (int i = 0; i < pokes.length; i++) // for loop checks that pokedex is not full
        {
            if (pokes[i] != null && pokes[i].getSpecies().equalsIgnoreCase(species)) // if the user has already entered pokemon before
            {
                System.out.println("Duplicate"); // informs user
                return false;
            }


            else if (pokes[i] == null) // if there is still space in pokedex (spot is empty)
            {

                pokes[i] = new Pokemon(species); // adds the pokemon to the pokes array
                return true;
            }

        }
        System.out.println("Max"); // if location is not null user is updated that pokedex is full
        return false;
    }
    public int[] checkStats(String species) // method that
    {
        Arrays.fill(stats, 0); // empties the values of stats array
        for (int i = 0; i < pokes.length && pokes[i] != null  ; i++) // for loop for to check each lcoation within pokes array
        {
            if(pokes[i].getSpecies().equalsIgnoreCase(species)) // checks for the user's pokemon of interest
            {
                stats[0] = pokes[i].getAttack(); // gets the attack vakue and stores it into stats array
                stats[1] = pokes[i].getDefense(); //gets the defense vakue and stores it into stats array
                stats[2] = pokes[i].getSpeed(); //gets the speed vakue and stores it into stats array
            }
        }
        return stats; // returns desired stats to users
    }
    public String corName(String species) // this method is used for checking that the right name get printed ignoring case when inputted from user
    {
        corName = ""; // string must be empty each time method is used
        for (int i = 0; i < pokes.length && pokes[i] != null; i++) // for loop that checks withim pokes object array
        {
            if (pokes[i].getSpecies().equalsIgnoreCase(species)) // checks that the inputted string is the same as the string in array ignoring case
            {
                corName = pokes[i].getSpecies(); // sets the correct name to the name in the pokemon array
            }
        }
        return corName; // returns the correct name that is used when printed
    }

    public void sortPokedex() // method used to order pokemon lexigraphically
    {
        Arrays.fill(ordered,null); // sets all values in ordered string array to null
        position = 0; // this int wil determine the string position within ordered array
        for (int i = 0; i < pokes.length && pokes[i] != null; i++) // double for loop used to compare and rank values lexigraphically
        {
            for (int j = 0; j < pokes.length && pokes[j] != null; j++) //
            {
                if(pokes[i].getSpecies().compareTo(pokes[j].getSpecies()) > 0) // if the lexigraphic value of a string is greater than another it will get one added to position int
                {
                    position++;
                }
            }
            ordered[position] = pokes[i]; // puts the string into its correct position within array
            position = 0; // resets position for the next string array
        }
        pokes = ordered.clone(); // this is the array that is actually displayed when list pokemon is chosen
    }

    public boolean evolvePokemon(String species) // method to evolve pokenmon
    {
        for (int i = 0; i < pokes.length && pokes[i] != null; i++) // checks for each poke object and also that there is an object present in array
        {
            if(pokes[i].getSpecies().equalsIgnoreCase(species)) // if the user inputs a string that has already been added
            {
                pokes[i].evolve(); // passes pokemon object into the evolve method
                return true; // breaks out of method
            }
        }
        return false; // breaks out of method
    }
}
