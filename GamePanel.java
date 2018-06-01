import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel{

    private static final long serialVersionUID = 1L;
    private ScorePanel scorePanel;
    private int width = 640;
    private int height = 400;
    private Maze maze;
    //private Mouse mouse;
    //end of page 314
    
    public GamePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
        maze = new Maze();
        width = maze.getWidth();
        height = maze.getHeight();
        //initGUI();
        //mouse = Mouse(this.gamePanel, this.Maze);
    }
    
 //   private void initGUI() {
  //      setFocusable(true);
   //     requestFocusInWindow();
        //listeners
  //      addKeyListener(new KeyAdapter()) {
  //      keypressed(KeyEvent e);
  //      int direction = Mouse.DIRECTION_NONE;
 //       int code = e.getKeyCode();
  //      switch(direction) {
   //     case 1:
  //          direction = Mouse.DIRECTION_UP;
  //          break;
  //      case 2:
 //           direction = Mouse.DIRECTION_DOWN;
 //           break;
 //       case 3:   
 //           direction = Mouse.DIRECTION_LEFT;
 //           break;
//        case 4:    
 //           direction = Mouse.DIRECTION_RIGHT;
 //           break;
 //       //timers
 //   }
    
    public Dimension getPreferredSize() {
        Dimension size = new Dimension(width, height);
        return size;
    }
    
    public void paintComponent(Graphics g) {
        //background
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, width, height);
        //maze
        //maze.draw(g);
        //mouse
        //mouse.draw();
        //extra mice
        //cat
    }
    //end of page 315
}
