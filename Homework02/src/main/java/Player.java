import cs3331Helper.cs3331TicTacToeController;
import cs3331Helper.cs3331TicTacToePlayer;

public class Player implements cs3331TicTacToePlayer {

    private final String letter;
    private final TicTacToe game;

    public Player(String letter, TicTacToe game) {
        if (!letter.equalsIgnoreCase("X") && !letter.equalsIgnoreCase("O")) {
            throw new IllegalArgumentException("Letter must be either X or O");
        }

        this.letter = letter;
        this.game = game;
    }

    @Override
    public void selectSquare(int row, int col) {
        this.game.getBoard().squareAt(row, col).markSquare(this.letter);

        cs3331TicTacToeController controller = this.game.getController();

        controller.setControllerMessage("Player " + this.letter + " finished their turn.");
        controller.finishedTurn();
    }

    @Override
    public String toString() {
        return this.letter;
    }

}
