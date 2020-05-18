import javax.swing.*;
import java.awt.*;

public class Hero extends JPanel {

    public static final int heroSize = 50;
    private Image imagine;

    public Hero(Image image) {
        this.imagine = image;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        G.drawImage(imagine, 0, 0, heroSize, heroSize, null);
    }

}