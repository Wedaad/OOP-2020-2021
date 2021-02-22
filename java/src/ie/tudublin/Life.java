package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    int  size = 100; //board is 100 x 100
    float cellSize; //width of the screen / board size = cellSize (5) 
    boolean[][] board = new boolean[size][size]; //boolean 2d array

    public int countCellsAround(int row, int col) {

        int count = 0;

        //use getCell here
        for(int r = row - 1; r <= row + 1; r++) {

            for(int c = col - 1; c <= col + 1; c++) {


                if(r != row && c != col) {

                    if(getCell(board, r, c)) {

                        count++;
                    }  

                }

            }

        }
        
        return count;
    } 

    //sets the cell at row and col at value b
    public void setCell(boolean[][] board, int row, int col, boolean b) {

        //bounce checking to make sure we dont read or write outside the array
        if(row > 0 && row < size - 1 && col > 0 && col < size - 1) {

            board[row][col] = b;  //assigning boolean value at some row or col in the boolean array 
        }

    }

    //getter method that returns a cell 
    public boolean getCell(boolean[][] board, int row, int col) {

        if(row > 0 && row < size - 1 && col > 0 && col < size - 1) {

            return board[row][col];
        }
        else {

            return false;
        }

    }

    public void drawBoard(boolean[][] board) {

        //use rect to draw the cell
        //use nested loop
        //use map to calculate x and y 
        //use cellSize variable
        //use some colours 
        //if the cell is set to true colour it in and if the cell is set to false then it's blank
        for(int row = 0; row < size; row++) {

            for(int col = 0; col < size; col++) {

                // float x = col * cellSize;
                // float y =  row * cellSize;
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);

                if(board[row][col]) {

                    rect(x, y, cellSize, cellSize);

                }
                
                fill(225);
            
            }


        } 
        
    }
    
    private void printBoard(boolean[][] board) {

        for(int row = 0; row < size; row++) {

            for(int col = 0; col < size; col++) {

                print(board[row][col] ? 1 : 0); //printing elements in the 2d array to be 1 or 0 depending whether if it's true or false 

            }//ends inner for
            println();

        }//ends outer for

    }
    
    
    
    public void randomize() {

        for(int row = 0; row < size; row++) {

            for(int col = 0; col < size; col++) {

                float dice = random(0.0f, 1.0f);

                // if(dice < 0.5) {

                //     board[row][col] = true; 
                // }
                // else {

                //     board[row][col] = false; 

                // }

                board[row][col] = (dice < 0.5f) ? true : false; //setting half of the board to true and the cells to be false
            }
        }

    }
    public void settings() {
        size(500, 500);

    }


    int mode = 0;
    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }


    public void setup() {
        colorMode(RGB);
        //randomize();
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;

        println(countCellsAround(0, 2));

        cellSize = width / (float) size;

        //printBoard(board);
        
    }


    public void draw() {
        background(0);
        drawBoard(board);
    }
}
