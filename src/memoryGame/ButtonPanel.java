package memoryGame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static memoryGame.GameFrame.SP;

public class ButtonPanel {
    static JPanel BP;
    static JLabel score;
    static JLabel points;
    JButton b2;
    JButton b3;
    JLabel label, plabel;


    public ButtonPanel() {

        BP = new JPanel();
        b2 = new JButton("exit");
        b3 = new JButton("back To Main Menu");
        label = new JLabel();
        score = new JLabel();
        plabel = new JLabel();
        points = new JLabel();


        BP = new JPanel();
        BP.setLayout(null);
        BP.setBackground(Color.white);


        BP.add(b2);
        BP.add(b3);
        BP.add(plabel);
        BP.add(label);
        BP.add(score);
        BP.add(points);

        b2.setBounds(10, 5, 90, 50);
        b2.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/memoryGame/images/EXIT.png"))));

        b3.setBounds(110, 5, 140, 50);
        b3.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/memoryGame/Images/Bac.png"))));

        plabel.setBounds(300, 20, 100, 30);
        plabel.setText("Points: ");

        label.setBounds(300, 3, 100, 30);
        label.setText("Matched Cards: ");

        score.setBounds(400, 3, 100, 30);
        score.setText(" " + GamePanel.getMatchedCards());

        points.setBounds(400, 10, 100, 50);
        points.setText(" " + GamePanel.getPoints());


        b2.addActionListener(e -> System.exit(0));

        b3.addActionListener(e -> {
            SP.start.setVisible(true);
            GamePanel.gamePanel.setVisible(false);
            ButtonPanel.BP.setVisible(false);
        });


    }
}
