//Exit Code for Normal Exit = 0
//Exit Code for NullPointerException = 1
//Exit Code for IOExeption = 2
//Exit code for InvalidCharacterException = 3
//Exit code for InvalidMazeRowLengthException = 4;

//NOTE:  Where to use InvalidDataException??? pg 336

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class PacMan extends JFrame {
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
        TitleLabel titleLabel = new TitleLabel("PacMan");
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
