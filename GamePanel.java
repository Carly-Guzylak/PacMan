import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private ScorePanel scorePanel;
    private int width = 640;
    private int height = 400;
    private Maze maze;
    private Mouse mouse;
    private Timer timer;
    //end of page 314
    
    public GamePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
        maze = new Maze();
        width = maze.getWidth();
        height = maze.getHeight();
        initGUI();
        mouse = new Mouse(this, this.maze);
        timer.start();
    }
    
    private void initGUI() {
        setFocusable(true);
        requestFocusInWindow();
        //listeners
        addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		int direction = Mouse.DIRECTION_NONE;
        		int code = e.getKeyCode();
        		switch(code) {
        		case KeyEvent.VK_UP:
        			direction = Mouse.DIRECTION_UP;
        			break;
        		case KeyEvent.VK_DOWN:
        			direction = Mouse.DIRECTION_DOWN;
        			break;
        		case KeyEvent.VK_LEFT:   
        			direction = Mouse.DIRECTION_LEFT;
        			break;
        		case KeyEvent.VK_RIGHT:    
        			direction = Mouse.DIRECTION_RIGHT;
        			break;
        		}
        		if (direction != Mouse.DIRECTION_NONE) {
        			mouse.turn(direction) ;
        			//STATE_RUN couldn't be referenced because 
        			//it is non static, so created getStateRun()
        			mouse.setState(mouse.STATE_RUN);
        			repaint();
        		}
        	}	
        	public void keyReleased(KeyEvent e) {
        	    int code = e.getKeyCode();
        	    if (code == KeyEvent.VK_UP 
        	    	|| code == KeyEvent.VK_DOWN
        	    	|| code == KeyEvent.VK_LEFT
        	    	|| code == KeyEvent.VK_RIGHT) {
        	        mouse.setState(mouse.STATE_WAIT);
        	        repaint();
                }
        	}
        });
        //timers
        timer = new Timer(60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	timedAction();
            }
        });
    }
    
    public void timedAction() {
    	mouse.move();
    	repaint();
    }
    
    public Dimension getPreferredSize() {
        Dimension size = new Dimension(width, height);
        return size;
    }
    
    public void paintComponent(Graphics g) {
        //background
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, width, height);
        //maze
        maze.draw(g);
        //mouse
        mouse.draw(g);
        //extra mice
        //cat
    }
    //end of page 315
    
    public void increaseScore() {
    	scorePanel.addToScore(1);
    	if(maze.getRemainingCheese() == 0) {
    		String message = "You got all the cheese!";
    		endGame(message);
    	}
    }
    
    public void endGame(String message) {
    	timer.stop();
    	repaint();
    	message = message + " Do you want to play again?";
    	int option = JOptionPane.showConfirmDialog(this, message, "Play again?", JOptionPane.YES_NO_OPTION);
    	if(option == JOptionPane.YES_OPTION) {
    		newGame();
    	} else {
    		System.exit(0);
    	}
    }
    
    private void newGame() {
    	maze.reset();
    	scorePanel.reset();
    	mouse = new Mouse(this, maze);
    	timer.start();
    }
    
}































