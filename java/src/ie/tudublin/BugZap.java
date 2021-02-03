package ie.tudublin;

import java.math.BigDecimal;

import processing.core.PApplet;

public class BugZap extends PApplet {

    public void settings() {

        size(500, 500);
        
    }//ends settings()

    float playerX, playerY, playerWidth;
    float bugX, bugY, bugWidth;

    public void setup() {
        background(0);
        stroke(255);

        playerX = 25;
        playerY = 25;
        playerWidth = 50;

        bugX = 10;
        bugY = 10; 
        bugWidth = 5;

    }//ends setup()

    public void drawPlayer(float x, float y, float w) {
         
        line(x, y, w, 25);
        stroke(225);


    }//ends drawPlayer

    public void drawBug(float bx, float by, float bw) {

        //line(bx, by, bw, 10);
        //stroke(225);

        if ((frameCount % 60) == 0) {

            line(bx, by, bw, 10);
            stroke(225);
            bx++;
            by++;
            bx--;
            by--;



        }//end if 

    }//ends drawBug

    public void drawLaser() {

        line(25, 100, 30, 25);
        stroke(225);

    }//ends drawLaser


    public void draw() {

        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugX, bugWidth);

    }//ends draw()
    
    public void keyPressed() {


        if(keyCode == LEFT) {

            System.out.println("Left arrow pressed\n");
            playerX++;

        }//ends if 

        
        if(keyCode == RIGHT) {

            System.out.println("Right arrow pressed\n");
            playerX--;

        }//ends if

        if(keyCode == ' ') {

            System.out.println("SPACE key pressed\n");
            drawLaser();

        }//ends if


    }//ends keyPressed()

}
