import cs3331Helper.cs3331TicTacToeBoard;
import cs3331Helper.cs3331TicTacToeController;
import cs3331Helper.cs3331TicTacToeGame;
import javafx.scene.paint.Color;

public class TicTacToe implements cs3331TicTacToeGame {

    private final cs3331TicTacToeBoard board;
    private final cs3331TicTacToeController controller;

    public TicTacToe() {
        this.board = new cs3331TicTacToeBoard();
        this.controller = new cs3331TicTacToeController();

        this.controller.addPlayer(new Player("X", this));
        this.controller.addPlayer(new Player("O", this));
    }

    public cs3331TicTacToeBoard getBoard() {
        return this.board;
    }

    public cs3331TicTacToeController getController() {
        return this.controller;
    }

    @Override
    public void invalidSquareChosen(int row, int col) {
        this.controller.setControllerMessage("Square chosen has already been taken. Try again.");
        this.board.squareAt(row, col).flashColor(Color.RED);
    }

    @Override
    public void playerWins() {
        this.controller.setControllerMessage("Player " + this.controller.getWinningPlayer() + " wins.");
        this.board.highlightWinningSquares(Color.LIME);
    }

    @Override
    public void restartGame() {
        this.controller.setControllerMessage("Select a square to start playing.");
        this.board.clearSymbols();
        this.controller.playAgain();
    }

    @Override
    public void noWinner() {
        this.controller.setControllerMessage("It's a tie.");
    }

}
