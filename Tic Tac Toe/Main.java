import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
        panel.setLayout(new GridLayout(3,1));
        JButton tictacButton = new JButton();
        tictacButton.setText("Tic Tac Toe");
        tictacButton.setFont(new Font("Arial", Font.BOLD, 30));
        tictacButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                rungame tttGame = new rungame();
                tttGame.askGame();
            }
        });
        JButton wordleButton = new JButton();
        wordleButton.setText("Wordle");
        wordleButton.setFont(new Font("Arial", Font.BOLD, 30));
        wordleButton.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e){
                wrdle wordleGame = new wrdle();
                wordleGame.wordleGame();
            }
        }));
        JButton exitbutton = new JButton();
        exitbutton.setText("Exit");
        exitbutton.setFont(new Font("Arial", Font.BOLD, 30));
        exitbutton.addActionListener((new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
            }
        }));
        panel.add(tictacButton);
        panel.add(wordleButton);
        panel.add(exitbutton);

        frame.add(panel);
        frame.setSize(300,400);
        frame.setResizable(true);
        frame.setTitle("Game Selector");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
