import java.util.Scanner;

import com.dyma.game.Player;
import com.dyma.game.TicTacToe;
import com.dyma.exceptions.TicTacToeInvalidInputException;

public class App {
    public static void main(String[] args) throws Exception {
        final var game = new TicTacToe();

        var player = Player.FIRST;

        while (true) {
            try {
                System.out.println(game);
                System.out.println(player + " / Saisisser un nombre en 1 et 9 : ");
                final var inputUser = getInputUser();

                game.processInput(player, inputUser);

                if (game.checkWin()) {
                    System.out.println(game);
                    System.out.println("Le joueur " + player + " a gagné !");
                    break;
                }

                if (game.checkDraw()) {
                    System.out.println(game);
                    System.out.println("Égalité !");
                    break;
                }

                player = nextPlayer(player);
            } catch (TicTacToeInvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getInputUser() throws TicTacToeInvalidInputException {
        final var scanner = new Scanner(System.in);
        var input = scanner.nextInt();
        if (input < 1 || input > 9) {
            throw new TicTacToeInvalidInputException("Le chiffre doit être compris entre 1 et 9");
        }
        return input;

    }

    private static Player nextPlayer(Player player) {
        if (player == Player.FIRST) {
            return Player.SECOND;
        } else {
            return Player.FIRST;
        }
    }
}
