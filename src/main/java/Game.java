import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Game extends JFrame {
    static Random randomNumb = new Random();   //Создание метода Random
    static int guesedNumb;
    static int tryes = 3;

    public static void startGame() {
        guesedNumb = randomNumb.nextInt(10); //Возвращаем guesedNumb методом рандома от 0 до 10
        System.out.println(guesedNumb);
    }

    public void getGuesedNumb() {
        System.out.println(guesedNumb);
    }

    public Game() {
        setTitle("Игра угадайка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 800, 400);

        setLayout(new GridLayout(3, 1));

        JTextField infoField = new JTextField();
        add(infoField);
        infoField.setHorizontalAlignment(infoField.CENTER);
        infoField.setBackground(Color.GRAY);
        infoField.setFont(new Font("Информация", Font.ITALIC, 25));
        infoField.setText("ИГРА НАЧАЛАСЬ! Угадайте число от 0 до 10");

        JTextField gameField = new JTextField();
        add(gameField);
        gameField.setHorizontalAlignment(gameField.CENTER);
        gameField.setFont(new Font("Информация", Font.BOLD, 25));
        gameField.setBackground(Color.BLUE);


        gameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(gameField.getText()); //не очень получилось приводить в каждом условии введённую строку к числу
//                do {
                    if (Integer.parseInt(gameField.getText()) == guesedNumb) {  //String.valueOf(guesedNumb) , Integer.toString(guesedNumb))
                        infoField.setText("Вы угадали число!!! Чтобы продолжить нажмите кнопку НОВАЯ ИГРА");
                        gameField.setText("");
                        return;
                    } else if (tryes == 0) {
                        infoField.setText("Вы проиграли! Чтобы продолжить нажмите кнопку НОВАЯ ИГРА");
                        gameField.setText("");
                        return;
                    }else if (Integer.parseInt(gameField.getText()) < guesedNumb) {
                        tryes--;
                        infoField.setText("Загаданное число больше. Осталось попыток: " + tryes);
                        gameField.setText("");
                    } else if (Integer.parseInt(gameField.getText()) > guesedNumb) {
                        tryes--;
                        infoField.setText("Загаданное число меньше. Осталось попыток: " + tryes);
                        gameField.setText("");
                    }
//                } while (tryes > 0);
            }
        });


        JButton newGameBtn = new JButton();
        add(newGameBtn);
        newGameBtn.setText("Новая игра!");
        newGameBtn.setFont(new Font("Информация", Font.BOLD, 25));
        newGameBtn.setBackground(Color.GRAY);

        newGameBtn.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                infoField.setText("Угадайте число от 0 до 10");
                startGame();
                tryes = 3;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


        setVisible(true);
    }


}
