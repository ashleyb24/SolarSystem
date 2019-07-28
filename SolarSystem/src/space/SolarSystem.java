package space;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Animation of the first four planets of the solar system
 * with start and stop buttons.
 */
public class SolarSystem {
  /** Create and display JFrame containing animation GUI panel */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,400);
        JPanel panel = new AnimationGuiPanel();
        frame.add(panel);
        frame.setVisible(true);
    });
  }
}

