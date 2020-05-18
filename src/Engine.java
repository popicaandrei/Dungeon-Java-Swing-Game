import javax.swing.*;
import java.util.List;

public class Engine {
    private List<Enemy> enemies;
    private boolean collision;
    private int speed = 35;
    private Hero hero;
    JFrame GameScene;
    public static int numar = 0;

    public Engine(List<Enemy> enemies, Hero hero) {
        this.enemies = enemies;
        this.hero = hero;
    }

    public void start() {
        while (!collision) {
            enemies.forEach(e -> {
                e.setLocation(e.getX(), e.getY() + speed);

                if (e.getY() >= FirstWindow.sceneDimension) {
                    e.setLocation((int) (Math.random() * 650), 20);
                }

                if (e.getX() < hero.getX() + Hero.heroSize && e.getX() + Hero.heroSize > hero.getX() &&
                        e.getY() < hero.getY() + Hero.heroSize && e.getY() + Hero.heroSize > hero.getY())
                    JOptionPane.showMessageDialog(new JFrame(), "Game Over", "Bye", JOptionPane.INFORMATION_MESSAGE);
                collision = false;

            });
            try {
                Thread.sleep(250);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
