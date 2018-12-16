public class Pokemon {

    /*
    This class is used for creating the actual pokemon objects that will go into
    the pokemon string
     */

    private String species; // private variables different data types for each pokemon
    private int attack;
    private int defense;
    private int speed;

    public Pokemon (String species) //creates actual pokemon with defined data types
    {
        this.species = species;
        this.attack = species.length() * 4 + 2;
        this.defense = species.length() * 2 + 7;
        this.speed = species.length() * 3 + 5;

    }

    public int getAttack() // returns the privateattack of the pokemon
    {
        return this.attack;
    }
    public void setAttack(int newAttack) // updates private variable if pokemon stats are changed
    {
        this.attack = newAttack;

    }
    public int getDefense() // returns defense private variable
    {
        return defense;
    }
    public void setDefense(int newDefense) // sets defense to new defense if pokemon stats are chagnged
    {
        defense = newDefense;
    }
    public int getSpeed() // returns speed
    {
        return speed;

    }
    public void setSpeed(int newSpeed) // updates speed private variable
    {
        speed = newSpeed;

    }
    public String getSpecies() // returns string species
    {
        return species;

    }
    public void setSpecies(String newSpecies) // if species name gets changed
    {
        species = newSpecies;
    }
    public void evolve() // evolves pokemon and updates stats
    {
        setAttack(getAttack() * 3);
        setSpeed(getSpeed() * 2);
        setDefense(getDefense() * 5);
    }
}
