package memoryGame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StartPanel {
    JPanel start;
    JButton sButton;
    JLabel titleName, instructions;


    public StartPanel() {
        sButton = new JButton();
        start = new JPanel();
        titleName = new JLabel();
        instructions = new JLabel();


        start.setBackground(Color.white);
        start.setLayout(null);
        start.setVisible(true);

        titleName.setBounds(-10,10,600,300);
        titleName.setIcon((new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/memoryGame/images/MM.png")))));

        instructions.setBounds(-13,400,600,300);
        instructions.setIcon((new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/memoryGame/images/INS.png")))));


        sButton.setIcon(new ImageIcon(Objects.requireNonNull(StartPanel.class.getResource("/memoryGame/images/Play.png"))));
        sButton.setBounds(250, 300, 100, 100);



        start.add(sButton);
        start.add(titleName);
        start.add(instructions);

        //start button action listener
        sButton.addActionListener(e -> {
            start.setVisible(false);
            GamePanel.gamePanel.setVisible(true);
            ButtonPanel.BP.setVisible(true);
        });


    }
}
