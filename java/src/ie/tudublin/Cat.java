package ie.tudublin;

public class Cat extends Animal
{
    public Cat(String name)
    {
        super(name);
    }

    private int numLives;

    public int getNumLives() {

        return numLives;

    }//end getNumLives()

    public void setNumLives(int numLives)
    {
        this.numLives = numLives;

    }//ends setNumLives

    //this is a constructor 
    public void Cat(int numLives)
    {
        this.numLives = numLives;

    }//ends getNumLives

    public void kill() {

        if(numLives > 0) {

            numLives = numLives - 1;
            System.out.println("Ouch!");

        }//ends if statement 

        if(numLives == 0) {

            System.out.println("Dead");

        }//ends if statement 


    }//ends void kill()
}
