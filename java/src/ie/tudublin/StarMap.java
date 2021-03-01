package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    //An array list is an array that can grow and shrink - add new elements to the array list
    ArrayList<Star> stars = new ArrayList<Star>(); //Generic Class - declaring an array list of type Star

    int startStar = -1;
    int endStar = 1;



    void drawGrid() {

        float border = 0.1f * width;
        textAlign(CENTER, CENTER);

        for(int i = -5; i <= 5; i++) {

            float x = map(i, -5, 5, border, width - border);
            float y = map(i, -5, 5, border, height - border);
            stroke(0, 0, 255);
            line(x, border, x, height - border);
            line(border, y, width - border, y);
            fill(255);
            text(i, x, border / 2);
            text(i, border / 2, y); 

        }




    } 
    void printStars() {

        for(Star s : stars) {

            println(s);  //converting star to string 

        }


    }

    void loadStars() {

        Table table = loadTable("HabHYG15ly.csv", "header"); //paramyters: name of csv file, pass the word header to tell the program that line 0 has table has column headers

        //enhanced for loop 
        for(TableRow row : table.rows()) { //iterating the table row by row 

            Star s = new Star(row);
            stars.add(s); //adding stars to array list 

        }

    }



    public void settings() {
        size(800, 800);
    }

    public void mouseClicked()
    {
        //println("Mouse clicked");

        float border = width * 0.1f;

        //iterate through all the stars to find which star is clicked 
        for(int i = 0; i < stars.size(); i++) {

            Star s = stars.get(i); //indexing in array list
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if(dist(mouseX, mouseY, x, y) < s.getAbsMag() / 2) {  //calculating distancebetween two stars

                println(s.getDisplayName());
                break;

            }

        }
    }

    public void setup() { //like main 
        colorMode(RGB);
        loadStars();
        printStars();
    }

    public void drawStars() {

        for(Star s : stars) {

            s.render(this); //passing the applet this - like a pointer 
        }
    }

    public void draw() {
        background(0);
        drawGrid();
        drawStars();
    }
}