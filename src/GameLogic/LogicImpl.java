package GameLogic;

import GameData.Board;

import static GameData.Board.COLUMNS;
import static GameData.Board.ROWS;

public class LogicImpl implements Logic {

    public boolean hasTurn(Board boardGame, Board.Player player){
        if (boardGame.getCurrentPlayer() != player) return true;
        return false;
    }

    @Override
    public void makeMultiMoves(int[] columns, Board boardGame) {
        for (int i=0; i< columns.length;i++){
            makeMove(columns[i], boardGame);
        }
    }

    @Override
    public int makeMove(int column_nr, Board boardGame) {
        System.out.println("Make move");
        if (!isMovable(column_nr, boardGame)) return -1;
        for (int i= 0; i< ROWS; i++){
            if(boardGame.board[i][column_nr] == Board.Player.NONE){
                boardGame.board[i][column_nr] = boardGame.getCurrentPlayer();
                changeCurrentPlayer(boardGame);
                //movesCounter++;
                //lastColumn = column_nr;
                // this.lastRow = i;
                boardGame.setMovesCounter(boardGame.getMovesCounter()+1);
                boardGame.setLastRow(i);
                boardGame.setLastColumn(column_nr);
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isMovable(int column_nr, Board boardGame) {
        if (boardGame.getMovesCounter() >= (COLUMNS*ROWS) || column_nr < 0  || column_nr >= COLUMNS) return false;
        if(boardGame.board[ROWS-1][column_nr] == Board.Player.NONE){
            return true;
        } else {
            System.out.println("Not movable column="+column_nr);
            return false;
        }
    }

    @Override
    public boolean isVerticalWin(Board boardGame) {
        int lastRow = boardGame.getLastRow();
        int lastColumn = boardGame.getLastColumn();
        Board.Player[][] board = boardGame.board;

        if(lastRow>2 && isSamePlayer(board[lastRow-3][lastColumn], board[lastRow-2][lastColumn],
                board[lastRow-1][lastColumn],board[lastRow][lastColumn])
                && board[lastRow][lastColumn] != Board.Player.NONE){
            System.out.println("Vertical Winner");
            return true;
        }
        return false;
    }

    // Correct
    @Override
    public boolean isHorizontalWin(Board boardGame) {
        int lastRow = boardGame.getLastRow();
        int lastColumn = boardGame.getLastColumn();
        Board.Player[][] board = boardGame.board;

        for (int i= lastColumn; i< lastColumn+4 ; i++){
            if(i-3 >= 0  && i<COLUMNS && null != board[lastRow][i-3] && null != board[lastRow][i-2] && null != board[lastRow][i-1]) {
                if(isSamePlayer(board[lastRow][i-3], board[lastRow][i-2],
                        board[lastRow][i-1], board[lastRow][i])
                        && board[lastRow][i] != Board.Player.NONE){
                    System.out.println("i = "+i+", row="+ lastRow + " Horizontal Winner");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isDiogonalUpWin(Board boardGame) {
        int lastRow = boardGame.getLastRow();
        int lastColumn = boardGame.getLastColumn();
        Board.Player[][] board = boardGame.board;

        int i = lastRow;
        int j = lastColumn;
        while( i< lastRow+4){
            if(i-3>= 0 && j-3>=0 && i< ROWS && j< COLUMNS && null != board[i-3][j-3] && null != board[i-2][j-2] && null != board[i-1][j-1]) {
                if(isSamePlayer(board[i-3][j-3], board[i-2][j-2],
                        board[i-1][j-1], board[i][j])
                        && board[i][j] != Board.Player.NONE){
                    System.out.println("Diogonal Up Winner");
                    return true;
                }
            }
            i++;
            j++;
        }
        return false;
    }

    @Override
    public boolean isDiogonalDownWin(Board boardGame) {
        int lastRow = boardGame.getLastRow();
        int lastColumn = boardGame.getLastColumn();
        Board.Player[][] board = boardGame.board;

        int i = lastRow+3;
        int j = lastColumn-3;
        while( i>= lastRow ){
            if(i-3>=0 && i<ROWS && j+3< COLUMNS && j>= 0 && null != board[i-3][j+3] && null != board[i-2][j+2] && null != board[i-1][j+1]) {
                if(isSamePlayer(board[i-3][j+3], board[i-2][j+2],
                        board[i-1][j+1], board[i][j])
                        && board[i][j] != Board.Player.NONE){
                    System.out.println("Diogonal Down Winner");
                    return true;
                }
            }
            i--;
            j++;
        }
        return false;
    }

    @Override
    public boolean isSamePlayer(Board.Player p1, Board.Player p2, Board.Player p3, Board.Player p4) {
        if(p1==p2 && p2==p3 && p3==p4){
            return true;
        }
        return false;
    }

    @Override
    public void changeCurrentPlayer(Board boardGame) {
        if (boardGame.getCurrentPlayer() == Board.Player.ONE){
            boardGame.setCurrentPlayer(Board.Player.TWO);
        } else {
            boardGame.setCurrentPlayer(Board.Player.ONE);
        }
    }

    @Override
    public boolean isVictory(Board boardGame) {
        if(isVerticalWin(boardGame) || isHorizontalWin(boardGame) || isDiogonalDownWin(boardGame) || isDiogonalUpWin(boardGame)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isDrawn(Board boardGame) {
        if(!this.isVictory(boardGame) && boardGame.getMovesCounter() >= 42){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinished(Board boardGame) {
        if (isDrawn(boardGame) || isVictory(boardGame)){
            return true;
        }
        return false;
    }



}
