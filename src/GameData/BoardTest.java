package GameData;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    Board boardGame;

    @Before
    public void setUp() {
        boardGame = new BoardImpl();
        boardGame.cleanBoard();
    }


    @Test
    public void getCurrentPlayer() {
        assert(boardGame.getCurrentPlayer().equals(Board.Player.ONE));
    }

    @Test
    public void setCurrentPlayer() {
        boardGame.setCurrentPlayer(Board.Player.TWO);
        assert(boardGame.getCurrentPlayer().equals(Board.Player.TWO));
    }

    @Test
    public void getMovesCounter() {
        assert(boardGame.getMovesCounter() == 0);
    }

    @Test
    public void setMovesCounter() {
        boardGame.setMovesCounter(5);
        assert(boardGame.getMovesCounter() == 5);
    }

    @Test
    public void getLastColumn() {
        assert(boardGame.getLastColumn() == 0);
    }

    @Test
    public void setLastColumn() {
        boardGame.setLastColumn(4);
        assert(boardGame.getLastColumn() == 4);
    }

    @Test
    public void getLastRow() {
        assert(boardGame.getLastRow() == 0);
    }

    @Test
    public void setLastRow() {
        boardGame.setLastRow(3);
        assert(boardGame.getLastRow() == 3);
    }
}