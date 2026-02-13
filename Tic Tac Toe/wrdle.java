import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Random;
public class wrdle {
    Scanner scnr;
    JPanel GPanel;
    JFrame GFrame;
    int guessNum = 0;

    void guessPlus(){
        guessNum++;
    }

    public void wordleGame(){



            try{
                Random rndm = new Random();
                FileInputStream wordList = new FileInputStream("wordList.txt");
                scnr = new Scanner(wordList);
                String[] words = scnr.nextLine().split(" ");
                String secretWord = words[rndm.nextInt(words.length+1)];
                String currentGuess = "";
                GFrame = new JFrame();
                GPanel = new JPanel();
                GPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
                GPanel.setLayout(new GridLayout(7,1));
                JLabel guesses[][] = new JLabel[6][5];
                for(int i = 0; i<6; i++){
                    for(int j = 0; j<5; j++){
                        guesses[i][j] = new JLabel("X");
                        guesses[i][j].setFont(new Font("Arial", Font.BOLD, 30));
                        GPanel.add(guesses[i][j]);
                    }
                }
                JTextField textField = new JTextField(5);
                GPanel.add(textField);

                textField.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String input = "";
                        if(guessNum < 6 && secretWord != input){
                            input = textField.getText();
                            String hint = "";
                            if(input.length() == 5){
                                for(int i = 0; i<5; i++){
                                    if(Character.toUpperCase(input.charAt(i)) == secretWord.charAt(i)){
                                        hint = String.valueOf(Character.toUpperCase(input.charAt(i)));
                                        guesses[guessNum][i].setText(hint);
                                        guesses[guessNum][i].setForeground(Color.green);
                                    }
                                    else if(secretWord.indexOf(Character.toUpperCase(input.charAt(i))) != -1){
                                        hint = String.valueOf(Character.toUpperCase(input.charAt(i)));
                                        guesses[guessNum][i].setText(hint);
                                        guesses[guessNum][i].setForeground(Color.yellow);
                                    }
                                    else{
                                        hint = String.valueOf(Character.toUpperCase(input.charAt(i)));
                                        guesses[guessNum][i].setText(hint);
                                        guesses[guessNum][i].setForeground(Color.red);
                                    }
                                }
                                textField.setText("");
                                guessNum ++;
                            }
                        }
                        if(secretWord.equalsIgnoreCase(input)){
                            GFrame.setTitle("You Win!");
                        }
                        else if(guessNum > 5){
                            GFrame.setTitle("You Lose!");
                            System.out.println(secretWord);
                        }
                        
                    }
                });


                GFrame.add(GPanel);
                GFrame.setTitle("");
                GFrame.setResizable(false);
                GFrame.setSize(300,500);
                GFrame.setLocationRelativeTo(null);
                GFrame.setVisible(true);
            }
            catch(IOException e){
                System.out.println("Whoops you done goofed up you're on your own for this one :)");
                System.out.println(e);
            }
    }
}
