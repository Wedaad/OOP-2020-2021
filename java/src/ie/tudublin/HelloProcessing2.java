package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing2 extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		
	}
	
	public void draw()
	{	
		background(255, 0, 0); //sets background colour
		stroke(0, 255, 0);   //sets the pen colour 
		//line(10, 10, 200, 200);//x1, y1, x2, y2

		noStroke(); //changes the outline on the shapes
		fill(255, 255, 0);
		ellipse(250, 320, 360, 360); //drawing a circle  //cx, cy, w, h

		fill(0, 255, 255);
		triangle(50, 450, 250, 80, 450, 450);//drawing a triangle x1, y1, x2, y2, x3, y3

		fill(169, 169, 169);
		ellipse(250, 260, 185, 100); //drawing a circle  //cx, cy, w, h

		fill(0);
		ellipse(250, 260, 60, 60); //drawing a circle  //cx, cy, w, h

		//fill(0, 0, 255);
		//rect(20, 100, 70, 90); //drawing a rectangle  //topleftx (tlx), toplefty(tly), w, h 
		//point(200, 60);
		 

		//drawing text to the screen
		//fill(0);
		//text("Hello World", 300, 300);//passing the text we want to print and the coordinates 
	}
}
