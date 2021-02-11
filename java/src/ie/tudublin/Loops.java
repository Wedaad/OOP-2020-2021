package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    float offset = 0;

    public void draw() {
        background(0);
        noStroke();
        switch (mode)
        {
            case 0: {
                fill(50, 255, 255);                    
                if (mouseX < cx)
                {
                    rect(0, 0, cx, height);
                }
                else
                {
                    rect(cx, 0, cx, height);
                }
                break;
                
            }//ends case 0

            case 1: {

                fill(50, 255, 255);                                    
                if (mouseX < cx && mouseY < cy)
                {
                    rect(0, 0, cx, cy);
                }
                else if (mouseX > cx && mouseY < cy)
                {
                    rect(cx, 0, cx, cy);
                }
                else if (mouseX < cx && mouseY > cy)
                {
                    rect(0, cy, cx, cy);
                }
                else
                {
                    rect(cx, cy, cx, cy);
                }
                break;
            }//ends case 1
            
            case 2: {
    
                int numRects = (int)(mouseX / 10.0f);
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height);
                }
                break;

            }//ends case 2
    
            case 3: {

                int numCircles = (int)(mouseX / 10.0f);
                float cw = width / (float) numCircles;
                float cirgap = 255 / (float) numCircles;
                for(int i = 0 ; i < numCircles ; i ++)
                {
                    fill(cirgap * i, 255, 255);
                    ellipse(cw / 2 + (i * cw), cy, cw, cw);
                }
                break;
            }//ends case 3

            case 4: {
                
                stroke(50, 255, 255);
                int numLines = 5;
                float theta = TWO_PI / (float) numLines; //gives angle between lines
                float radius = 100;

                for(int i = 0; i < numLines; i++) {

                    float angle = theta * i;
                    float x = sin(angle) * radius;
                    float y = cos(angle) * radius;
                    line(cx, cy, cx + x, cy + y);
                }
                break;
            }//ends case 4

            case 5: {
                int numSquares = 10;
                float sw = width / (float) numSquares;
                float squaregap = 255 / (float) numSquares;


                for(int i = 0; i < numSquares; i++) {

                    fill(squaregap * i, 255, 255);
                    square((i * sw), (i * sw), sw);
                        
                }
                break;
            }//ends case 5

            case 6: {

                noStroke();
                int nCircles = 10; 
                float cirColour = 255 / (float) nCircles;
                float cirGap = 500 / (float) nCircles;

                for(int i = 0; i < nCircles; i++){

                    fill(cirColour * i, 255, 255);
                    ellipse(cx, cy, (width - (cirGap * i)), (height - (cirGap * i)));
                    
                }
                break;
            }//ends case 6

            case 7: {

                offset += (mouseX / 100);
                int circles = 10;
                float circlew = width / (float) circles;
                float circleGap = 255 / (circles + circles);
                
                for(int i = 0; i < circles; i++) {

                    for(int j = 0; j < circles; j++){
                        
                        float c = ((circleGap * (i + j) + offset) % 255); //giving the colour a range between 0 - 255 using modulus operator
                        fill(c, 255, 255);
                        ellipse(circlew / 2 + (i * circlew), circlew / 2 + (j * circlew), circlew, circlew);

                    }
                }
                break;
            }//ends case 7

            case 8: {
                
                float ww = 200;
                float h = 50;
                rectMode(CENTER);

                if(mouseX > cx - (ww/2) && mouseX < cx + (ww/2) && mouseY > cy - (h / 2) &&  mouseY < cy + (h / 2)) {

                    fill(50, 255, 255);

                }
                else {


                    fill(200, 255, 255);
                }
                
                rect(cx, cy, ww, h);
                break;  
            }//ends case 8
            case 9: {

                int sides = (mouseX / 50);
                float thetas = TWO_PI / (float) sides;
                float rad = 200;
                stroke(255);

                for(int i = 1; i <= sides; i++){

                    float x1 = sin(thetas * (i - 1)) * rad;
                    float y1 = cos(thetas * (i - 1)) * rad;
                    float x2 = sin(thetas * i) * rad;
                    float y2 = cos(thetas * i) * rad;
                    line(cx + x1, cy+ y1, cx + x2, cy + y2);
                } 
                break;
            }//ends case 9

        }   
    }
}
