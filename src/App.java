import java.util.HashMap;
import java.util.Scanner;

import com.dyma.game.Player;
import com.dyma.game.TicTacToe;
import com.dyma.exceptions.TicTacToeInvalidInputException;
import static com.dyma.game.StringConstants.BLANK;

public class App {
    public static void main(String[] args) throws Exception {
        final var game = new TicTacToe();

        var player = Player.FIRST;
        var players = initPlayers();

        while (true) {
            try {
                System.out.println(game);
                System.out.println(players.get(player) + " / Saisisser un nombre en 1 et 9 : ");
                final var inputUser = getInputUser();

                game.processInput(player, inputUser);

                if (game.checkWin()) {
                    System.out.println(game);
                    System.out.println("Le joueur " + players.get(player) + " a gagné !");
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
            } catch (NumberFormatException e) {
                System.err.println("Vous devez saisir un chiffre entre 1 et 9");
            }
        }
    }

    private static HashMap<Player, String> initPlayers() {
        var players = new HashMap<Player, String>();
        var scanner = new Scanner(System.in);

        do {
            System.out.println("Saisir le nom du joueur 1 : ");
            players.put(Player.FIRST, scanner.nextLine());
        } while (players.get(Player.FIRST).equals(BLANK));
        do {
            System.out.println("Saisir le nom du joueur 2 : ");
            players.put(Player.SECOND, scanner.nextLine());
        } while (players.get(Player.SECOND).equals(BLANK));
        return players;
    }

    private static int getInputUser() throws TicTacToeInvalidInputException {
        final var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        if (input.equals("exit") || input.equals("quit")) {
            System.exit(0);
        }
        var inputEntier = Integer.parseInt(input);
        if (inputEntier < 1 || inputEntier > 9) {
            throw new TicTacToeInvalidInputException("Le chiffre doit être compris entre 1 et 9");
        }
        return inputEntier;
    }

    private static Player nextPlayer(Player player) {
        if (player == Player.FIRST) {
            return Player.SECOND;
        } else {
            return Player.FIRST;
        }
    }
}
