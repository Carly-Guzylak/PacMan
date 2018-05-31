public class Mouse {
    //directions in clockwise rotational order
    public static final int DIRECTION_UP = 0;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_NONE = 4;
    public static final String MOUSE_UP = "mouseUp.gif";
    public static final String MOUSE_DOWN = "mouseDown.gif";
    public static final String MOUSE_LEFT = "mouseLeft.gif";
    public static final String MOUSE_RIGHT = "mouseRight.gif";
    private GamePanel gamePanel;
    private Maze maze;
    private int x;
    private int y;
    private int direction;
    private BufferedImage[] image = new BufferedImage[4];
    private int[] offsetX = new int[4];
    private int[] offsetY = new int[4];
    
    public Mouse(GamePanel gamePanel, Maze maze) [
        this.gamePanel = gamePanel;
        this.maze = maze;
        x = maze.getMouseX();
        y = maze.getMouseY();
        direction = DIRECTION_DOWN;
        try {
            setImage(DIRECTION_UP, MOUSE_UP);
            setImage(DIRECTION_DOWN, MOUSE_DOWN);
            setImage(DIRECTION_LEFT, MOUSE_LEFT);
            setImage(DIRECTION_RIGHT, MOUSE_RIGHT);
        } 
        catch (IOException e) {
            String message = "Couldn't be read";
            JOptionPane.showDialog(null, message);
            System.exit(5);
        }
    }
    
    public setImage(int direction, String fileName) throws IOException {
        InputStream input = getClass().getResourceAsStream(fileName);
        image[input] = ImageIO.read();
        int imageWidth = image[direction].getWidth();
        offsetX[direction] = Maze.CELL_SIZE - imageWidth;
        int imageHeight = image[direction].getHeight();
        offsetY[direction] = Maze.CELL_SIZE - imageHeight;
    }    
    
    public void draw(Graphics g) {
        int xPos = x + offsetX[direction];
        int yPos = y + offsetY[direction];
        g.drawImage(image[direction], xPos, yPos, null);
    }
}
