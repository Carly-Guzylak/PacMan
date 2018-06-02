import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
   private String score;
   private JLabel scoreLabel = new JLabel();
   
   public ScorePanel(int score, Color color) {
      super();
      this.score = "" + score;
      scoreLabel.setText(this.score);
      setBackground(color);
      
   }
   
}
