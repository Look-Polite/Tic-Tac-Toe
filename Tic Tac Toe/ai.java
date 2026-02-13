import java.util.Random;

public class ai {
    public moveresult randomMove(board gameBoard){
        moveresult move = new moveresult();
        Random rdm = new Random();
        int xcord;
        int ycord;
        boolean moveNotDone = true;
        while(moveNotDone){
            xcord = rdm.nextInt(3);
            ycord = rdm.nextInt(3);
            if(gameBoard.move(2,xcord,ycord)==1){
                moveNotDone = false;
                move.sucset(true);
                move.xset(ycord);
                move.yset(xcord);
            }
        }
        return move;
    }

    public moveresult winMove(board gameBoard){
        moveresult move = new moveresult();
        move.sucset(false);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board tempBoard = new board();
                tempBoard.makeBoard(gameBoard.getBoard());
                tempBoard.move(2, i, j);
                if(!tempBoard.checkcont()){
                    gameBoard.move(2, i, j);
                    move.xset(j);
                    move.yset(i);
                    move.sucset(true);
                    return move;
                }
                
            }
        }
        return move;
    }

    public moveresult blockWin(board gameBoard){
        moveresult move = new moveresult();
        move.sucset(false);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board tempBoard = new board();
                tempBoard.makeBoard(gameBoard.getBoard());
                tempBoard.move(1, i, j);
                if(!tempBoard.checkcont()){
                    gameBoard.move(2, i, j);
                    move.xset(j);
                    move.yset(i);
                    move.sucset(true);
                    return move;
                }
                
            }
        }
        return move;
    }

}
