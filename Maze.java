public class Maze {
  public static final int CELL_SIZE = 30;
  public static final String FILE_NAME = "/maze.txt"
  private static final int HALF_CELL_SIZE = CELL_SIZE / 2;
  private static final int QUARTER_CELL_SIZE = CELL_SIZE / 4;
  private static final int TYPE_PATH = 0;
  private static final int TYPE_WALL = 1;
  private static final int TYPE_CHEESE = 2;
  private int rows;
  private int columns;
  private ArrayList<String> mazeData = Maze();
  
  public Maze() {
    readMazeData();
  }
}
