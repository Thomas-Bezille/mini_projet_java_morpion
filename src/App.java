import java.util.Scanner;

import com.dyma.game.Player;
import com.dyma.game.TicTacToe;

public class App {
    public static void main(String[] args) throws Exception {
        final var scanner = new Scanner(System.in);
        final var game = new TicTacToe();

        var player = Player.FIRST;

        while (true) {
            System.out.println(game);
            System.out.println(player + " / Saisisser un nombre en 1 et 9 : ");
            final var inputUser = scanner.nextInt();

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
        }
    }

    private static Player nextPlayer(Player player) {
        if (player == Player.FIRST) {
            return Player.SECOND;
        } else {
            return Player.FIRST;
        }
    }
}
