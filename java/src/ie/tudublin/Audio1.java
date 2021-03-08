package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {

    Minim minim; //connecting to minim
    AudioInput ai; // how we connect to mic
    AudioPlayer ap; //when loading an mp3 file
    AudioBuffer ab; //samples

    float[] lerpedBuffer;

    public void settings()
    {
        size(512, 512);
    }

    float y = 0;
    float lerpedY = 0;

    public void setup()
    {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16); //connection to the microphone made //no. of channel, frame, size, sample rate, bits
        //ap = minim.loadFile("heroplanet.mp3", width);
        //ap.play();
        ab = ai.mix; //connecting buffer to microphone
        //ab = ap.mix; // connects buffer to the mp3 file 

        //adding colours 
        colorMode(HSB);
        lerpedBuffer = new float[width];

    }

    float lerpedAverage = 0;

    public void draw()
    {
        
        background(0);
        stroke(225);
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;
        
        //iterating over audio buffer (an arrayList)
        for(int i = 0; i < ab.size(); i++) {

            float c = map(i, 0, ab.size(), 0, 255); //colours 
            stroke(c, 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            //line(i, halfHeight, i, halfHeight  + ab.get(i) * halfHeight);
            //line(i, halfHeight - lerpedBuffer[i] * halfHeight, i, halfHeight  + lerpedBuffer[i] * halfHeight); //making the wave more symmetrical
            line(i, halfHeight - lerpedBuffer[i] * halfHeight, halfHeight  + lerpedBuffer[i] * halfHeight, i);
            //println(ab.get(i)); //printing mic values in terminal

            //calculating the AVERAGE amplitude 
            sum += abs(ab.get(i)); //geting the absolute value
            //Math.abs(average); //another way of getting absolute value
        }

        average = sum / (float) ab.size();
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);
        ellipse(width / 4, 100, average * 500, average * 500);
        ellipse(width / 2, 100, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));

        // ellipse(200, y, 30, 30);
        // ellipse(300, lerpedY, 30, 30);
        // y += random(-10, 10);
        // lerpedY = lerp(lerpedY, y, 0.1f);
        

    
    }   
}