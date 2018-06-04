import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

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
    private int catCol;
    private ArrayList<Integer> extraMiceX = new ArrayList<Integer>();
    private ArrayList<Integer> extraMiceY = new ArrayList<Integer>();
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
            cell = new int[rows][columns];
            //Note from Book: Maze Data file uses the capital letter M to represent the starting cell
            // for the main mouse, the capital letter C to represent the starting cell for the cat, and
            // the lowercase letter m to represent the cell for the extra mice.  In file provided,
            // main mouse will be in a path without cheese, cat will be in a path with cheese, and extra
            // mice will be in wall area.
            for(int row = 0; row < rows; row++) {
                line = mazeData.get(row);
                if(line.length() != columns) {
                    throw new InvalidMazeRowLengthException(row, FILE_NAME) ; 
                }
                for(int col = 0; col < columns; col++) {
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
                            break;
                        case 4: c = 'M';
                            cell[row][col] = TYPE_PATH;
                            mouseRow = row;
                            mouseCol = col;
                            break;
                        case 5: c = 'C';
                            cell[row][col] = TYPE_CHEESE;
                            catRow = row;
                            catCol = col;
                            cheeseCount++;
                            break;
                        case 6: c = 'm';  
                            cell[row][col] = TYPE_WALL;
                            int x = col * CELL_SIZE;
                            int y = row * CELL_SIZE;
                            extraMiceX.add(x);
                            extraMiceY.add(y);
                        default:
                            throw new InvalidMazeCharacterException(c, FILE_NAME);
                        //end of page 323    
                    }//switch
                }//2nd for
            }//1st for
        }//try    
        catch(NullPointerException e) {
            String message = "Maze file " + FILE_NAME + " could not be found";
            JOptionPane.showMessageDialog(null, message);
            System.exit(1);
        }
        catch(IOException e) {
            String message = "Maze file " + FILE_NAME + " could not be opened"; 
            JOptionPane.showMessageDialog(null, message);
            System.exit(2);
        }
        //page 327
        catch(InvalidMazeCharacterException e) {
            String message = e.getMessage();
            JOptionPane.showMessageDialog(null, message);
            System.exit(3);
        }
        catch(InvalidMazeRowLengthException e) {
            String message = e.getMessage();
            JOptionPane.showMessageDialog(null, message);
            System.exit(4);
        }
    }
    public int getWidth() {
        return columns * CELL_SIZE;    
    }
    public int getHeight() {
        return rows * CELL_SIZE;    
    }
    //end of page 319
    public void draw(Graphics g) {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                //draw wall
                if(cell[row][col] != TYPE_WALL) {
                    int x = col * CELL_SIZE;
                    int y = row * CELL_SIZE;
                    g.setColor(Color.white);
                    g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                
                    //draw cheese
                    if(cell[row][col] == TYPE_CHEESE) {
                        g.setColor(Color.yellow);
                        g.fillOval(x + QUARTER_CELL_SIZE, y + QUARTER_CELL_SIZE, HALF_CELL_SIZE, HALF_CELL_SIZE);
                    }
                }
            }
        }
        //end of page 324
    }
}
