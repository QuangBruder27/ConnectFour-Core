package GameLogic;

import GameData.Board;
import GameData.BoardImpl;
import org.junit.Before;
import org.junit.Test;


public class LogicTest {

    Logic gameLogic;
    Board boardGame;

    @Before
    public void setUp() {
        boardGame = new BoardImpl();
        gameLogic = new LogicImpl();
        boardGame.cleanBoard();
    }

    @Test
    public void makeMove() {
        gameLogic.makeMove(0, boardGame);
        assert(boardGame.getMovesCounter() >0);
    }

    @Test
    public void isHorizontalWin1(){
        int [] columns = {0,4,1,4,2,4,3};
        gameLogic.makeMultiMoves(columns, boardGame);
        //game.printBoard();
        assert (gameLogic.isHorizontalWin(boardGame));
    }

    @Test
    public void isHorizontalWin2(){
        int [] columns = {1,0,2,0,4,0,3};
        gameLogic.makeMultiMoves(columns, boardGame);
        //game.printBoard();
        assert (gameLogic.isHorizontalWin(boardGame));
    }

    @Test
    public void isVerticalWin1(){
        int [] columns = {0,0,0,1,0,1,0,1,0};
        gameLogic.makeMultiMoves(columns, boardGame);
        boardGame.printBoard();
        assert (gameLogic.isVerticalWin(boardGame));
    }

    @Test
    public void isVerticalWin2(){
        int [] columns = {6,1,6,1,6,1,6};
        gameLogic.makeMultiMoves(columns, boardGame);
        //game.printBoard();
        assert (gameLogic.isVerticalWin(boardGame));
    }

    @Test
    public void isDiogonalUpWin1(){
        int [] columns = {5,1,1,2,3,2,2,3,3,4,3,5,0};
        gameLogic.makeMultiMoves(columns, boardGame);
        assert (gameLogic.isDiogonalUpWin(boardGame));
    }

    @Test
    public void isDiogonalUpWin2(){
        int [] columns = {1,0,0,1,1,2,2,2,5,3,3,3,3,4,3,5,2};
        gameLogic.makeMultiMoves(columns, boardGame);
        //game.printBoard();
        assert (gameLogic.isDiogonalUpWin(boardGame));
    }

    @Test
    public void isDiogonalDownWin1(){
        int [] columns = {2,2,2,3,3,1,1,1,1,0,4};
        gameLogic.makeMultiMoves(columns, boardGame);
        boardGame.printBoard();
        assert (gameLogic.isDiogonalDownWin(boardGame));
    }

    @Test
    public void isDiogonalDownWin2(){
        int [] columns = {0,0,0,1,1,2,1,4,2,5,3,6,0};
        gameLogic.makeMultiMoves(columns, boardGame);
        boardGame.printBoard();
        assert (gameLogic.isDiogonalDownWin(boardGame));
    }

    @Test
    public void changeCurrentPlayerTest(){
        gameLogic.changeCurrentPlayer(boardGame);
        assert (boardGame.getCurrentPlayer().equals(Board.Player.TWO));
    }

}