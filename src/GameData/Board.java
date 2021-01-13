package GameData;


public interface Board {

    /**
     * Every place on the board is marked;
     * NONE: not filled,
     * ONE: filled by the first player,
     * TWO: filled by the second player,
     */
    enum Player {
        NONE,
        ONE,
        TWO
    }

    int COLUMNS = 7;
    int ROWS = 6;
    Player[][] board = new Player[ROWS][COLUMNS];

    /**
     *  print the current game board in console
     */
    void printBoard();

    /**
     * all places in board are set to NONE to start a new game.
     */
    void cleanBoard();

    /**
     * @return the next player.
     */
    Player getCurrentPlayer();

    /**
     * set the current player
     * @param p
     */
    void setCurrentPlayer(Player p);

    /**
     * @return the number of the movements.
     */
    int getMovesCounter();


    /**
     * set the number of the movements
     * @param counter
     */
    void setMovesCounter(int counter);

    /**
     * get the number of the column by the last movement
     * @return the number of column
     */
    int getLastColumn();

    /**
     * set the number of the column by the last movement
     * @param column
     */
    void setLastColumn(int column);

    /**
     *  get the number of the row by the last movement
     * @return the number of the row
     */
    int getLastRow();

    /**
     * set the number of the row by the last movement
     * @param row
     */
    void setLastRow(int row);

}
