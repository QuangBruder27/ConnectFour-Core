package GameLogic;

import GameData.Board;

public interface Logic {

    /**
     * make multi moves. Used to test.
     *
     * @param columns
     */
     void makeMultiMoves(int[] columns, Board boardGame);

    /**
     * make a move
     *
     * @param column_nr
     * @return the number of row if successful; -1 if failed.
     */
     int makeMove(int column_nr, Board boardGame);

    /**
     * @param column_nr
     * @return true if this column can be filled.
     */
    boolean isMovable(int column_nr, Board boardGame);

    /**
     * @return true, if the player is victory in vertical lines.
     */
     boolean isVerticalWin(Board boardGame);

    /**
     * @return true, if the player is victory in horizontal lines.
     */
    boolean isHorizontalWin(Board boardGame);

    /**
     * @return true, if the player is victory in diogonal lines with the upward direction.
     */
    boolean isDiogonalUpWin(Board boardGame);

    /**
     * @return true, if the player is victory in diogonal lines with the downward direction.
     */
    boolean isDiogonalDownWin(Board boardGame);

    /**
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return true, if all four places with the same player.
     */
     boolean isSamePlayer(Board.Player p1, Board.Player p2, Board.Player p3, Board.Player p4);

    /**
     * change to the next player.
     */
    void changeCurrentPlayer(Board boardGame);

    /**
     * All types of victory are checked.
     *
     * @return true, if a type of victory happens.
     */
    boolean isVictory(Board boardGame);

    /**
     * @return true, if the game is drawn.
     */
    boolean isDrawn(Board boardGame);

    /**
     * @return true, if the game is finished.
     */
    boolean isFinished(Board boardGame);


}
