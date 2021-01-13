package GameData;


public class BoardImpl implements Board{

    int movesCounter = 0;
    int lastColumn = 0;
    int lastRow = 0;
    Player currentPlayer = Board.Player.ONE;

    @Override
    public void printBoard() {
        Player cfPlayer;
        for (int i = ROWS - 1; i > -1; i--) {
            for (int j = 0; j < COLUMNS; j++) {
                cfPlayer = board[i][j];
                if (cfPlayer == Player.NONE) {
                    System.out.print("-");
                } else if (cfPlayer == Player.ONE) {
                    System.out.print("x");
                } else {
                    System.out.print("o");
                }
            }
            System.out.println("");
        }
    }

    @Override
    public void cleanBoard() {
        for (int i=0; i< ROWS;i++){
            for (int j=0; j< COLUMNS;j++){
                this.board[i][j] = Player.NONE;
            }
        }
        System.out.println("Board is ready for a new game!");
    }

    @Override
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }

    @Override
    public int getMovesCounter() {
        return movesCounter;
    }

    @Override
    public void setMovesCounter(int counter) {
        this.movesCounter = counter;
    }

    @Override
    public int getLastColumn() {
        return this.lastColumn;
    }

    @Override
    public void setLastColumn(int column) {
        this.lastColumn = column;
    }

    @Override
    public int getLastRow() {
        return this.lastRow;
    }

    @Override
    public void setLastRow(int row) {
        this.lastRow = row;
    }


}
