import java.io.*;
import java.util.*;
import javax.swing.*;

public class Maze {
    public static final int CELL_SIZE = 30;
    public static final String FILE_NAME = "/maze.txt";
    private static final int HALF_CELL_SIZE = CELL_SIZE / 2;
    private static final int QUARTER_CELL_SIZE = CELL_SIZE / 4;
    private static final int TYPE_PATH = 0;
    private static final int TYPE_WALL = 1;
    private static final int TYPE_CHEESE = 2;
    private int rows;
    private int columns;
    private ArrayList<String> mazeData = new ArrayList<String>();
    private int [][]cell;
    private int cheeseCount = 0;
    private int mouseRow;
    private int mouseCol;
    private int catRow;
    private int calCol;
    private ArrayList<Integer> extraMiceX = new ArrayList<Integer>;
    private ArrayList<Integer> extraMiceY = new ArrayList<Integer>;
    //Note from book: Maze Data file has the capital letter X to represent walls,
    // a space to represent a path with nothing in it, and a period to represent a path
    // with a piece of cheese in it.
  
    public Maze() {
        readMazeData();
    }
    private void readMazeData() {
        try {
            InputStream input = getClass().getResourceAsStream(FILE_NAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String line = in.readLine();
            while(line != null){
                mazeData.add(line);   
                line = in.readLine();
            }
            in.close();
            rows = mazeData.size();
            line = mazeData.get(0);
            columns = line.length();
            //end of page 318
            cell = new Array[rows][columns];
            for(int row = 0; row <= rows; row++) {
                line = mazeData.get(row);
                for(int col = 0; col <= columns; col++) {
                    char c = line.charAt(col);   
                    switch (c) {
                        case 1: c = 'X';    
                            cell[row][col] = TYPE_WALL; 
                            break;
                        case 2: c = ' ';
                            cell[row][col] = TYPE_PATH;
                            break;
                        case 3: c = '.';
                            cell[row][col] = TYPE_CHEESE;
                            cheeseCount++;
                            breakl;
                    }//switch
                }//2nd for
            }//1st for
        }//try    
        catch(NullPointerException e) {
            String message = "File not found.";
            JOptionPane.showMessageDialog(null, message);
            System.exit(1);
        }
        catch(IOException e) {
            String message = "File cannot be opened."; 
            JOptionPane.showMessageDialog(null, message);
            System.exit(2);
        }
    }
    public int getWidth() {
        return columns * CELL_SIZE;    
    }
    public int getHeight() {
        return rows * CELL_SIZE;    
    }
    //end of page 319
}
