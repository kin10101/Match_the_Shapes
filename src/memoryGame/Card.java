//package memoryGame;
//
//import javax.swing.*;
//import java.util.Arrays;
//
//
//public class Card extends JButton{
//
//    ImageIcon cardBack = new ImageIcon("/memoryGame/images/dicc.png");
//    ImageIcon[] cards;
//
//    String[] pngs = {
//            "/memoryGame/images/1w.png",
//            "/memoryGame/images/1b.png",
//            "/memoryGame/images/2w.png",
//            "/memoryGame/images/2b.png",
//            "/memoryGame/images/3w.png",
//            "/memoryGame/images/3b.png",
//            "/memoryGame/images/4w.png",
//            "/memoryGame/images/4b.png",
//
//
//    };
//
//    public Card(){
//
//    }
//
//
//    public Card(ImageIcon cardBack, ImageIcon[] cards, String[] pngs){
//        super();
//        this.cardBack = cardBack;
//        this.cards = cards;
//        this.pngs = pngs;
//    }
//
//    public ImageIcon getCardBack() {
//        return cardBack;
//    }
//
//    public void setCardBack(ImageIcon cardBack) {
//        this.cardBack = cardBack;
//    }
//
//    public ImageIcon[] getCards() {
//        return cards;
//    }
//
//    public void setCards(ImageIcon[] cards) {
//        this.cards = cards;
//    }
//
//    @Override
//    public String toString() {
//        return "Card{" +
//                "cardBack=" + cardBack +
//                ", cards=" + Arrays.toString(cards) +
//                ", pngs=" + Arrays.toString(pngs) +
//                '}';
//    }
//}
