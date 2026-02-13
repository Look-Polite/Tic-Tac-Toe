public class board{

    private int[][] gameBoard = new int[3][3];

    public board(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gameBoard[i][j] = 0;
            }
        }
    }

    public void makeBoard(int[][] array){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gameBoard[i][j] = array[i][j];
            }
        }
    }

    public int move(int player, int xcord, int ycord){
        if(gameBoard[ycord][xcord] == 0){
            gameBoard[ycord][xcord] = player;
            return 1;
        }
        return 0;
    }

    public boolean checkcont(){
        for(int i = 0; i < 3; i++){
            if(gameBoard[i][0]==gameBoard[i][1] && gameBoard[i][1]==gameBoard[i][2] && gameBoard[i][0] != 0){
                return false;
            }
        }

        for(int j = 0; j < 3; j++){
            if(gameBoard[0][j]==gameBoard[1][j] && gameBoard[1][j]==gameBoard[2][j] && gameBoard[0][j] != 0){
                return false;
            }
        }
        
        if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][2] && gameBoard[0][0] != 0){
            return false;
        }
        
        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1]==gameBoard[0][2] && gameBoard[1][1] != 0){
            return false;
        }
        
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3 ;j++){
                if(gameBoard[i][j] == 0){
                    return true;
                }
            }
        }

        return false;
    }
    
    public boolean checkTie(){
        for(int i = 0; i < 3; i++){
            if(gameBoard[i][0]==gameBoard[i][1] && gameBoard[i][1]==gameBoard[i][2] && gameBoard[i][0] != 0){
                return false;
            }
        }

        for(int j = 0; j < 3; j++){
            if(gameBoard[0][j]==gameBoard[1][j] && gameBoard[1][j]==gameBoard[2][j] && gameBoard[0][j] != 0){
                return false;
            }
        }
        
        if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][2] && gameBoard[0][0] != 0){
            return false;
        }
        
        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1]==gameBoard[0][2] && gameBoard[1][1] != 0){
            return false;
        }
        return true;
    }

    public int[][] getBoard(){
        return gameBoard;
    }

    public void printBoard(){
        
        String playerToken;

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(gameBoard[i][j] == 0){
                    playerToken = " ";
                }
                else if(gameBoard[i][j] == 1){
                    playerToken = "X";
                }
                else{
                    playerToken = "O";
                }
                System.out.print(playerToken);
                if(j<2){
                    System.out.print("|");
                }
            }
        System.out.println();
            if(i<2){
                System.out.println("- - -");
            }
        }
    }

}