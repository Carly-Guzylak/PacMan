import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
   private String score;
   private int intScore;
   private JLabel scoreLabel = new JLabel();
   
   public ScorePanel(int score, Color color) {
      super();
      this.score = "" + score;
      scoreLabel.setText(this.score);
      setBackground(color);
      
   }
   
  public void addToScore(int i) {
    intScore++;
    score = String.valueOf(intScore);
  }
   
  public void reset() {
	  score = "0";
	  intScore = 0;
	  scoreLabel = new JLabel();
  }
  
}
