package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {
    
    //encapsulating columns of interest into fields of the class
    private boolean hab; //only accessed by methods inside the star class 
    private String displayName;
    private float distance;
    private float xG, yG,zG; 
    private float absMag;


    //toString method converts everything to a string 
    //@Override
    public String toString() {

        return hab + "\t" + displayName + "\t" + distance + "\t" + xG  + "\t" + yG + "\t" + zG;
    }

    //constructors 
    public Star() { //default constructor - no return types

    }

    public void render(PApplet pa) { //passing PApplets to Star Clas from StarMap

        float border = pa.width * 0.1f;
        float x = PApplet.map(xG, -5, 5, border, pa.width - border);
        float y = PApplet.map(yG, -5, 5, border, pa.width - border);
        pa.stroke(255, 255, 0);
        pa.line(x - 5, y, x + 5, y);
        pa.line(x, y - 5, x,  y + 5);
        pa.stroke(255, 0, 0);
        pa.noFill();;
        pa.circle(x, y, absMag);
        pa.textAlign(PApplet.LEFT, PApplet.CENTER);
        pa.text(displayName, x + 10, y);
    }

    //takes a table row and creates star from table row
    public Star(TableRow row) { 

        //constructor chaining - calling constructors from another constructor
        this(
            row.getInt("Hab?") == 1 ? true : false,
            row.getString("Display Name"),
            row.getFloat("Distance"),
            row.getFloat("Xg"), 
            row.getFloat("Yg"),
            row.getFloat("Zg"),
            row.getFloat("AbsMag")
        );
    }

    //parameterised constructor
    public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) {

        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance; 
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;

    }


    //using accessors to access the private fields 

    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getxG() {
        return xG;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public float getyG() {
        return yG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public float getzG() {
        return zG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }
    

    
    
}
