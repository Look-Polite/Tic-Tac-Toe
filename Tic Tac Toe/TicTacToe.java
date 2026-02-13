import java.util.Scanner;

public class TicTacToe {

    public void runTicTacToe(){

        Scanner userInput = new Scanner(System.in);
        
        boolean playerIn = true;
        
        ai aiPlayer = new ai();

        while(playerIn){
            System.out.println("Would you like to play a game of tic tac toe vs - ");
            System.out.println("    1. Another player");
            System.out.println("    2. Easy AI");
            System.out.println("    3. Medium AI");
            System.out.println("    4. Hard AI");
            System.out.println("    5. Exit");
            
            int userSelection = userInput.nextInt();

            if(userSelection == 5){
                playerIn = false;
                break;
            }

            else{
                board gameBoard = new board();
                int playerTurn = 2;
                
                while(gameBoard.checkcont()){
                    if(userSelection==1){
                        
                        if(playerTurn == 1){
                            playerTurn = 2;
                        }
                        else{
                            playerTurn = 1;
                        }
                        System.out.println("It is currently player " + playerTurn + "'s turn");
                        gameBoard.printBoard();

                        
                        boolean moveNotDone = true;

                        while(moveNotDone){
                            System.out.println();
                            System.out.println("Which tile would you like to select?");
                            System.out.println();
                            
                            int xmove = userInput.nextInt();
                            int ymove = userInput.nextInt();
                            if(xmove < 4 && ymove < 4){
                                if(gameBoard.move(playerTurn,xmove-1,ymove-1) == 1){
                                moveNotDone = false;
                                }
                            }
                        }
                    }
                    else{
                        while(gameBoard.checkcont()){
                            playerTurn = 1;
                            System.out.println("It is currently your turn");
                            gameBoard.printBoard();
                            boolean moveNotDone = true;
                            while(moveNotDone){
                                System.out.println();
                                System.out.println("Which tile would you like to select?");
                                System.out.println();
                                int xmove = userInput.nextInt();
                                int ymove = userInput.nextInt();
                                if(xmove < 4 && ymove < 4){
                                    if(gameBoard.move(1,xmove-1,ymove-1) == 1){
                                        moveNotDone = false;
                                    }
                                }
                            }
                            
                            if(!gameBoard.checkcont()){
                                break;
                            }
                            playerTurn = 2;
                            boolean aiMove = true;
                            while(aiMove){
                                if(userSelection != 2){
                                    if(!aiPlayer.winMove(gameBoard)){
                                        break;
                                    }
                                }
                                if(userSelection == 4){
                                    if(!aiPlayer.blockWin(gameBoard)){
                                        break;
                                    }
                                }
                                aiPlayer.randomMove(gameBoard);
                                aiMove=false;
                           
                            }
                        }
                    }
                }
                gameBoard.printBoard();
                System.out.println();

                if(gameBoard.checkTie()){
                    System.out.println("Draw!");
                }
                else{
                    if(playerTurn == 1){System.out.println("Congratulations! Player 1 wins!");
                    }
                    if(playerTurn == 2){System.out.println("Congratulations! Player 2 wins!");
                    }
                }
            } 
        }
    }
}

