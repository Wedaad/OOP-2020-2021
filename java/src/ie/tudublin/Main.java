package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        Animal misty = new Dog("Misty");

        Animal topCat = new Cat("TopCat");

        System.out.println(misty);
        System.out.println(topCat);

        misty = topCat;

        topCat.setName("Garfield");

        System.out.println(misty);
        System.out.println(topCat);

        // What will get printed out??

        // 1. topcat, Garfield
        // 2. garfield, Garfield 

        //topCat.setNumLives(9);

        Cat ginger = new Cat("Ginger");

        ginger.setNumLives(9);

        //killing ginger
        int i;

        for(i = 0; i < 9; i++) {

            ginger.kill();

        }//ends for loop()

    } 

}
