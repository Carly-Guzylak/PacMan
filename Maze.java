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
        }    
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
