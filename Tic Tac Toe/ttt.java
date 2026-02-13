import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ttt {
    int playerTurn = 2;

    void switchturn(){
        if(playerTurn == 2){
            playerTurn = 1;
        }
        else{
            playerTurn = 2;
        }
    }



    Scanner userInput = new Scanner(System.in);
        
    boolean playerIn = true;
        
    ai aiPlayer = new ai();


    public void runTicTacToe(int userSelection){
        board gameBoard = new board();
        JFrame displayBoard;
        JPanel panel;
        displayBoard = new JFrame();
        
        System.out.println(userSelection);

        if(userSelection==1){
            System.out.println("enterred " + userSelection);
            playerTurn = 1;
            panel = new JPanel();
            panel.setBorder(BorderFactory.createMatteBorder(10,10,10,10, Color.BLACK));
            panel.setLayout(new GridLayout(3,3));
            JButton[][] button = new JButton[3][3];
            Font buttonFont = new Font("Arial", Font.PLAIN, 50);
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    button[i][j] = new JButton(" ");
                    button[i][j].setFont(buttonFont);
                    final int row = i;
                    final int col = j;
                    button[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            if(gameBoard.move(playerTurn, col, row) == 1){
                                if(playerTurn == 1){
                                    button[row][col].setText("X");
                                    if(!gameBoard.checkcont()){
                                        if(gameBoard.checkTie()){
                                            displayBoard.setTitle("Draw!");
                                        }
                                        else{
                                            displayBoard.setTitle("Player " + playerTurn + " wins!");
                                        }
                                    }
                                }
                                else{
                                    button[row][col].setText("O");
                                    if(!gameBoard.checkcont()){
                                        if(gameBoard.checkTie()){
                                            displayBoard.setTitle("Draw!");
                                        }
                                        else{
                                            displayBoard.setTitle("Player " + playerTurn + " wins!");
                                        }
                                    }
                                }
                                switchturn();
                            }
                        }
                    });
                    panel.add(button[i][j]);
                }
            }
            displayBoard.add(panel);
            displayBoard.setTitle("Tic - Tac - Toe");
            displayBoard.setResizable(true);
            displayBoard.setSize(500,500);
            displayBoard.setLocationRelativeTo(null);
            displayBoard.setVisible(true);
        }
        else{
            System.out.println("enterred " + userSelection);
            playerTurn = 1;
            panel = new JPanel();
            panel.setBorder(BorderFactory.createMatteBorder(10,10,10,10, Color.BLACK));
            panel.setLayout(new GridLayout(3,3));
            JButton[][] button = new JButton[3][3];
            Font buttonFont = new Font("Arial", Font.PLAIN, 50);
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    button[i][j] = new JButton(" ");
                    button[i][j].setFont(buttonFont);
                    final int row = i;
                    final int col = j;
                    button[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            if(gameBoard.move(playerTurn, col, row) == 1){
                                if(playerTurn == 1){
                                    button[row][col].setText("X");
                                    if(!gameBoard.checkcont()){
                                        if(gameBoard.checkTie()){
                                            displayBoard.setTitle("Draw!");
                                        }
                                        else{
                                            displayBoard.setTitle("Player " + playerTurn + " wins!");
                                        }
                                    }
                                }
                                else{
                                    button[row][col].setText("O");
                                    if(!gameBoard.checkcont()){
                                        if(gameBoard.checkTie()){
                                            displayBoard.setTitle("Draw!");
                                        }
                                        else{
                                            displayBoard.setTitle("Player " + playerTurn + " wins!");
                                        }
                                    }
                                }
                                switchturn();
                            }
                        }
                    });
                    panel.add(button[i][j]);
                }
            }

            displayBoard.add(panel);
            displayBoard.setTitle("Tic - Tac - Toe");
            displayBoard.setResizable(true);
            displayBoard.setSize(500,500);
            displayBoard.setLocationRelativeTo(null);
            displayBoard.setVisible(true);
            
            while(gameBoard.checkcont()){
                while(playerTurn == 2){
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e){
                    }
                    if(userSelection > 2){
                        board tempBoard = new board();
                        tempBoard.makeBoard(gameBoard.getBoard());
                        
                        moveresult move = aiPlayer.winMove(tempBoard);
                        if(move.getsuc()){
                           
                            button[move.getx()][move.gety()].doClick();
                            gameBoard.printBoard();
                            break;
                        }
                    }
                    if(userSelection == 4){
                        board tempBoard = new board();
                        tempBoard.makeBoard(gameBoard.getBoard());
                        moveresult move = aiPlayer.blockWin(tempBoard);
                        if(move.getsuc()){
                            button[move.getx()][move.gety()].doClick();
                            gameBoard.printBoard();
                            break;
                        }
                    }
                    
                    board tempBoard = new board();
                    tempBoard.makeBoard(gameBoard.getBoard());
                    moveresult move = aiPlayer.randomMove(tempBoard);
                    button[move.getx()][move.gety()].doClick();
                    break;
                }
            }
            
        }
        System.out.println("exits");
    }


}

