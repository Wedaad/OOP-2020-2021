package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    
    public float map1(float from, float start1, float stop1, float start2, float stop2) { //from number goes stop1 - start1 and is mapped to start2 stop2

        float range1 = stop1 - start1; //range mapping from
        float range2 = stop2 - start2; //range mapping to
        float howFar = from - start1; 


        return start2 + (howFar/ range1) * range2; //getting a percentage 
    } 

    public void drawGrid() {

        stroke(0, 250, 0);
        float border = width * .05f;
        textAlign(CENTER, CENTER);

        for(int i = -5; i <= 5; i++) {

            float x = map1(i, -5, 5, border, width - border);
            line(x, border, x, height - border); //vertical lines
            line(border, x, width - border, x); //horizontal lines
            fill(255);
            text(i, x, border * 0.5f); //first parameter: the value to be printed, second paramter & third paramter: x and y coordinates
            text(i, border * 0.5f, x);
        }
    }
 
    public void settings() {
        size(500, 500);   
        
        float f = map1(2, 0, 10, 0, width); 
        println(f); //should print 100 between 0 and width

        f = map1(9, 0, 1, 0, 10); //9 mapped from the range 0 to 1  and number is mapped between the 0, 10 output should be 90
        println(f);

        f = map1(250, 200, 300, 400, 500); //should print 450: 50% 200, 300 and return 50% between 400 and 500
        println(f);

        f = map1(5, 0, 10, 1000, 2000);//should print 1500
        println(f);
    }

    int mode = 0;

    //arrays:
    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "Novemeber", "December"};
    float[] arr = new float[100]; //new uninitialied array of floats, default value of 0 and a size of 100

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        //iterating over arrays
        for(int i = 0; i < rainfall.length; i++) { //rainfall.length is like SIZE .length gets the size of the array

            System.out.println(months[i] + "\t" + rainfall[i]);  // appeneing to array
        }

        //enhanced for loop
        for(float f:rainfall) { //every element is copied from rainfall to f 
             
            System.out.println(f);
        } 

        //what month had the most rainfall and what month had the least rainfall 
        for(int i = 0; i < rainfall.length; i++) {

            if(rainfall[i] >= 104) {

                System.out.println("The month with the most rainfaill: " + months[i]);

            }

            if (rainfall[i] <= 30){

                System.out.println("The month with the least rainfaill: " + months[i]);
            }

        }

        //what is the total rainfall
        float total = 0;

        for(int i = 0; i < rainfall.length; i++) {

            total = total + rainfall[i]; //total += rainfall[i];
        }

        System.out.println("Total rainfall is: " + total + "\n");

        //what is the average rainfall

        float average = total / (float) rainfall.length;

        System.out.println("Average rainfall is: " + average + "\n");
        

        //drawing a bar chart of the rainfall using map function
        colorMode(HSB);
        float w = width / (float) rainfall.length; //width of each bar
        for(int i = 0; i < rainfall.length; i++) {

            noStroke();
            fill(random(255), 255, 255); //getting a random colour from 0 - 255 and setting that to the colour of the bars
            float x = map(i, 0, rainfall.length, 0, width);
            rect(x, height, w, - rainfall[i]);
        }

    }


    float offset = 0;

    public void draw() {
        //background(0);
        //drawGrid();
        colorMode(HSB);
        float c = map(mouseX, 0, width, 0, 255);
        //background(c, 255, 255);
    }
}
