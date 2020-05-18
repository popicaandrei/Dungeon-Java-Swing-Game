import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;


public class GameScene extends JFrame {

    List<Enemy> enemies;
    Hero hero;
    static Container back2;
    JLabel livesCounts;
    Image imagine;

    GameScene(Hero hero, List<Enemy> enemies) {

        setTitle("Dungeon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FirstWindow.sceneDimension, FirstWindow.sceneDimension);


        livesCounts = new JLabel("Lives: ");
        livesCounts.setLocation(10, 650);
        livesCounts.setVisible(true);
        livesCounts.setForeground(Color.WHITE);
        add(livesCounts);

        this.back2 = getContentPane();
        this.back2.setBackground(Color.LIGHT_GRAY);

        this.setLayout(null);
        this.hero = hero;
        this.hero.setLocation(350, 600);
        hero.setSize(50, 50);
        add(this.hero);

        int distance = 700 / enemies.size();
        int[] c = {0};

        enemies.forEach(e -> {
            e.setLocation((int) (Math.random() * 400) + c[0] * distance, (int) (Math.random() * 300));
            this.add(e);
            c[0] += 1;
        });

        setVisible(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'a') hero.setLocation(hero.getX() - 18, hero.getY());
                else if (e.getKeyChar() == 'd') hero.setLocation(hero.getX() + 18, hero.getY());
                else if (e.getKeyChar() == 'w') hero.setLocation(hero.getX(), hero.getY() - 18);
                else if (e.getKeyChar() == 's') hero.setLocation(hero.getX(), hero.getY() + 18);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}
