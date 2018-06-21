import java.io.IOException;
import javax.swing.JOptionPane;
//hello
public class Mouse extends MazeRunner{
    //directions in clockwise rotational order
    public static final String MOUSE_UP = "/mouseUp.gif";
    public static final String MOUSE_DOWN = "/mouseDown.gif";
    public static final String MOUSE_LEFT = "/mouseLeft.gif";
    public static final String MOUSE_RIGHT = "/mouseRight.gif";
    
    private static final int DEFAULT_SPEED = 10;
    
    public final MouseRunState STATE_RUN = new MouseRunState(this);
    public final MouseWaitState STATE_WAIT = new MouseWaitState(this);
    
    private GamePanel gamePanel;
    
    public Mouse(GamePanel gamePanel, Maze maze) {
        this.gamePanel = gamePanel;
        this.maze = maze;
        x = maze.getMouseX();
        y = maze.getMouseY();
        direction = DIRECTION_DOWN;
        changeX = 0;
        changeY = 1;
        speed = DEFAULT_SPEED;
        state = STATE_WAIT;
     
        try {
            setImage(DIRECTION_UP, MOUSE_UP);
            setImage(DIRECTION_DOWN, MOUSE_DOWN);
            setImage(DIRECTION_LEFT, MOUSE_LEFT);
            setImage(DIRECTION_RIGHT, MOUSE_RIGHT);
        } 
        catch (IOException e) {
            String message = "Couldn't read mouse image files";
            JOptionPane.showMessageDialog(null, message);
            System.exit(5);
        }
    }  
        
    public void run() {
    	if(foundCheese()) {
    		eatCheese();
    	}
    	if(!(wallInDirection(direction))) {
            x = x + (changeX * speed);
            y = y + (changeY * speed);
    	}
    }
    
    public void stop() {
       	changeX = 0;
       	changeY = 0;
    } 
    
    public void eatCheese() {
    	maze.removeCheese(x, y);
    	gamePanel.increaseScore();
    }
    
    public boolean foundCheese() {
        boolean foundCheese = false;
        if (maze.hasCheeseAt(x, y)) {
        	foundCheese = true;
        }
        return foundCheese;
    }
    
    public int getX(){
    	return x;
    }
    
    public int getY() {
        return y;	  	
    }
    
}































