import javax.swing.*;
import java.awt.*;

public class Enemy extends JComponent {
    public static int enemySize = 40;
    private Image imagine;

    public Enemy(Image image) {
        this.imagine = image;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        G.drawImage(imagine, 0, 0, 60, 60, null);
    }
}
