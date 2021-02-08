package ie.tudublin;

import javax.lang.model.util.ElementScanner14;

import jdk.vm.ci.code.CodeUtil.NumberedRefMapFormatter;
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

    public void draw() {
        background(0);
        noStroke();
        switch (mode)
        {
            case 0:
                fill(50, 255, 255);

                if(mouseX < cx) {

                    rect(0, 0, cx, height);   
                }
                else {

                    rect(cx, 0, cx, height);

                }
                break;

            case 1:

                fill(100, 255, 255);

                if(mouseX < cx && mouseY < cy) {

                    square(0, 0, cy);
                }
                else if (mouseX > cx && mouseY < cy){

                    square(cx, 0, cy);
                } 
                else if(mouseX < cx && mouseY > cy) {

                    square (0, cx, cy);
                }
                else {

                    square(cx, cx, cy);
                }
                break;

            case 2: 

                /*int numRects = 10;
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;

                for(int i = 0; i < numRects; i++) {

                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height); 
                }//ends for */
                
                int numRects = (int)(mouseX/10.0f);
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;

                for(int i = 0; i < numRects; i++) {

                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height); 
                }//ends for 
                break;
            
            case 3: 
            
                int numCircles = 10;
                float cw = width / (float) numCircles;
                float cirgap = 255 / (float) numCircles;
                
                for(int i = 0; i < numCircles; i++) {

                    fill(cirgap * i, 255, 255);
                    ellipse(cw / 2 + (i * cw), cy, cw, cw);
                }
        }
    }
}
