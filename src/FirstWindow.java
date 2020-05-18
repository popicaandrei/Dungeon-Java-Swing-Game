import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstWindow extends JFrame {

    public static final int sceneDimension = 700;
    private JCheckBox avatar1, avatar2, avatar3;
    public static JButton startButton;
    public static JLabel welcome;
    public static int ok = 0;

    FirstWindow() {

        setTitle("Dungeon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, sceneDimension, sceneDimension);


        welcomeLabel();
        buttonFirst();
        checkBoxes();

        Dimension size = startButton.getPreferredSize();
        Dimension size1 = avatar1.getPreferredSize();
        Dimension size2 = avatar2.getPreferredSize();
        Dimension size3 = avatar3.getPreferredSize();

        Hero hero1 = null;
        Hero hero2 = null;
        Hero hero3 = null;

        try {

            JPanelWithBackground panel = new JPanelWithBackground("A:\\jocjoc\\src\\Icon\\dungeon.jpg");
            panel.setSize(700, 700);
            this.getContentPane().add(panel);
            this.add(panel);
            startButton.setBounds(250, 500, size.width, size.height);
            panel.setLayout(null);
            panel.add(startButton);
            panel.add(welcome);

            try {

                hero1 = new Hero(ImageIO.read(new File("A:\\jocjoc\\src\\Icon\\Rogue.png")));
                hero1.setBounds(210, 240, 50, 50);
                hero1.setVisible(true);
                panel.add(hero1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            try {

                hero2 = new Hero(ImageIO.read(new File("A:\\jocjoc\\src\\Icon\\Mage.png")));
                hero2.setBounds(310, 240, 50, 50);
                hero2.setVisible(true);
                panel.add(hero2);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            try {
                hero3 = new Hero(ImageIO.read(new File("A:\\jocjoc\\src\\Icon\\Warrior.png")));
                hero3.setBounds(410, 240, 50, 50);
                hero3.setVisible(true);
                panel.add(hero3);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            avatar1.setBounds(200, 300, size1.width, size1.height);
            avatar2.setBounds(300, 300, size2.width, size3.height);
            avatar3.setBounds(400, 300, size3.width, size3.height);

            panel.add(avatar1);
            panel.add(avatar2);
            panel.add(avatar3);
            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);

        final Hero h1 = hero1;
        final Hero h2 = hero2;
        final Hero h3 = hero3;

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                new Thread(() -> {
                    List<Enemy> enemies = new ArrayList<>();
                    for (int i = 0; i < 12; i++) {
                        try {

                            Enemy enemy = new Enemy(ImageIO.read(new File("A:\\jocjoc\\src\\Icon\\Gargoyle.png")));
                            enemy.setSize(80, 80);
                            enemies.add(enemy);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    Hero hero = null;
                    if (avatar1.isSelected()) hero = h1;
                    else if (avatar2.isSelected()) hero = h2;
                    else if (avatar3.isSelected()) hero = h3;
                    hero.setSize(80, 80);

                    new GameScene(hero, enemies);
                    new Engine(enemies, hero).start();

                }).start();
            }
        });
    }

    public void welcomeLabel() {
        welcome = new JLabel("Welcome to the Dungeon!");
        welcome.setBounds(220, 15, 300, 100);
        welcome.setFont(new java.awt.Font("Verdana", Font.BOLD, 20));
        welcome.setForeground(Color.WHITE);
        welcome.setVisible(true);

    }

    public void buttonFirst() {
        startButton = new JButton();
        startButton.setText("Ready, let's start!");
        startButton.setFont(new java.awt.Font("Verdana", Font.BOLD, 15));
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(Color.WHITE);
        startButton.setEnabled(true);
        startButton.setVisible(true);
    }

    public void checkBoxes() {
        avatar1 = new JCheckBox(" Rogue ");
        avatar2 = new JCheckBox(" Mage ");
        avatar3 = new JCheckBox(" Warrior ");
        avatar1.setVisible(true);
        avatar2.setVisible(true);
        avatar3.setVisible(true);
    }

    public static void main(String[] args) {
        new FirstWindow();
    }
}

