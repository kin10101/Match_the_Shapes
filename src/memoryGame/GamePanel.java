package memoryGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class GamePanel extends JPanel {
    public static int points = 0;
    static JPanel gamePanel;
    static String[] pngs = {
            "/memoryGame/images/1.png", "/memoryGame/images/2.png", "/memoryGame/images/3.png",
            "/memoryGame/images/4.png", "/memoryGame/images/5.png",
            "/memoryGame/images/6.png", "/memoryGame/images/7.png", "/memoryGame/images/8.png"
    };

    static JButton[] b;
    static int matchedCards = 0;
    //click trackers
    public int currentCard;
    public int otherCard;
    public int numClicks;
    int numButtons;
    ImageIcon cardBack = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/memoryGame/images/9.png")));
    ImageIcon[] icons;
    Timer timer;
    int clickedCards;
    private boolean gameEnd = false;


    public GamePanel() {
        startGame();
        System.out.println("is game over?:" + gameEnd);

    }

    //getters
    public static int getMatchedCards() {
        return matchedCards;
    }

    public static int getPoints() {
        return points;
    }


    public void startGame() {
        //initialize
        gamePanel = new JPanel();
        //panelSetup
        gamePanel.setLayout(new GridLayout(4, 4));
        addButtons();
        randomizer();
    }

    private void addButtons() {
        numButtons = pngs.length * 2;
        b = new JButton[numButtons];
        icons = new ImageIcon[numButtons];


        for (int i = 0, j = 0; i < pngs.length; i++) {
            icons[j] = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(pngs[i])));
            b[j] = new JButton("");
            b[j].addActionListener(new ImageButtonListener());
            b[j].setIcon(cardBack);
            b[j].setBackground(Color.white);
            gamePanel.add(b[j++]);

            icons[j] = icons[j - 1];
            b[j] = new JButton("");
            b[j].setIcon(cardBack);
            b[j].setBackground(Color.white);
            b[j].addActionListener(new ImageButtonListener());
            gamePanel.add(b[j++]);
        }


        timer = new Timer(500, new TimerListener());
    }

    public void randomizer() {

        Random random = new Random();
        for (int i = 0; i < numButtons; i++) {
            int j = random.nextInt(numButtons);
            ImageIcon temp = icons[i];
            icons[i] = icons[j];
            icons[j] = temp;
        }

    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    private void resetGame() {
        clickedCards = 0;
        matchedCards = 0;
        points = 0;
        ButtonPanel.score.setText(Integer.toString(matchedCards));
        ButtonPanel.points.setText(Integer.toString(points));

        setGameEnd(false);
        for (int i = 0, j = 0; i < pngs.length; i++) {

            b[j].setIcon(cardBack);
            b[j].setBackground(Color.white);
            gamePanel.add(b[j++]);

            icons[j] = icons[j - 1];
            b[j].setIcon(cardBack);
            b[j].setBackground(Color.white);
            gamePanel.add(b[j++]);
        }

        Random random = new Random();
        for (int i = 0; i < numButtons; i++) {
            int j = random.nextInt(numButtons);
            ImageIcon temp = icons[i];
            icons[i] = icons[j];
            icons[j] = temp;
        }

    }

    //flips the card back when wrong
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            b[currentCard].setIcon(cardBack);
            b[otherCard].setIcon(cardBack);
            timer.stop();
        }
    }

    private class ImageButtonListener implements ActionListener {
        @Override

        //per click
        public void actionPerformed(ActionEvent e) {
            if (timer.isRunning())
                return;
            clickedCards++;


            for (int i = 0; i < numButtons; i++) {
                if (e.getSource() == b[i]) {
                    b[i].setIcon(icons[i]);
                    currentCard = i;
                }
            }

            //when clicked two incorrect cards
            if (clickedCards % 2 == 0) {
                points -= 5;
                System.out.println(points);
                if (currentCard == otherCard) {
                    numClicks--;
                    return;
                }
                if (icons[currentCard] != icons[otherCard]) {
                    timer.start();
                    //if correct cards
                } else {
                    matchedCards++;
                    points += 105;
                    ButtonPanel.score.setText(Integer.toString(matchedCards));
                    ButtonPanel.points.setText(Integer.toString(points));

                    if (matchedCards == 8) {
                        setGameEnd(true);
                        System.out.println("is game over? "+isGameEnd());
                        if (gameEnd) {
                            JOptionPane.showMessageDialog(gamePanel, "You win by " + clickedCards + " turns");

                            resetGame();

                        }

                    }
                }
            } else {
                otherCard = currentCard;
            }

        }
    }


}
