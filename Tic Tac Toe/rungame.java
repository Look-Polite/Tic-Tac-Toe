import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class rungame {
    ttt game = new ttt();
    public void askGame(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.black));
        panel.setLayout(new GridLayout(5,1));
        JLabel label = new JLabel("Would you like to play a game of tic tac toe vs - ");
        panel.add(label);
        JButton player = new JButton("    1. Another player");
        player.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                game.runTicTacToe(1);
            }
        });
        panel.add(player);

        JButton easy = new JButton("    2. Easy AI");
        easy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent b){
                game.runTicTacToe(2);
            }
        });
        panel.add(easy);

        JButton med = new JButton("    3. Medium AI");
        med.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent c){
                game.runTicTacToe(3);
            }
        });
        panel.add(med);

        JButton hard = new JButton("    4. Hard AI");
        hard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent d){
                game.runTicTacToe(4);
            }
        });
        panel.add(hard);
        
        frame.add(panel);
        frame.setSize(300,500);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Select your Gamemode");
        frame.setVisible(true);
    }
}
