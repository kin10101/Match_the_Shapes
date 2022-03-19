package memoryGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    static GamePanel MGP;
    static StartPanel SP;
    static ButtonPanel BBP;
    JFrame frame;

    public GameFrame() {
        //initialize

        SP = new StartPanel();
        frame = new JFrame("Match The Shapes!");
        MGP = new GamePanel();
        BBP = new ButtonPanel();

        //frame setup
        frame.setSize(615, 700);
        frame.setLocation(400, 0);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        //app icon
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GameFrame.class.getResource("/memoryGame/images/LOGO.png")));

        //adding Panel components
        frame.add(SP.start);
        SP.start.setBounds(0, 0, 600, 700);
        frame.add(GamePanel.gamePanel);
        GamePanel.gamePanel.setBounds(0, 0, 600, 600);
        GamePanel.gamePanel.setVisible(false);
        frame.add(ButtonPanel.BP);
        ButtonPanel.BP.setBounds(0, 600, 600, 100);
        ButtonPanel.BP.setVisible(false);





    }


}
