package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {

    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples

    float[] lerpedBuffer;

    public void settings() {
        size(512, 512);
        // fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ap = minim.loadFile("heroplanet.mp3", width);
        //ab = ai.mix; // Connect the buffer to the mic
        ab = ap.mix; // Connect the buffer to the mp3 file
        colorMode(HSB);
        lerpedBuffer = new float[width]; //for smoothing out the movement

    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '6') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);
        float halfHeight = height / 2;
        float average = 0; //amplidtude of the samples 
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (which)
        {
            case 0: //wavy lines visual 
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, halfHeight + lerpedBuffer[i] * halfHeight * 4, i);
                }

                // See the difference lerping makes? It smooths out the jitteryness of average, so the visual looks smoother
                //ellipse(width / 4, 100, average * 500, average * 500);
                //ellipse(width / 2, 100, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        
                // This is another example of how lerping works
                //ellipse(200, y, 30, 30);
                //ellipse(300, lerpedY, 30, 30);

                //for the circles 
                //y += random(-10, 10);
                //lerpedY = lerp(lerpedY, y, 0.1f);
                break;
            }   
            case 1: //The waveform
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                }

                break;
            }
            case 2: //The waveform drawn down the 4 sides of the screen
            {

                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(0, i, lerpedBuffer[i] * halfHeight * 4, i);
                    line(width, i, width - ( lerpedBuffer[i] * halfHeight * 4), i);
                    line(i, 0, i, lerpedBuffer[i] * halfHeight * 4);
                    line(i, height, i, height - (lerpedBuffer[i] * halfHeight * 4));
                   
                }

                break;
            }
            case 3:
            {

                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    noFill();
                    float c = map(average, 0, 1, 0, 255);
                    stroke(c, 255, 255);
                    strokeWeight(2);

                    ellipse(width / 2, halfHeight, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
                    //ellipse(width / 2, halfHeight, 50 + (lerpedBuffer[i] * i), 50 + (lerpedBuffer[i] * i)); KEEP FOR ASSIGNMENT
                }


                break;
            }
            case 4:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    noFill();
                    float c = map(average, 0, 1, 0, 255); //changing the colour with respect to the increasing amplitude 
                    stroke(c, 255, 255);

                    rectMode(CENTER);
                    rect(width / 2, halfHeight, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));

                }

                break;
            }
            case 5:
            {
                
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    noFill();
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

                    ellipse(width / 2, halfHeight, 50 + (lerpedBuffer[i] * i), 50 + (lerpedBuffer[i] * i));
                }

                break;
            }

            case 6: //Drawing a Spiral
            {
                float r = 0.1f;
                int numPoints = 20; //num of points of the circle 
                float thetaInc = TWO_PI / (float) numPoints;
                strokeWeight(2);
                //stroke(255);
                float lastX = width / 2, lastY = halfHeight;
                
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(average, 0, 1, 0, 255);
                    stroke(c, 255, 255);
                    // float theta = i * thetaInc * lerpedAverage;
                    float theta = i * thetaInc * (50 + (lerpedAverage * 200)); // making it respond to sound here & my shapes 
                    //float theta = i * thetaInc + (50 + (lerpedAverage * 700)); //the pain spiral 
                    float x = width / 2 + sin(theta) * r;
                    float y = height / 2 - cos(theta) * r;
        
                    r += 0.7f * lerpedAverage;
                    line(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }

                break;
            }
        }        
    }
}