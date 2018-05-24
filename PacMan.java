import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.BoxLayout;

public class PacMan extends JPanel {
    private static final long serialVersionUID = 1L;
    private ScorePanel scorePanel = new ScorePanel(0, Color.YELLOW);
    private GamePanel gamePanel = new GamePanel(scorePanel);
  
    public static void main(String[] args) throws Exception{
        String className = UIManager.getCrossPlatformLookAndFeelClassName();
        UIManager.setLookAndFeel(className); 
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PacMan();
            }
        });
    }
   
    public PacMan() {
        initGUI();
        setTitle("PacMan");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    private void initGUI() {
        JLabel titleLabel = new JLabel("PacMan");
        add(titleLabel, BorderLayout.PAGE_START);
        //mainPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel, BorderLayout.CENTER);
        //scorePanel
        mainPanel.add(scorePanel);
        //gamePanel
        mainPanel.add(gamePanel);
    }
}
